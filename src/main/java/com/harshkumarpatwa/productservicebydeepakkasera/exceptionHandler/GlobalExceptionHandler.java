package com.harshkumarpatwa.productservicebydeepakkasera.exceptionHandler;

import com.harshkumarpatwa.productservicebydeepakkasera.dto.ExceptionDto;
import com.harshkumarpatwa.productservicebydeepakkasera.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Arithmetic exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Array Index Out of Bound exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid productId " + productNotFoundException.getId() + " passed");
        dto.setResolution("Product Not Found Exception caught");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
