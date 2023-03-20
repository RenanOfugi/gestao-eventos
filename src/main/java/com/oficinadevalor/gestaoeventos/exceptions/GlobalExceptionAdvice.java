package com.oficinadevalor.gestaoeventos.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DefaultException> handlerEntityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DefaultException(404, exception.getMessage()));
    }

    @ExceptionHandler(EntityNotAllowedException.class)
    public ResponseEntity<DefaultException> handlerEntityNotAllowedException(EntityNotAllowedException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultException(400, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultErrorsViolations> handleConstraintViolationException(MethodArgumentNotValidException e) {
        List<String> errors = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorsViolations(errors));
    }

}
