package com.example.board.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private final String message;
    private final int status;

    public ApiError(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
