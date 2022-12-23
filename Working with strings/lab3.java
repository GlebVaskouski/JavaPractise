import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class problems3 {

    public static void main(String[] args) throws Exception {
        String array = "abcdefghijklmnopqstuvwxyz";
        FileReader fr = new FileReader("C:\\Users\\gleb\\IdeaProjects\\lab3\\src\\input.txt");
        FileWriter fw = new FileWriter("C:\\Users\\gleb\\IdeaProjects\\lab3\\src\\output.txt");

        Scanner scanner = new Scanner(fr);
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] letters = str.split("");
            String firstString = new String();
            String secondString = new String();
            for (var el : letters){
                if(!el.equals(" ")){
                    firstString += el + "  ";
                }
            }
            letters = str.toLowerCase().split("");
            for(int i = 0; i < letters.length; ++i) {
                if (!letters[i].equals(" ")){
                    int ind = array.indexOf(letters[i]);
                    letters[i] = Integer.toString(ind + 1);
                    if (ind + 1 < 10) {
                        secondString += letters[i] + "  ";
                    } else {
                        secondString += letters[i] + " ";
                    }
            }
            }
            fw.write(firstString);
            fw.write('\n');
            fw.write(secondString);
            fw.write('\n');
        }
        fw.close();
        fr.close();
    }
}

