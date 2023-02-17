package ru.otus.objectpool;

public class ObjectPoolMaxSizeException extends RuntimeException {
    public ObjectPoolMaxSizeException(int maxSize) {
        super("Cannot create object. Reached maximum pool size of " + maxSize + " objects.");
    }
}
