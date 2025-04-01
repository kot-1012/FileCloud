# 🌩️ Облачное хранилище "FileCloud" 1

FileCloud — это современный REST-сервис, который позволяет пользователям безопасно загружать, хранить и управлять своими файлами. Проект включает в себя backend на **Spring Boot** и frontend на **Vue.js**, а также использует **PostgreSQL** для хранения данных.  

## 🚀 Основные возможности:

✅ Авторизация и аутентификация пользователей  
✅ Загрузка, скачивание и удаление файлов  
✅ Хранение информации о пользователях и файлах в базе данных  
✅ Удобный web-интерфейс на Vue.js  
✅ Защита API с помощью JWT-токенов  
✅ Запуск через Docker (Backend + Frontend + Database)  

---

## 🛠️ Используемые технологии

### **Backend (Spring Boot, Java 11)**
- **Spring Boot** — быстрая разработка REST API  
- **Spring Security + JWT** — аутентификация и безопасность  
- **PostgreSQL** — реляционная база данных  
- **Spring Data JPA** — ORM для работы с базой  
- **Swagger** — автоматическая документация API  
- **JUnit + Mockito** — юнит-тестирование  
- **Testcontainers** — интеграционные тесты в Docker  

### **Frontend (Vue.js, Node.js 15)**
- **Vue.js** — динамический и удобный UI  
- **Vuex** — управление состоянием  
- **Vue Router** — маршрутизация  
- **Axios** — HTTP-запросы к API  
- **Bootstrap / Tailwind CSS** — стилизация  

### **Инфраструктура**
- **Docker + Docker Compose** — развертывание контейнеров  
- **GitHub** — хранение кода  
- **CI/CD (GitHub Actions, Jenkins)** — автоматизация сборки и тестирования  

---

## 📂 Структура проекта

```
/FileCloud
├── src/                     # Backend (Spring Boot)
│   ├── src/main/java/ru/files/cloud  # Код приложения
│   ├── src/main/resources/  # Файлы конфигурации (application.yml)
│   ├── Dockerfile           # Инструкция для контейнера backend
│   ├── ...
├── diplom-frontend/         # Frontend (Vue.js)
│   ├── src/components/      # Компоненты Vue
│   ├── src/stores/          # Vuex хранилище
│   ├── src/views/           # Страницы приложения
│   ├── Dockerfile           # Инструкция для контейнера frontend
│   ├── package.json         # Зависимости npm
│   ├── ...
├── docker-compose.yml       # Конфигурация Docker
├── README.md                # Описание проекта
├── target                   # Собранные .jar файлы
├── pom.xml                  # Зависимости Maven
└── ...
```

---

## 🔥 Запуск приложения  

### 1️⃣ Клонируем репозиторий  
```sh
git clone https://github.com/kot-1012/FileCloud.git
cd FileCloud
```

### 2️⃣ Запускаем Docker и собираем Backend  
```sh
mvn clean package -DskipTests
```

### 3️⃣ Запускаем все контейнеры (Backend + Frontend + PostgreSQL)  
```sh
docker-compose up
```

Приложения будут доступны по адресам:  
- **Backend:** `http://localhost:8080`  
- **Frontend:** `http://localhost:8090`  
- **PostgreSQL:** `http://localhost:5432`  

---

## 🔐 Авторизация и API

Для работы с API требуется **JWT-токен**, который можно получить при входе в систему.

### 🔑 Авторизация
**POST** `http://localhost:8080/login`  
```json
{
  "login": "user@test.com",
  "password": "Qwerty1234"
}
```
**Ответ:**
```json
{
  "auth-token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVC..."
}
```
Токен используется в заголовках при последующих запросах:
```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVC...
```

### 📃 Основные методы API:

| Метод | URL | Описание |
|--------|-----------------------------|--------------------------------|
| **POST** | `/login` | Авторизация |
| **POST** | `/users/create` | Регистрация пользователя |
| **GET** | `/files` | Получить список файлов |
| **POST** | `/files/upload` | Загрузить файл |
| **DELETE** | `/files/{id}` | Удалить файл |

Полная документация доступна в Swagger:  
📌 `http://localhost:8080/swagger-ui/index.html`

---

## 🎨 Запуск Frontend (Vue.js) отдельно

1. Установите **Node.js** (14.15.0 или выше)  
2. Перейдите в папку **frontendApp** и установите зависимости:  
   ```sh
   cd diplom-frontend
   npm install
   ```
3. Укажите URL backend-сервера в `.env`:  
   ```
   VUE_APP_BASE_URL=http://localhost:8080
   ```
4. Запустите фронтенд:  
   ```sh
   npm run serve
   ```
5. Откройте в браузере: **`http://localhost:8090`**

---

## 📊 Безопасность

✔️ **JWT-токены** для авторизации пользователей  
✔️ **Шифрование паролей** с использованием **BCrypt**  
✔️ **CORS-защита** для взаимодействия с frontend  
✔️ **Ограничение доступа** к API  
✔️ **Резервное копирование БД** через Docker Volume  

---

## 🔄 Возможные улучшения

🚀 **Хранение файлов в S3 (AWS, Yandex Cloud)**  
🚀 **Добавление функционала просмотра файлов онлайн**  
🚀 **Поддержка WebSocket для уведомлений**  
🚀 **Оптимизация запросов к базе данных**  
🚀 **Добавление многофакторной аутентификации**  

---

## 📢 Контакты

📧 Email: kot-1012@FileCloud.info  
🔗 GitHub: [kot-1012/FileCloud](https://github.com/kot-1012/FileCloud)  
📄 Лицензия: MIT  

---

### 🔥 FileCloud — безопасное и удобное облачное хранилище! 🚀
