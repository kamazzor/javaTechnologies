package ru.javacourse.collectionexample;

// Пример класса, в котором используется generic

public class TestGenericClass<T> {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
