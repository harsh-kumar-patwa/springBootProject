package com.harshkumarpatwa.productservicebydeepakkasera.exceptions;

public class CategoryNotFoundException extends RuntimeException {
//    private Long id;
    public CategoryNotFoundException(String message){
        super(message);
//        this.id = id;
    }
}
