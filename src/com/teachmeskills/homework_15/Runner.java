package com.teachmeskills.homework_15;

import com.teachmeskills.homework_15.IParser;
import com.teachmeskills.homework_15.Parser;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println("Enter the path");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Enter the count to path");
        int count = scanner.nextInt();
        IParser parser = new Parser();
        parser.parse(path, count);
        scanner.close();
        System.out.println("End");
    }
}