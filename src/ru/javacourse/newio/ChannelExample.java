package ru.javacourse.newio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// Тестовый класс для иллюстрации нового типа ввода/вывода на основе
// каналов, буфферов и селекторов
public class ChannelExample {
    public static void main(String[] args) throws IOException {
//        channelDemo();
        transferDemo();
    }

    public static void channelDemo() throws IOException{
//        Создаем потоки ввода/вывода байтов
        FileInputStream fis = new FileInputStream("D:\\Download\\sp88745.exe");
        FileOutputStream fos = new FileOutputStream("new.exe");
        //Создаем канал на основе стандартного потока
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

//        Создаем буферы данных типа Byte для работы с каналами, тем самым меньше
//        блокируя поток байтов в отличие от стандартного взаимодействия с потоком байтов
        ByteBuffer inBb = ByteBuffer.allocate(4096);
        ByteBuffer outBb = ByteBuffer.allocate(4096);

//        Заполняем буфер данными из потока байтов, возвращая фактически считанное кол-во байтов.
        int r = inChannel.read(inBb);

        //читаем буферы данных, пока они есть
        while (r != -1){
//            Обязательно переводим буфер из режима записи в буфер в режим чтения из него,
//            чтобы указатель переместился в начало или нужное место буфера.
            inBb.flip();
            //Проверяем, остались ли ещё непрочитанные данные в буфере
            while (inBb.hasRemaining()){
                //Получаем байт
                byte b = inBb.get();
                //Кладем байт в выходной буфер
                outBb.put(b);
            }
//            Обязательно переводим буфер из режима записи в буфер в режим чтения из него,
//            чтобы указатель переместился в начало или нужное место буфера.
            outBb.flip();
//            Записываем в канал байты из буфера
            outChannel.write(outBb);
            //очищаем буферы
            inBb.clear();
            outBb.clear();
            //читаем новые данные во входной буфер
            r = inChannel.read(inBb);
        }

        fis.close();
        fos.close();

    }

//    Метод для тестирования методов канала transferFrom и transferTo для быстрого
//    чтения и записи из одного канала в другой без буферов, в одну строчку
    public static void transferDemo() throws IOException{
        //        Создаем файловые потоки ввода/вывода байтов
        FileInputStream fis = new FileInputStream("D:\\Download\\sp88745.exe");
        FileOutputStream fos = new FileOutputStream("new.exe");
        //Создаем канал на основе стандартного потока
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        inChannel.transferTo(0, inChannel.size(), outChannel);
        fis.close();
        fos.close();
    }
}
