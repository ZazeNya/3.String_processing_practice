import java.util.Scanner;

/* Задача 4
     В строке найти количество цифр.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = "He1 reached hastily into his pocket. "
                + "The bum had 2stopped him and asked for a dime, then 15had gone on talking,"
                + "as if to k23ill that moment and postpone 2 the problem of the next. "
                + "Pleas for dimes were6 so frequent in the streets these days th4at it was not necessary to listen to 1explanations,"
                + "and 89he had no de7sire to hear the details of this bum's part4icular despair.";

        char[] arrChar = str.toCharArray();
        int numbers = 0;
        for (int i = 0; i < arrChar.length; i++) {
            if (Character.isDigit(arrChar[i])) {//начало числа
                numbers++;
                for (int j = i + 1; j < arrChar.length; j++) {//находим конец числа
                    if (Character.isDigit(arrChar[j]))
                        i = j;
                    else break;
                }
            }
        }
        System.out.println("Строка содержит чисел: " + numbers);
    }
}
