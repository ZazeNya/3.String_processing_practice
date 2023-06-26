import java.util.Scanner;

/* Задача 1
     Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char space = ' ';
        String str = "Eddie  Willers pulled his shoulders straight, in conscientious self-discipline.     "
        +"          He had to    stop this,      he thought; he      was beginning to imagine things."
        +"                        Had he always felt it?  ";
        int length = str.length(), maxResult = 0,result;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == space) {
                result = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == space)
                        result++;
                    else break;
                }
                maxResult = (result > maxResult) ? result : maxResult;
            }
        }
        System.out.println("В строке наибольшее количество подряд идущих пробелов равно " + maxResult);
    }
}
