package Laba1;

public class The_longest_word {
    public static void main(String[] args) {
        String inputSentence = "The Tower of London was built in the 15th century";
        String longestWord = findLongestWord(inputSentence);
        System.out.println("Самое длинное слово: " + longestWord);
    }

    public static String findLongestWord(String sentence) {
        // Разделяем предложение на слова, используя пробел в качестве разделителя
        String[] words = sentence.split(" ");

        // Инициализируем переменную для хранения самого длинного слова
        String longestWord = "";

        // Проходим по каждому слову и сравниваем его с текущим самым длинным словом
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}
