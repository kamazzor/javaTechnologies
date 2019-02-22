package ru.javacourse.io;

import java.io.*;

//Тестовая программа для работы с потоком байтов
public class fileFirst {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\Download\\IMG_3478.MP4");
        OutputStream os = new FileOutputStream("test.mp4");

        //Создаём буфер данных для чтения
        byte[] buffer = new byte[4096];
        //Записываем данные в буфер. Число r равно числу фактически прочитанных байтов.
        int r = is.read(buffer);
        while (r != -1){
            r = is.read(buffer);

        }
        is.close();
        os.close();
    }
}
