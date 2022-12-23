import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Comment {
    public static void main(String[]args) throws FileNotFoundException{
        FileReader fileReader = new FileReader("D:\\Java\\Coments\\src\\input");
        Scanner sc = new Scanner(fileReader);

        enum State { START, STR_BODY, SPECIAL_STR, CHAR_BODY, SPECIAL_CHAR, SUSPEND_COMMENT, COMMENT, ONE_STR_COMMENT, STAR};
        StringBuilder text = new StringBuilder();
        StringBuilder newText = new StringBuilder();
        String endText;

        while (sc.hasNextLine()) {
            text.append(sc.nextLine());
            text.append("\n");
        }

        State state = State.START;
        char c;
        for(int i = 0; i < text.length(); i++){
            c = text.charAt(i);
            switch (state) {
                case START:
                    if(c == '"') state = State.STR_BODY;
                    else if (c == '\'') state = State.CHAR_BODY;
                    else if (c == '/') state = State.SUSPEND_COMMENT;
                    newText.append(c);
                    break;
                case STR_BODY:
                    if(c == '"') state = State.START;
                    else if (c == '\\') state = State.SPECIAL_STR;
                    newText.append(c);
                    break;
                case SPECIAL_STR:
                    if(c == '"') state = State.STR_BODY;
                    else state = State.STR_BODY;
                    newText.append(c);
                    break;
                case CHAR_BODY:
                    if(c == '\'') state = State.START;
                    else if (c == '\\') state = State.SPECIAL_CHAR;
                    newText.append(c);
                    break;
                case SPECIAL_CHAR:
                    if(c == '\'') state = State.CHAR_BODY;
                    else state = State.CHAR_BODY;
                    newText.append(c);
                    break;
                case SUSPEND_COMMENT:
                    if(c == '/'){
                        state = State.ONE_STR_COMMENT;
                        newText.delete((newText.length() - 1), newText.length());
                    }
                    else if (c == '*'){
                        state = State.COMMENT;
                        newText.delete((newText.length() - 1), newText.length());
                    }
                    else state = State.START;
                    break;
                case COMMENT:
                    if(c == '*') state = State.STAR;
                    break;
                case ONE_STR_COMMENT:
                    if(c == '\n') {
                        state = State.START;
                        newText.append('\n');
                    }
                    break;
                case STAR:
                    if(c == '/') state = State.START;
                    break;
                default: break;
            }
        }

        endText = newText.toString();
        System.out.println("Text without comments:\n" + endText);
    }
}
