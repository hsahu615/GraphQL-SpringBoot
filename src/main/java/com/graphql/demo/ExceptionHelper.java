package com.graphql.demo;

public class ExceptionHelper {
    public static RuntimeException resourceNotFoundException() {
        return new RuntimeException("Resource Not Found!");
    }
}
