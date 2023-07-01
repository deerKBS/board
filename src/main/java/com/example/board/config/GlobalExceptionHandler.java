package com.example.board.config;

import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ApiResult<?> handleAllExceptions(BaseException ex) {
        return Apiutils.error(ex.getApiError());
    }
}
