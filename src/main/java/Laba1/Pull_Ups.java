package Laba1;

import java.util.Random;

import java.util.Random;
import java.util.Scanner;

public class Pull_Ups{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества студентов с консоли
        System.out.print("Введите количество студентов: ");
        int N = scanner.nextInt();

        int[] pullUpResults = new int[N]; // Массив для хранения результатов подтягиваний

        // Генерация случайных результатов подтягиваний для каждого студента
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            pullUpResults[i] = random.nextInt(21); // Генерируем случайное число от 0 до 20
        }

        // Подсчет количества студентов, сдавших зачет на 3, 4 и 5
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        for (int result : pullUpResults) {
            if (result >= 12 && result < 14) {
                count3++;
            } else if (result >= 14 && result < 16) {
                count4++;
            } else if (result >= 16) {
                count5++;
            }
        }

        // Нахождение максимального и минимального количества подтягиваний
        int maxPullUps = pullUpResults[0];
        int minPullUps = pullUpResults[0];

        for (int i = 1; i < N; i++) {
            if (pullUpResults[i] > maxPullUps) {
                maxPullUps = pullUpResults[i];
            }
            if (pullUpResults[i] < minPullUps) {
                minPullUps = pullUpResults[i];
            }
        }

        // Вывод результатов
        System.out.println("Количество студентов, сдавших зачет на 3: " + count3);
        System.out.println("Количество студентов, сдавших зачет на 4: " + count4);
        System.out.println("Количество студентов, сдавших зачет на 5: " + count5);
        System.out.println("Максимальное количество подтягиваний: " + maxPullUps);
        System.out.println("Минимальное количество подтягиваний: " + minPullUps);

        scanner.close();
    }
}
