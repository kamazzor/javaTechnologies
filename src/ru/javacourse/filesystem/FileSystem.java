package ru.javacourse.filesystem;

import java.io.File;
import java.io.FilenameFilter;

//Класс для тестовой работы с файловой системой
public class FileSystem {
    public static void main(String[] args) {
         File f = new File("d:/");

//        Проверяем, существует ли файл
//        boolean exists = f.exists();
//        Создаем сразу несколько директорий,указанных в pathname файла
//        f.mkdir();

//        Получаем список строк - названий всех файлов, расположенных в указанной территории,
//        фильтруя их с помощью паттерна
        String[] strings = f.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("aimp");
            }
        });
        for (String s : strings) {
            System.out.println(s);
        }

    }
}
