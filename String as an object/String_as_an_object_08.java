import java.util.Scanner;

/* Задача 8
    Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
    Случай, когда самых длинных слов может быть несколько, не обрабатывать.

    */
public class Program {
    private static String LargeWord(String str) {
        String largeWord = "";
        String nowWord = "";
        int count,max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                count = 0;
                nowWord = "";
                while(i < str.length() && Character.isLetter(str.charAt(i))) {
                    nowWord += str.charAt(i);
                    count++;
                    i++;
                }
                if (count > max) {
                    max = count;
                    largeWord = nowWord;
                }
                if (count==max)
                    return " ";
            }
        }
        return largeWord;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите несколько слов через пробел");
        String str = in.nextLine();
        System.out.println(LargeWord(str));
    }
}
