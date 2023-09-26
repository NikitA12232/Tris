package Laba1;

import java.util.regex.*;

import java.util.Scanner;
import java.util.regex.*;

import java.util.Scanner;
import java.util.regex.*;

public class Password_Security {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        scanner.close();

        String validationMessage = validatePassword(password);

        if (validationMessage.isEmpty()) {
            System.out.println("Пароль верен.");
        } else {
            System.out.println("Пароль не соответствует следующим критериям:");
            System.out.println(validationMessage);
        }
    }

    public static String validatePassword(String password) {
        StringBuilder validationMessage = new StringBuilder();

        if (password.length() < 6 || password.length() > 12) {
            validationMessage.append("Пароль должен быть от 6 до 12 символов.\n");
        }

        // Проверка наличия хотя бы одной буквы в нижнем регистре
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        if (!lowerCaseMatcher.find()) {
            validationMessage.append("Пароль должен содержать хотя бы одну букву в нижнем регистре.\n");
        }

        // Проверка наличия хотя бы одной буквы в верхнем регистре
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        if (!upperCaseMatcher.find()) {
            validationMessage.append("Пароль должен содержать хотя бы одну букву в верхнем регистре.\n");
        }

        // Проверка наличия хотя бы одной цифры
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            validationMessage.append("Пароль должен содержать хотя бы одну цифру.\n");
        }

        // Проверка наличия хотя бы одного специального символа
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            validationMessage.append("Пароль должен содержать хотя бы один специальный символ.\n");
        }

        return validationMessage.toString();
    }
}
