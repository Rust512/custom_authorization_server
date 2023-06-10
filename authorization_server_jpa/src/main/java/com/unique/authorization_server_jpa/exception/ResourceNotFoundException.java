package com.unique.authorization_server_jpa.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, String resourceProperty, String resourcePropertyValue) {
        super(String.format("The resource %s with '%s' = '%s' was not found", resourceName, resourceProperty, resourcePropertyValue));
    }
}
