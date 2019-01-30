package ru.javacourse.interfaceinsideclassexample;

public class Main {
    public static void main(String[] args) {
        InterfaceInsideClassExample interfaceInsideClassExample = new InterfaceInsideClassExample();
        RealCallback realCallback = new RealCallback();

        // инициализируем колбек, передавая методу registerCallBack
        // экземпляр RealCallback, реализующий интерфейс Callback
        interfaceInsideClassExample.registerCallBack(realCallback);
        interfaceInsideClassExample.doSomething();
    }
}
