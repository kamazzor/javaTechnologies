package ru.javacourse.lambdaexpressionsexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// Задача
// Есть 10 сотрудников типа Person, имеющие поля salary и bonus.
// Люди помещены в коллекцию типа ArrayList. Необходимо с помощью
// лямбда-выражений и обычным способом посчитать итоговую сумму
// (поле total), получаемую каждым из сотрудников.

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        List<Person> test = new ArrayList<>();

        //Добавляем сотрудников с их зарплатами и бонусами
        for (int i = 0; i < 10; i++) {
            test.add(new Person(100 * (i + 1), 200 * (i + 1)));
        }

        // Запуск стандартного способ подсчета total для каждого сотрудника
        process(test);

        // Запуск способа подсчета total с помощью callback-функции calculate,
        // которая всегда делается на основе интерфейса.
        // new ProcessTotal() создает экземпляр реализации интерфейса ProcessTotal,
        // причем интерфейс  имплементиурется прямо в фигурных скобках,
        // без реализации в отдельном файле

//        process(test, new ProcessTotal() {
//            @Override
//            public int calculate (int salary, int bonus){
//                return salary + bonus;
//            }
//        });

        //То же самое, без необходимости создавать каждый раз свой собственный интерфейс
        //для лямбда-функции, а используя уже написанные интерфейсы в java.util.function,
        //в нашем случае это BiFunction
        process(test);

        for (Person p : test) {
            System.out.println(p.getTotal());
        }
        System.out.println();

        // Запуск способа подсчета total с помощью лямбда-выражения
        // часть до стрелки указывает набор входных параметров,
        // часть после стрелки переопределяет единственную функцию
        // интерфейса ProcessTotal
        // По сути лямбда-выражение - это краткая форма имплементации интерфейса
        // с единственной функцией
        process(test, (s, b) -> s + b);

        //Стандартная форма записи вывода total для всех сотрудников
        for (Person p : test) {
            System.out.println(p.getTotal());
        }
        System.out.println();
        //Форма записи вывода total для всех сотрудников
        //с помощью лямбда-выражения
        test.stream().forEach(p -> System.out.println(p.getTotal()));
        System.out.println();
        //Способ одной строкой отфильтровать из списка только тех, у кого
        // total > 1000, поместив их всех в новый список collect
        List<Person> collect = test.stream().filter(p -> p.getTotal() > 1000).collect(Collectors.toList());
        //напечатаем получившийся список collect
        collect.stream().forEach(p -> System.out.println(p.getTotal()));
    }

    //Стандартный способ подсчета total для каждого сотрудника
    public static void process(List<Person> test){
        for (Person p : test) {
            p.setTotal(p.getSalary() + p.getBonus());
        }
    }

    //Способ подсчета total с помощью callback-функции calculate
//    public static void process(List<Person> test, ProcessTotal processTotal){
//        for (Person p : test) {
//            p.setTotal(p.getSalary() + p.getBonus());
//        }
//    }

    //Функция с лямбда-выражением без необходимости создавать каждый раз свой собственный интерфейс
    //для лямбда-функции, а используя уже написанные интерфейсы в java.util.function,
    //в нашем случае это BiFunction. Кроме того, реализация этого интерфейса уже написана
    public static void process(List<Person> test, BiFunction<Integer, Integer, Integer> pr){
        for (Person p : test) {
            p.setTotal(pr.apply(p.getSalary(), p.getBonus()));
        }
    }
}
