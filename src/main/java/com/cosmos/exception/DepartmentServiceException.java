package com.cosmos.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DepartmentServiceException extends Exception{
    public DepartmentServiceException(String s) {
        super(s);
    }
}
