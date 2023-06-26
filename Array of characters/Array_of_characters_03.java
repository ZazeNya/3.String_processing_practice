import java.util.Scanner;

/* Задача 3
     В строке найти количество цифр.
    */
public class Program {

    private static int NumberOfDigits(String str) {
        int result = 0;
        char[] arrChar = new char[str.length()];
        for (int i = 0; i < str.length(); i++)
            arrChar[i] = str.charAt(i);
        for(int j = 0; j < arrChar.length; j++)
            if (Character.isDigit(arrChar[j]))
                result++;
        return result;
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = "He1 reached hastily into his pocket. "
                + "The bum had 2stopped him and asked for a dime, then 15had gone on talking,"
                + "as if to k23ill that moment and postpone 2 the problem of the next. "
                + "Pleas for dimes were6 so frequent in the streets these days th4at it was not necessary to listen to 1explanations,"
                + "and 89he had no de7sire to hear the details of this bum's part4icular despair.";

        System.out.println(NumberOfDigits(str));
    }
}
