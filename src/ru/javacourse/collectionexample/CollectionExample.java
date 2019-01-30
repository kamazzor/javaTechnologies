package ru.javacourse.collectionexample;

import ru.javacourse.lambdaexpressionsexample.Person;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {

        //Пример множества set типа TreeSet с данными типа ComparableCollectionExample
        Set<ComparableCollectionExample> set = new TreeSet<>();
        for (int i=0; i<10; i++){
            set.add(new ComparableCollectionExample("" + i));
        }
        for (Object o :
                set) {
            //System.out.println(o);
        }

        //Тестируем интерфейс List
        List<ComparableCollectionExample> list = new ArrayList<>();
        list.add(new ComparableCollectionExample("TEST"));
        ComparableCollectionExample cce = list.get(0);
        //Воспользуемся дефолтным классом Collections, чтобы,
        //например, отсортировать и рандомно перемешать список
        Collections.sort(list);
        Collections.shuffle(list);

        //Экземпляр класса-generic с T == String
        TestGenericClass<String> t1 = new TestGenericClass<>();
        t1.setName("Aloha");
        //Экземпляр класса-generic с T == Integer
        //(не int - обязательно используй оболочку для примитивного типа!!)
        TestGenericClass<Integer> t2 = new TestGenericClass<>();
        t2.setName(1);
        //Экземпляр класса-generic без указания T.
        //Компилятор поругается, но запустит программу с T == Object
        // лучше так не делать - максимум написать в виде заглушки с адаптацией в будушем
        //Согласно полиморфизму, в качестве Object можно передать
        //экземпляр любого типа, наследованного от Object
        TestGenericClass t3 = new TestGenericClass();
        t3.setName(cce);
        System.out.println(t3.getName());



        //Пример использования итератора в коллекции
        List testList = new LinkedList();
        Iterator it = testList.iterator();
        while (it.hasNext()){
            Object value = it.next();
        }

        //Улучшенная версия итератора для коллекций типа List
        //позволяющая "ходить" по testList в обе стороны
        ListIterator listIterator = testList.listIterator();
        if (listIterator.hasNext()){
            Object next = listIterator.next();
        }
        else if (listIterator.hasPrevious()){
            Object previous = listIterator.previous();
        }

    }
}