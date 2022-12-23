import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Summ {
    public static double lineSumm(String str) {
        double result = 0;
        str = str.replaceAll("-", "MINUS");
        str = str.replaceAll("\\+", "PLUS");
        str = str.replaceAll("_", "");
        ArrayList<String> words = getWords(str);

        //Pattern pattern1 = Pattern.compile("(-)?(\\d)+\\.?\\d+[Ee]{1}[-+](\\d)+");
        Pattern pattern1 = Pattern.compile("[-+]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][-+]?\\d+)?");
        Pattern pattern2 = Pattern.compile("[-+]?\\d+[lL]?");
        Pattern pattern3 = Pattern.compile("[-+]?\\d+\\.\\d+[fF]?");
        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).replaceAll("(MINUS)", "-"));
            words.set(i, words.get(i).replaceAll("(PLUS)", "+"));
            Matcher matcher1 = pattern1.matcher(words.get(i));
            Matcher matcher2 = pattern2.matcher(words.get(i));
            Matcher matcher3 = pattern3.matcher(words.get(i));
            if (matcher1.matches() || matcher2.matches() || matcher3.matches())
                result += parseDouble(words.get(i));

            if (words.get(i).equals("PI")) result += 3.142;
            else if (words.get(i).equals("-PI")) result -= 3.142;
            else if (words.get(i).equals("E")) result += 2.718;
            else if (words.get(i).equals("-E")) result -= 2.718;
        }
        return result;
    }

    public static ArrayList<String> getWords(String text) {
        ArrayList<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        return words;
    }
}
