import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("D:\\Java\\Laba2\\src\\input.txt");
        Scanner sc = new Scanner(fileReader);

        String text = "";

        String keyWord = sc.nextLine();
        String wordToInsert = sc.nextLine();
        while (sc.hasNextLine()){
            text += sc.nextLine();
            text += " \n";
        }

        String regularExpression = "(\\w)+([" + keyWord + "])([\\.\\, ])";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(text);

       String newText = "";
        int startIndex = 0;
        int oldIndex = 0;

        while (matcher.find(startIndex)) {
            int end=matcher.end();
            newText += text.substring(oldIndex, end) + wordToInsert + " ";
            oldIndex = end;
            startIndex = end;
        }
        System.out.println(newText);


    }
}
/*
Формат файла:
1 строка - заданная подстрока
2 строка - указанное слово для вставки
3...n строка - текст

I02
JAVA
HalloweenI02
Halloween (also referredI02 to as All Hollows' Eve) is a holiday
that's celebrated in America on 31 October of each year,
regardlessI02 of what day of the week this date falls on.
Although it is rooted in religion, Halloween today is enjoyed mainlyI02 because of its decorations,
costumes, candy, treats, and general excitement, and furthermore, it is enjoyed by most everyone.

Before Halloween, many individuals carve a design into an orange-coloredI02 pumpkin, or a solidI02,
durable vegetable. Once a personally satisfying designI02 is carved,
a lit candleI02 is typically put inside a pumpkin, thereby making it a Jack-O-Lantern.
At nightI02, this design lights up against the darkness.


После каждого слова текста, заканчивающегося заданной подстрокой, вставить указанное слово.
 */