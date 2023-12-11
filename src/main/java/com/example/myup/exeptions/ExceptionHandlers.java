package com.example.myup.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ExceptionDto dto = ExceptionDto.builder()
                .message("The values entered are incorrect")
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
//        ExceptionDto dto = ExceptionDto.builder()
//                .message("مقادیر وارد شده اشتباه است")
//                .errorCode(HttpStatus.BAD_REQUEST.value())
//                .timestamp(new Date())
//                .build();
//        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//    }

}
