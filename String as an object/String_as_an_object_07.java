import java.util.Scanner;

/* Задача 7
    Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
    Например, если было введено "abc cde def", то должно быть выведено "abcdef".
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = in.nextLine();
        StringBuilder buildStr = new StringBuilder(str.replace(" ", ""));
        for (int i = 0; i < buildStr.length(); i++) {
            for (int j = buildStr.length() - 1; j > i; j--)
                if (buildStr.charAt(i) == buildStr.charAt(j)) 
                    buildStr.deleteCharAt(j);
        }
        System.out.println("Измененная строка - \"" + buildStr + "\"");
    }
}
