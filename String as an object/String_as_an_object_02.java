import java.util.Scanner;

/* Задача 2
      В строке вставить после каждого символа 'a' символ 'b'.
    */
public class Program {
    public static void main(String[] args) {
        String str = "Eddie Willers pulled his shoulders straight, in conscientious self-discipline."
        +"He had to stop this, he thought; he was beginning to imagine things."
        +"Had he always felt it?";
        System.out.println(str.replace("a", "ab") + "\"");
    }
}
