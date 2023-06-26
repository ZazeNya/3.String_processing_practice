import java.util.regex.*;
import java.io.*;
/* Задача 2
    Дана строка, содержащая следующий текст (xml-документ):
	<notes>
	<note id = "1">
	<to>Вася</to>
	<from>Света</from>
	<heading>Напоминание</heading>
	<body>Позвони мне завтра!</body>
	</note>
	<note id = "2">
	<to>Петя</to>
	<from>Маша</from>
	<heading>Важное напоминание</heading>
	<body/>
	</note>
	</notes>
	Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа
	и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
	Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
    */
public class Program {
    public static void main(String[] args) throws IOException {

        String xmlDocument = "<notes>\n" +
                "  <note id = \"1\">\n" +
                "    <to>Vasia</to>\n" +
                "    <from>Sveta</from>\n" +
                "    <heading>Reminder</heading>\n" +
                "    <body>Call me tomorrow!</body>\n" +
                "  </note>\n" +
                "  <note id = \"2\">\n" +
                "    <to>Petya</to>\n" +
                "    <from>Masha</from>\n" +
                "    <heading>Important remainder</heading>\n" +
                "    <body/>\n" +
                "  </note>\n" +
                "</notes> ";
        System.out.println(xmlDocument + "\n");
        BufferedReader reader = new BufferedReader(new StringReader(xmlDocument));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line.trim());
            XML_Test(line);
            System.out.println();
            line = reader.readLine();
        }
    }
    public static void XML_Test(String line) {
        String openingTag = "^<\\w+>$";
        String closingTag = "^</\\w+>$";
        String emptyTag = "^<\\w+/>$";
        String contentTag = "(<.+>)(.+)(</.+>)";
        String tagAttribute = "(<\\w+\\s+)(\\w+)([\\s=\\s\"]+)(.+)(\">)";
        Pattern patternContent = Pattern.compile(contentTag);
        Matcher matcherContent = patternContent.matcher(line.trim());
        if (matcherContent.find()) {
            System.out.print(matcherContent.group(1) + " - открывающий тег, ");
            System.out.print(matcherContent.group(2) + " - содержимое тега (значение элемента), ");
            System.out.println(matcherContent.group(3) + " - закрывающий тег");
        }
        Pattern patternOpening = Pattern.compile(openingTag);
        Matcher matherOpening = patternOpening.matcher(line.trim());
        if (matherOpening.find()) {
            System.out.println(matherOpening.group() + " - открывающий тег");
        }
        Pattern patternClosing = Pattern.compile(closingTag);
        Matcher matcherClosing = patternClosing.matcher(line.trim());
        if (matcherClosing.find()) {
            System.out.println(matcherClosing.group() + " - закрывающий тег");
        }
        Pattern patternEmpty = Pattern.compile(emptyTag);
        Matcher matcherEmpty = patternEmpty.matcher(line.trim());
        if (matcherEmpty.find()) {
            System.out.println(matcherEmpty.group() + " - тег без тела");
        }
        Pattern patternAttribute = Pattern.compile(tagAttribute);
        Matcher matcherAttribute = patternAttribute.matcher(line.trim());
        if (matcherAttribute.find()) {
            System.out.print(matcherAttribute.group(0) + " - открывающий тег с атрибутом: ");
            System.out.print(matcherAttribute.group(2) + " - название атрибута, ");
            System.out.println(matcherAttribute.group(4) + " - значение атрибута");
        }
    }
}
