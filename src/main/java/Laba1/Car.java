package Laba1;

import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод скорости автомобиля
        System.out.print("Введите скорость автомобиля (км/ч): ");
        int speed = scanner.nextInt();

        // Проверка на превышение скорости и расчет штрафа
        int fine = 0;
        String message = "";

        if (speed > 90) {
            if (speed <= 110) {
                fine = 500;
                message = "Превышение скорости на 20-40 км/ч. Штраф: 500 рублей.";
            } else if (speed <= 130) {
                fine = 1500;
                message = "Превышение скорости на 40-60 км/ч. Штраф: 1500 рублей.";
            } else if (speed <= 150) {
                fine = 2500;
                message = "Превышение скорости на 60-80 км/ч. Штраф: 2500 рублей или лишение прав на 4 месяца.";
            } else {
                fine = 5000;
                message = "Превышение скорости на более чем 80 км/ч. Штраф: 5000 рублей или лишение прав на полгода.";
            }
        } else {
            message = "Скорость автомобиля допустима на данном участке.";
        }

        // Вывод результата
        System.out.println(message);
        if (fine > 0) {
            System.out.println("Штраф: " + fine + " рублей.");
        }

        scanner.close();
    }
}

