import java.util.Scanner;

/* Задача 5
       Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = "Most good programmers do programming not because they expect to get"
        +"paid or get adulation by the public, but because it is fun to program.";
        int a = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == 'a' || str.charAt(i) == 'A' || str.charAt(i) == 'а' || str.charAt(i) == 'А')
                a++;
        System.out.println(a + " букв \"a\"");
    }
}
