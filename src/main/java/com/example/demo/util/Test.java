package com.example.demo.util;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày -1 để Stop.");
        while (true) {
            System.out.println("Chọn ngày: ");
            int day = scanner.nextInt();
            if (day == -1) {
                System.out.println("Stop!!!");
                break;
            }
            System.out.println("Chọn bài: ");
            int bt = scanner.nextInt();
            switch (day) {
                case 1:
                    day1(bt);
                    break;
                case 2:
                    day2(bt);
                    break;
                case 3:
                    day3(bt);
                    break;
                default:
                    System.out.println("Day not found");
            }
            System.out.println("\n<===== NEXT =====>\n");
        }
    }


    public static void day1(int bt) {
        System.out.println("Run VD cho ngày 1 bài " + bt + ": ");
        switch (bt) {
            case 1:
                System.out.println("In ra bài 1");
                break;
            case 2:
                System.out.println("In ra bài 2");
                break;
            case 3:
                System.out.println("In ra bài 3");
                break;
            default:
                System.out.println("BT not found");
        }

    }

    private static void day2(int bt) {
    }

    private static void day3(int bt) {
    }
}
