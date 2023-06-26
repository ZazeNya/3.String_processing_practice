import java.util.Scanner;

/* Задача 5
     Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
     заменить на одиночные пробелы. Крайние пробелы в строке удалить.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = " He reached                    hastily                into his       pocket. "
                + "The    bum had stopped      him and asked     for a dime, then     had gone on        talking.";
        int k=0;
        char[] charArr = str.trim().toCharArray();//удаляем крайние пробелы
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                while (charArr[i + 1] == ' ') {
                    k++;
                    i++;
                }
            }
        }
        char[] NewArr = new char[charArr.length - k];
        int j = 0;
        for (int i = 0; i < charArr.length; i++) {//вносим в новый массив строку без лишних пробелов
            NewArr[j] = charArr[i];
            if (charArr[i] == ' ')
                while (charArr[i + 1] == ' ')
                    i++;
            j++;
        }
        str = new String(NewArr);
        System.out.println("Строка без лишних пробелов");
        System.out.println(str);
    }
}
