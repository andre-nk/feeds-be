package id.workers.feeds.controller

import id.workers.feeds.model.GenericResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException) : GenericResponse<String> {
        return GenericResponse(
            code = 400,
            status = "Bad Request",
            data = constraintViolationException.message!!
        )
    }
}
