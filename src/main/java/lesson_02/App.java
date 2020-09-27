package lesson_02;

import java.util.Scanner;

public class App {
    public static void main (String [] args) {

        String hidden_word = vocabulary();// подтягиваем загаданное слово из "словаря"
        int hidden_word_length = hidden_word.length();// считаем длину слова
        int wrong_attempt = 0;// инициируем счётчик неправильных попыток
        int true_attempt = 0;// инициируем счётчик правильных попыток

        System.out.println("I made a word");
        String hidden_word_for_user = new String(new char[hidden_word_length]).replace("\0", "*");// считаем маскиованное слово
        System.out.println(hidden_word_for_user);// выводим маскированное слово
        String hidden_word_for_user_for_cycle = hidden_word_for_user;// присваиваем для развлекалова в цикле

        while(wrong_attempt + 1 < hidden_word_length && true_attempt < hidden_word_length) {// в цикле чекаем сколько непавильно букв жмакнули или если угадали слово

            System.out.println("Guess a letter:");
            Scanner scanner = new Scanner(System.in);// заносим в переменную введённую букву
            String entered_string = scanner.nextLine();// сканим введённую с клавиатуы букву

            int index = hidden_word.indexOf(entered_string);// ищем на какой позиции находится введённая буква

            if (index == -1) {// если введённой буквы нет, то +1 к непавильной попытке
                ++wrong_attempt;
                System.out.println("Missed, mistake " + wrong_attempt + " out of 5.");
                if (wrong_attempt == 5) {// на игру дано только 5 попыток
                    System.out.println("You lost!");
                }
            } else {
                ++true_attempt;// пееменная нужна, чтобы в случае угадывания слова указать это
                hidden_word_for_user_for_cycle = hidden_word_for_user_for_cycle.substring(0, index) + entered_string + hidden_word_for_user_for_cycle.substring(index + 1, hidden_word_length);// показываем отгаданные буквы
                System.out.println("Hit!");
                System.out.println();
                System.out.println("The word: " + hidden_word_for_user_for_cycle);
                System.out.println();

                if (true_attempt == hidden_word_length) {
                    System.out.println("You won!");
                }
            }
        }
    }

    private static String vocabulary() {// тут храним слова для игры и рандомно выбиаем слово
        String[] word = new String[]{"first","second"};
        int n = (int)Math.floor(Math.random() * word.length);
        return word[n];
    }
}
