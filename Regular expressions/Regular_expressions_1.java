import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.*;
import java.util.Comparator;
/* Задача 1
    Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом
    три различных операции:
    1. отсортировать абзацы по количеству предложений;
    2. в каждом предложении отсортировать слова по длине;
    3. отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
    а в случае равенства – по алфавиту.
    */
public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char symbol = 't';
        String text = "The light was ebbing, and Eddie Willers could not distinguish the bum's face. The bum had said it simply, without expression.\n"
                + "The bum leaned against the side of the doorway; a wedge of broken glass behind him reflected the metal yellow of the sky.\n"
                + "Eddie Willers walked on, wondering why he always felt it at this time of day, this sense of dread without reason.\r"
                + "No, he thought, not dread, there's nothing to fear: just an immense, diffused apprehension, with no source or object."
                + "He had become accustomed to the feeling, but he could find no explanation for it; yet the bum had spoken as if he knew that Eddie felt it, as if he thought that one should feel it, and more: as if he knew the reason.";

        System.out.println("Исходный текст:");
        System.out.println(text);
        System.out.println("-----------------------------------");
        System.out.println("Абзацы текста отсортированы по количеству предложений в них:");
        String sortText = CountParagraphs(text);
        System.out.println(sortText);
        System.out.println("-----------------------------------");
        System.out.println("\nПредложения текста отсортированы по длине слов в них:");
        String[] arraySentences = ArraySentences(sortText);
        for (int i = 0; i < arraySentences.length; i++)
            System.out.println(SortingSentences(arraySentences[i]));
        System.out.println("-----------------------------------");
        System.out.println("\nЛексемы в предложениях отсортированы по количеству вхождения символа '" + symbol + "':");
        for (int i = 0; i < arraySentences.length; i++)
            System.out.println(SortedWords(ArraySentences(text)[i], symbol));
    }
    // 1. Сортировка абзацев по количеству предложений
    public static String CountParagraphs(String text) {
        String[] paragraphs = text.split("\\r?\\n");
        Pattern patternSentence = Pattern.compile("[A-ZА-Я][^!.?]+[!.?]");
        boolean sorted = true;
        int countFirst = 0, countSecond = 0;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < paragraphs.length - 1; i++) {
                Matcher matcherFirst = patternSentence.matcher(paragraphs[i]);
                while (matcherFirst.find())
                    countFirst++;
                Matcher matcherSecond = patternSentence.matcher(paragraphs[i + 1]);
                while (matcherSecond.find())
                    countSecond++;
                if (countFirst > countSecond) {
                    String tempStr = paragraphs[i];
                    paragraphs[i] = paragraphs[i + 1];
                    paragraphs[i + 1] = tempStr;
                    sorted = true;
                }
                countFirst = 0;
                countSecond = 0;
            }
        }
        StringBuilder sortParagraph = new StringBuilder();
        for (int i = 0; i < paragraphs.length; i++)
            sortParagraph.append(paragraphs[i] + "\n");
        return sortParagraph.toString().trim();
    }

    //Массив из предложений текста
    public static String[] ArraySentences(String text) {
        Pattern patternSentence = Pattern.compile("[A-ZА-Я][^!.?]+[!.?]");
        Matcher matcher = patternSentence.matcher(text);
        int count = 0;
        while (matcher.find()) //считаем количество предложений в тексте
            count++;
        matcher = patternSentence.matcher(text);
        String[] arraySentence = new String[count];
        int id = 0;
        while (matcher.find()) {
            arraySentence[id] = matcher.group();
            id++;
        }
        return arraySentence;
    }

    //2. Сортировка слов по длине в каждом абзаце
    public static String SortingSentences(String sentence) {
        Pattern patternSymbol = Pattern.compile("[A-ZА-Яa-zа-я0-9]+");
        Matcher matcherSymbol = patternSymbol.matcher(sentence);
        StringBuilder builder = new StringBuilder();
        while (matcherSymbol.find())
            builder.append(new StringBuffer(matcherSymbol.group()) + " ");
        String[] sentenceArr = builder.toString().trim().split(" ");
        Arrays.sort(sentenceArr, Comparator.comparing(String::length));
        StringBuilder sortSentence = new StringBuilder();
        for (int i = 0; i < sentenceArr.length; i++)
            sortSentence.append(sentenceArr[i] + " ");
        return sortSentence.toString().trim();
    }

    // 3. Сортировка лексем в предложении по убыванию количества вхождений символа, а в случае равенства – по алфавиту
    public static String SortedWords(String sentence, char symbol) {
        Pattern patternSymbol = Pattern.compile("[A-ZА-Яa-zа-я0-9]+");
        Matcher matcherSymbol = patternSymbol.matcher(sentence);
        StringBuilder builder = new StringBuilder();
        while (matcherSymbol.find()) {
            builder.append(new StringBuffer(matcherSymbol.group()) + " ");
        }
        int countFirst = 0, countSecond = 0;
        String[] words = builder.toString().trim().split(" ");
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = 0; j < words[i].length(); j++)
                    if (words[i].charAt(j) == symbol)
                        countFirst++;
                for (int k = 0; k < words[i + 1].length(); k++)
                    if (words[i + 1].charAt(k) == symbol)
                        countSecond++;
                if (countFirst <= countSecond) {
                    if (countFirst < countSecond) {
                        String temp = words[i];
                        words[i] = words[i + 1];
                        words[i + 1] = temp;
                        sorted = true;
                    } else {
                        if (words[i].toLowerCase(Locale.ROOT).compareTo(words[i + 1].toLowerCase(Locale.ROOT)) > 0) {
                            String temp = words[i];
                            words[i] = words[i + 1];
                            words[i + 1] = temp;
                            sorted = true;
                        }
                    }
                }
                countFirst = 0;
                countSecond = 0;
            }
        }
        StringBuilder sortWord = new StringBuilder();
        for (int i = 0; i < words.length; i++)
            sortWord.append(words[i] + " ");
        return sortWord.toString().trim();
    }
}
