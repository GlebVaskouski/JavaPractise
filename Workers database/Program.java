import java.sql.*;
import java.util.Scanner;

class Program {

    public static void main(String[] args) {
        DBHandler dbHandler = DBHandler.getInstance();
        Scanner scanner = new Scanner(System.in);
        int chosen_option;
        while(true){
            System.out.println("Choose option:\n" +
                    "1. Show Users DataBase.\n" +
                    "2. Add User.\n");
            chosen_option = scanner.nextInt();
            if (chosen_option == 1){
                dbHandler.select();
            } else if (chosen_option == 2){
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Enter user hours:");
                String phone = scanner.nextLine();
                System.out.println("Enter user salary:");
                String position = scanner.nextLine();
                dbHandler.insert(new User(name, phone, position));
            } else {
                break;
            }
        }
        dbHandler.close();
    }
}
