package ru.netology.reset.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// аннотация, указывает, что этот класс обрабатывает исключения для всех контроллеров в приложении
@RestControllerAdvice
public class ExceptionHandlerController {

    // метод, обрабатывает исключение InvalidCredentials
    @ExceptionHandler(InvalidCredentials.class)
    // возвращает HTTP статус 400 (Bad Request) при возникновении этого исключения
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials(InvalidCredentials e) {
        return e.getMessage();
    }

    // метод, который будет обрабатывать исключение UnauthorizedUser
    @ExceptionHandler(UnauthorizedUser.class)
    // возвращает HTTP статус 401 (Unauthorized) при возникновении этого исключения
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser(UnauthorizedUser e) {
        System.err.println(e.getMessage());
        return e.getMessage();
    }
}
