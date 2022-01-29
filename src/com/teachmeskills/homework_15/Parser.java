package com.teachmeskills.homework_15;

import com.teachmeskills.homework_15.Document1;
import com.teachmeskills.homework_15.IParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser implements IParser {


    @Override
    public void parse(String pathToFolder, int countToParse) {

        File folder = new File(pathToFolder);

        if (folder.isDirectory()) {
            System.out.println(folder.listFiles().length + " - всего файлов");
            System.out.println(folder.listFiles((dir, name) -> name.endsWith("txt")).length + " - Валидных");
            // получаем только ТХТ файл согласно условию
            List<File> files = Arrays.stream(folder.listFiles((dir, name) -> name.endsWith("txt"))).limit(countToParse).collect(Collectors.toList());

            // проверка на то, что после фильтрации есть файлы, подходящие под наше условие
            if (files.size() == 0) {
                System.out.println("Нет подходящих файлов");
                return;
            }

            for (File file : files) {
                readFile(file);
                System.out.println("------");
            }
        } else {
            System.out.println("Невалидный путь");
        }
    }

    private void readFile(File file) {
        Pattern docPattern = Pattern.compile("\\d{4}[-][a-zа-я]{3}[-]\\d{4}[-][a-zа-я]{3}[-]\\d[a-zа-я]\\d[a-zа-я]", Pattern.CASE_INSENSITIVE);
        Pattern phonePattern = Pattern.compile("(\\+*)[(]\\d{2}[)]\\d{7}([\\W\\n\\t]|$)");
        Pattern emailPattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
        Map<String, Document1> myMap = new HashMap<>();
        List<Document1> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String docOneLine;
            // читаем документ посстрочно и анализируем
            System.out.println(file.getName().replace(".txt", ""));
            list.add(new Document1());
            int number = 0;
            while ((docOneLine = reader.readLine()) != null) {
                Matcher docMatcher = docPattern.matcher(docOneLine);
                Matcher phoneMatcher = phonePattern.matcher(docOneLine);
                Matcher emailMatcher = emailPattern.matcher(docOneLine);

                // TODO рефактор

                if (docMatcher.find()) {
                    list.get(number).setNumberOfDocument(docOneLine.substring(docMatcher.start(), docMatcher.end()));
                } else if (phoneMatcher.find()) {
                    list.get(number).setNumberTel(docOneLine.substring(phoneMatcher.start(), phoneMatcher.end()));
                } else if (emailMatcher.find()) {
                    list.get(number).setNumberTel(docOneLine.substring(emailMatcher.start(), emailMatcher.end()));
                }
                myMap.put(file.getName().replace(".txt", ""), list.get(number));
            }
            number++;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //Для проверки
        for (Map.Entry<String, Document1> s1 : myMap.entrySet()) {
            System.out.println(s1.getKey() + " : " + s1.getValue());
        }
    }
}
