import java.util.Scanner;

/* Задача 2
    Замените в строке все вхождения 'word' на 'letter'.
    */
public class Program {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = "Can I have a word with you? Just bin that word. If a good face is a word of recommendation, a good heart is a word of credit.";
        System.out.println("Строка: " + str);
        char[] arrChar = str.toCharArray();
        int word = 0;
        for (int i = 0; i < arrChar.length; i++) {
            if ((arrChar[i] == 'w' || arrChar[i] == 'W' ) && arrChar[i + 1] == 'o' && arrChar[i + 2] == 'r' && arrChar[i + 3] == 'd') {
                word++;//считаем количество word
            }
        }
        char[] newArrChar = new char[arrChar.length + (word * 2)]; //из-за того, что word короче letter на 2 символа
        int j = 0;
        for (int i = 0; i < arrChar.length; i++) {
            if (arrChar[i] == 'w' && arrChar[i + 1] == 'o' && arrChar[i + 2] == 'r' && arrChar[i + 3] == 'd') {
                newArrChar[j] = 'l';
                newArrChar[j + 1] = 'e';
                newArrChar[j + 2] = 't';
                newArrChar[j + 3] = 't';
                newArrChar[j + 4] = 'e';
                newArrChar[j + 5] = 'r';
                i +=3;
                j +=5;
            } else
                newArrChar[j] = arrChar[i];
            j++;
        }
        str = new String(newArrChar);
        System.out.println("Новая строка: " + str);
    }

}
