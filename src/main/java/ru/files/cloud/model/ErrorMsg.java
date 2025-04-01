package ru.files.cloud.model;

import lombok.Data;

@Data
public class ErrorMsg {
    private final String message;
    private final long id;
}
