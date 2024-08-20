package com.jtc.LogisticCommodities.LogisticCommodity.ExceptionController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class CommodityException extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchCommodityException(NoSuchElementException noSuchElementException)
    {
        return new ResponseEntity<>("No Such Input",HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatusCode status,
                                                               WebRequest request) {
        Map<String, Object> responseObject = new LinkedHashMap<>();
        responseObject.put("timestamp :", new Date());
        responseObject.put("status :", status);
        List<String> stringList = new ArrayList<>();
        List<FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError: fieldErrorList)
        {
            stringList.add(fieldError.getField());
        }
        responseObject.put("Error Message :", stringList);
        return new ResponseEntity<>(responseObject,headers,status);
    }
}
