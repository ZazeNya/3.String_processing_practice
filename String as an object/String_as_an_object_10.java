import java.util.Scanner;

/* Задача 10
    Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
    восклицательным или вопросительным знаком. Определить количество предложений в строке X.

    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку, состоящую из предложений (предложения), каждое из которых заканчивается точкой,\n" +
                "восклицательным или вопросительным знаком.");
        String str = in.nextLine();
        int sentences = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '!' || str.charAt(i) == '?' || str.charAt(i) == '.')
                sentences++;
        }
        System.out.println("Количество предложений в строке - " + sentences);
    }
}
