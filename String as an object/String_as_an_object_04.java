import java.util.Scanner;

/* Задача 4
       С помощью функции копирования и операции конкатенации составить
       из частей слова “информатика” слово “торт”.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = "информатика";
        String cake = str.charAt(7) + str.substring(3, 5) + str.charAt(7);
        System.out.println("Новое слово - \"" + cake + "\"");
    }
}
