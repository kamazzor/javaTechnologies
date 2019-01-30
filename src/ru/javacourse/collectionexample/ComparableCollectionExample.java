package ru.javacourse.collectionexample;

// Пример реализации новой коллекции с элементами, которые можно сравнивать
// благодаря имплементации метода compareTO интерфейса Comparable

//Пример класса с возможностью сравнивать объекты
// в данном случае типа ComparableCollectionExample
public class ComparableCollectionExample implements Comparable<ComparableCollectionExample> {
    private String name;

    public ComparableCollectionExample(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Переопределяем для удобного вывода информации
    //про объекты типа ComparableCollectionExample
    @Override
    public String toString() {
        return "ComparableCollectionExample{" +
                "name='" + name + '\'' +
                '}';
    }

    //Реализация метода интерфейса Comparable для возможности сравнения
    //элементов коллекции типа ComparableCollectionExample
    @Override
    public int compareTo(ComparableCollectionExample o) {
        //Будет ошибка, если name == null
        int compareResult = this.name.compareTo(o.name);
        return compareResult;
    }
}
