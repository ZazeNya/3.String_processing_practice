import java.util.Scanner;

/* Задача 1
    Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
    */
public class Program {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = "oneDay twoDay lastWeek greenCar littleCat";
        System.out.println(Snake_Case(s));
    }
    private static String Snake_Case(String camelCase) {
        char[] charArray = new char[camelCase.length()];
        for (int i = 0; i < camelCase.length(); i++)
            charArray[i] = camelCase.charAt(i);
        String result = "";
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i]))
                result += charArray[i];
            else if (Character.isUpperCase(charArray[i]))
                result += "_" + Character.toLowerCase(charArray[i]);
            else if(Character.isWhitespace(charArray[i]))
                result += " ";
        }
        return result;
    }
}
