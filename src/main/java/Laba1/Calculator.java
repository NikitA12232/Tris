package Laba1;
import java.util.Scanner;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод параметров помещения
        System.out.print("Введите длину стен (в метрах): ");
        double length = scanner.nextDouble();

        System.out.print("Введите ширину стен (в метрах): ");
        double width = scanner.nextDouble();

        System.out.print("Введите высоту стен (в метрах): ");
        double height = scanner.nextDouble();

        // Ввод параметров ремонта
        System.out.print("Выберите вид ремонта (1 - обои, 2 - краска): ");
        int repairType = scanner.nextInt();

        double wallpaperRollCost = 0;
        double paintCostPerLiter = 0;
        double paintCoveragePerSqMeter = 0;
        double wallpaperRollWidth = 0; // Ширина рулона обоев
        double wallpaperRollLength = 0; // Длина рулона обоев

        if (repairType == 1) {
            System.out.print("Введите стоимость рулона обоев: ");
            wallpaperRollCost = scanner.nextDouble();
            System.out.print("Введите ширину рулона обоев (в метрах): ");
            wallpaperRollWidth = scanner.nextDouble();
            System.out.print("Введите длину рулона обоев (в метрах): ");
            wallpaperRollLength = scanner.nextDouble();
        } else if (repairType == 2) {
            System.out.print("Введите стоимость 1 литра краски: ");
            paintCostPerLiter = scanner.nextDouble();
            System.out.print("Введите расход краски на 1 м2 (в литрах): ");
            paintCoveragePerSqMeter = scanner.nextDouble();
        } else {
            System.out.println("Выбран недопустимый вид ремонта.");
            scanner.close();
            return;
        }

        // Вычисление параметров
        double wallArea = 2 * (length * height + width * height);
        double totalCost = 0;

        if (repairType == 1) {
            double wallpaperRolls = (wallArea / (wallpaperRollWidth * wallpaperRollLength));
            totalCost = wallpaperRolls * wallpaperRollCost;
            System.out.println("Количество рулонов обоев: " + wallpaperRolls);
        } else {
            double paintLiters = wallArea / paintCoveragePerSqMeter;
            totalCost = paintLiters * paintCostPerLiter;
            System.out.println("Количество литров краски: " + paintLiters);
        }

        // Вывод стоимости
        System.out.println("Общая стоимость: " + totalCost + " рублей");

        scanner.close();
    }
}


