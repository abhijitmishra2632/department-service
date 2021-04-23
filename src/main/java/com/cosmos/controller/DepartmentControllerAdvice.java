package com.cosmos.controller;

import com.cosmos.exception.DepartmentServiceException;
import com.cosmos.pojo.DepartmentError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class DepartmentControllerAdvice {

    @ExceptionHandler(DepartmentServiceException.class)
    public ResponseEntity<DepartmentError> errorCreator(DepartmentServiceException ex){
        log.error("Advice got called "+ex.getMessage());
        DepartmentError departmentError = new DepartmentError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        return new ResponseEntity<DepartmentError>(departmentError,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
