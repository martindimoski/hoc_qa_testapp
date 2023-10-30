package io.intertec.qa.performance.testapp.exceptions.handlers;

import io.intertec.qa.performance.testapp.api.error.ApiError;
import io.intertec.qa.performance.testapp.exceptions.DuplicateUserException;
import io.intertec.qa.performance.testapp.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ApiError> notFoundException(NotFoundException ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(
                createErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateUserException.class)
    private ResponseEntity<ApiError> duplicateUserException(DuplicateUserException ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(
                createErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    private ApiError createErrorResponse(int status, String message) {
        return createErrorResponse(status, message, null);
    }

    private ApiError createErrorResponse(int status, String message, Integer errorCode) {
        return ApiError.builder()
                .withStatus(status)
                .withMessage(message)
                .withError(errorCode)
                .build();
    }
}
