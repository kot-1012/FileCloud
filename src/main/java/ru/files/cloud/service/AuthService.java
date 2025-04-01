package ru.files.cloud.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import ru.files.cloud.dto.UserDto;
import ru.files.cloud.entities.User;
import ru.files.cloud.exception.InvalidInputData;
import ru.files.cloud.exception.UserNotFoundException;
import ru.files.cloud.model.Login;
import ru.files.cloud.repository.UserRepository;
import ru.files.cloud.security.JwtProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public Login login(@NonNull UserDto userDto) {
        log.info("Find user in database by login: {}", userDto.getLogin());
        User userFromDatabase = findUserInStorage(userDto.getLogin());
        if (isEquals(userDto, userFromDatabase)) {
            String accessToken = jwtProvider.generateAccessToken(userFromDatabase);
            return new Login(accessToken);
        } else {
            throw new InvalidInputData("Wrong password", 0);
        }
    }

    private boolean isEquals(UserDto userDto, User userFromDatabase) {
        return passwordEncoder.matches(userDto.getPassword(), userFromDatabase.getPassword());
    }

    public String logout(String authToken, HttpServletRequest request,
                         HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currUser = findUserInStorage(auth.getName());
        SecurityContextLogoutHandler securityContextLogoutHandler =
                new SecurityContextLogoutHandler();
        if (currUser != null) {
            securityContextLogoutHandler.logout(request, response, auth);
            jwtProvider.addAuthTokenInBlackList(authToken);
            log.info("AuthToken add in blacklist : {}", authToken);
            return currUser.getLogin();
        }
        return null;
    }

    private User findUserInStorage(String login) {
        return userRepository.findUserByLogin(login).orElseThrow(() ->
                new UserNotFoundException("User not found by login", 0));
    }
}