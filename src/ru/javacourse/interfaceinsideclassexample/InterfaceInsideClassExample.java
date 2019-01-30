package ru.javacourse.interfaceinsideclassexample;

import javax.swing.*;
//Пример класса, внутри которого описан интерфейс Callback
//Вызов данного интерфейса будет выглядеть как
//InterfaceInsideClassExample.Callback

//Callback - это метож обратного вызова в результате какого-то действия

public class InterfaceInsideClassExample {

    //Создаем переменную, в которую записываем ответ на вопрос "Вы программист?"
    String replyTo;

    // создаем колбек и его метод
    interface Callback{
        void callingBack(String s);
    }

    Callback callback;

    // Регистрируем экземпляр коллбека
    public void registerCallBack(Callback callback){
        this.callback = callback;
    }
    // Создаем диалоговое окно, используя компонент JOptionPane библиотеки Swing.
    // Swing — библиотека для создания графического интерфейса программ
    void doSomething(){
        int reply = JOptionPane.showConfirmDialog(null, "Вы программист?", "Опрос", JOptionPane.YES_NO_OPTION);

        //Получаем ответ на вопрос "Вы программист?"
        if (reply == JOptionPane.NO_OPTION){
            replyTo = "Нет";
        }
        else if (reply == JOptionPane.YES_OPTION) {
            replyTo = "Да";
        }
        else{
            replyTo = null;
        }

        // вызываем метод обратного вызова
        callback.callingBack(replyTo);
    }
}