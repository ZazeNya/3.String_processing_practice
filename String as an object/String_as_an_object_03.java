import java.util.Scanner;

/* Задача 3
      Проверить, является ли заданное слово палиндромом.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово");
        String str = in.next();
        StringBuilder palindrome = new StringBuilder(str).reverse();
        if (str.equalsIgnoreCase(palindrome.toString()))
            System.out.println("Палиндром");
        else
            System.out.println("Не палиндром");
    }
}
