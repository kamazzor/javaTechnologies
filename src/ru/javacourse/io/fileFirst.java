package ru.javacourse.io;

import java.io.*;

//Тестовый класс для работы с файловым вводом и выводом
public class fileFirst {
    public static void main(String[] args) throws IOException {
        encodeDemo();
//        demoReaderWriter();
    }

    public static void demoInputOutput(){

//        Тестовый метод для работы с потоком байтов
        try(InputStream is =
                    new FileInputStream("D:\\Download\\IMG_3478.MP4");
            OutputStream os =
                    new FileOutputStream("test.mp4", true)) {

//            Создаём буфер данных для чтения
            byte[] buffer = new byte[4096];
//            Записываем данные в буфер. Число r равно числу фактически прочитанных байтов.
            int r = is.read(buffer);
            while (r != -1) {
                os.write(buffer, 0, r);
                r = is.read(buffer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        is.close();
//        os.close();
    }

//    Тестовый метод для работы с потоком символов
//    По форме и методам практически то же самое, что и для потоков байтов,
//    только Input и Output заменены на Reader и Writer
    public static void demoReaderWriter() throws IOException {
        Reader r = new FileReader(".idea/workspace.xml");
        Writer w = new FileWriter("test.xml");

        char[] buffer = new char[4096];
        int c = r.read(buffer);
        while (c != -1){
            w.write(buffer, 0, c);
            c = r.read(buffer);
        }
        r.close();
        w.close();
    }

//    Метод создан для тестирования преобразования потока данных
    public static void encodeDemo() throws IOException {
//        Читаем файл как побайтно
        InputStream fis = new FileInputStream("test.xml");
//        Преобразуем полученный поток байтов в поток символов в кодировке UTF-8
        Reader fr = new InputStreamReader(fis, "utf-8");
//        Преобразуем полученный поток символов в поток байтовых строк
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null){
            System.out.println(line);
            line = br.readLine();
        }

        br.close();
        fr.close();
        fis.close();
    }

//    Тестовый метод для ввода/вывода в память
    public static void demoMemory() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[10]);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(null);
    }
}
