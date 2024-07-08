import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program
{
    private static Scanner scanner = new Scanner(System.in);
    private static File buferFile = new File("myFile.txt");
    private static int numberInFail;
    private static int minNumberOut = 0;
    private static int z;


    public static void main(String[] args) throws IOException {
        System.out.println("Ваша задача угадать число от 1 до 100");
        guess();

    }

    private static void guess() throws IOException {
        int number = (int) (Math.random() * 100);

        String comand = "RESULT";
        try {
            while (true) {
                int input_number = scanner.nextInt();
                if (input_number == number) {
                    z++;
                    try {
                        if(buferFile.exists()) {
                            file(z);
                        } else if (!buferFile.exists()) {
                            buferFile.createNewFile();
                            FileWriter fileWriter = new FileWriter(buferFile);
                            fileWriter.write(Integer.toString(1000));
                            fileWriter.close();
                            file(z);
                        }
                    }
                    catch (IOException e) {
                    }
                    System.out.println("Вы угадали, это число " + number + ".  \nКоличество попыток равно " + z + ". \nЛучший результат: " + minNumberOut);
                    break;
                } else if (input_number > number) {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                    z++;
                } else {
                    z++;
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                }
            }
        } catch (InputMismatchException e) {
            while (true) {
                String inputComand = scanner.next() ;
                if (inputComand.equals(comand)) {
                    Scanner scanner = null;
                    scanner = new Scanner(buferFile);
                    if (scanner.hasNextInt()) {
                        minNumberOut = scanner.nextInt();
                        System.out.println(minNumberOut);
                    }
                    System.out.println("Количество попыток равно: " + z + ". \nЛучший результат: " + minNumberOut);
                    break;
                } else {
                    System.out.println("Команда некорректна. Введите ещё раз ");
                }
            }
        }
        scanner.close();
    }

    public static void file (int zet) throws IOException {
        Scanner scanner = null;
        scanner = new Scanner(buferFile);
        if (scanner.hasNextInt()) {
            numberInFail = scanner.nextInt();
        }
        if (numberInFail <= zet) {
            minNumberOut = numberInFail;
        } else {
            minNumberOut = zet;
            FileWriter fileWriter = new FileWriter(buferFile);
            fileWriter.write(Integer.toString(minNumberOut));
            fileWriter.close();
        }
        scanner.close();
    }
}