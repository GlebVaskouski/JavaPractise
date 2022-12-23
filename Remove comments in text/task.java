import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("C:\\Users\\gleb\\IdeaProjects\\lab4\\src\\input.txt");
        FileWriter fw = new FileWriter("C:\\Users\\gleb\\IdeaProjects\\lab4\\src\\output.txt");
        Pattern pattern = Pattern.compile("(//.*)|(/\\*[\\S\\s]*?\\*/)|('.')|(\"[^\"]*\\\")|('.*')");
        Scanner scanner = new Scanner(fr);
        String in = scanner.useDelimiter("\\A").next();
        StringBuffer input = new StringBuffer();
        input.insert(0, in);
        Matcher m = pattern.matcher(in);
        StringBuffer output = new StringBuffer();
        while (m.find()) {
            if (input.charAt(m.start()) != '"' && input.charAt(m.start()) != '\'') {
                output.append(input.substring(m.start(), m.end()));
                output.append('\n');
            }
        }
        fw.write(output.toString());
        fw.close();
    }
}


///**
//(".*//[[ 	]|\S]*.*?")