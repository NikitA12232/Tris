package Laba2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    private String name;
    private int age;
    private double distance;

    public Passenger(String name, int age, double distance) {
        this.name = name;
        this.age = age;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getDistance() {
        return distance;
    }
}

class Taxi {
    private String driver;
    private String number;
    private double cost;
    private List<Passenger> passengers;

    public Taxi(String driver, String number, double cost) {
        this.driver = driver;
        this.number = number;
        this.cost = cost;
        this.passengers = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public String getDriver() {
        return driver;
    }

    public double getCost() {
        return cost;
    }
    public List<Passenger> getPassengers() {
        return passengers;
    }
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < 4) {
            passengers.add(passenger);
            System.out.println("Пассажир добавлен.");
        } else {
            System.out.println("Такси заполнено. Нельзя добавить больше пассажиров.");
        }
    }

    public void removePassenger(int index) {
        if (index >= 0 && index < passengers.size()) {
            passengers.remove(index);
            System.out.println("Пассажир удален.");
        } else {
            System.out.println("Недопустимый индекс пассажира.");
        }
    }

    public double calculateTripCost() {
        double totalCost = 0.0;
        for (Passenger passenger : passengers) {
            totalCost += passenger.getDistance() * cost;
        }
        return totalCost;
    }

    public void displayTaxiInfo() {
        System.out.println("Водитель: " + driver);
        System.out.println("Номер: " + number);
        System.out.println("Стоимость за километр: " + cost);
        System.out.println("Количество пассажиров: " + passengers.size());
    }
}
public class Taxi_LR2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя водителя: ");
        String driverName = scanner.nextLine();
        System.out.print("Номер автомобиля: ");
        String carNumber = scanner.nextLine();
        System.out.print("Стоимость поездки за километр: ");
        double costPerKilometer = scanner.nextDouble();

        Taxi taxi = new Taxi(driverName, carNumber, costPerKilometer);

        int choice = 1;
        while (choice != 0) {
            System.out.println("0. Выход");
            System.out.println("1. Показать информацию о такси");
            System.out.println("2. Добавить пассажира");
            System.out.println("3. Удалить пассажира");
            System.out.println("4. Рассчитать стоимость поездки");

            System.out.print("Введите ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    taxi.displayTaxiInfo();
                    break;
                case 2:
                    if (taxi.getPassengers().size() < 4) {
                        System.out.print("Имя пассажира: ");
                        String passengerName = scanner.nextLine();
                        System.out.print("Возраст пассажира: ");
                        int passengerAge = scanner.nextInt();
                        System.out.print("Расстояние: ");
                        double distance = scanner.nextDouble();
                        scanner.nextLine();

                        Passenger passenger = new Passenger(passengerName, passengerAge, distance);
                        taxi.addPassenger(passenger);
                    } else {
                        System.out.println("Такси заполнено. Нельзя добавить больше пассажиров.");
                    }
                    break;
                case 3:
                    if (taxi.getPassengers().size() > 0) {
                        System.out.print("Введите номер пассажира для удаления: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        taxi.removePassenger(index - 1);
                    } else {
                        System.out.println("Список пассажиров пуст.");
                    }
                    break;
                case 4:
                    double tripCost = taxi.calculateTripCost();
                    System.out.println("Общая стоимость поездки: руб." + tripCost);
                    break;
                case 0:
                    System.out.println("Завершение обслуживания такси.");
                    break;
                default:
                    System.out.println("Недопустимый выбор.");
            }
        }

        scanner.close();
    }
}
