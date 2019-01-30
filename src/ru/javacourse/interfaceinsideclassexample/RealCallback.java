package ru.javacourse.interfaceinsideclassexample;

import javax.swing.*;

public class RealCallback implements InterfaceInsideClassExample.Callback {

    @Override
    public void callingBack(String s) {
        if (s != null){
            JOptionPane.showMessageDialog(null,"Ваш ответ " + s);
        }
        else {
            JOptionPane.showMessageDialog(null,"Вы не ответили на вопрос");
        }
    }
}
