import java.util.Scanner;

/* Задача 6
       Из заданной строки получить новую, повторив каждый символ дважды.
    */
public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "Good programmers";
        String strNew = new String();
        for (int i = 0; i < str.length(); i++)
            strNew = strNew +  str.charAt(i) + str.charAt(i);
        System.out.println("Исходная строка - \"" + str + "\"");
        System.out.println("Измененная строка - \"" + strNew + "\"");
    }
}
