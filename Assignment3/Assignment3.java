import java.util.ArrayList;
import java.util.Scanner;
public class Assignment3 {
    public static void main(String[] args){
        ArrayList<Customer> customers = new ArrayList<>();
        menu(customers);
    }
    public static void menu(ArrayList<Customer> Customers){
        Scanner sc = new Scanner(System.in);
        int choice; boolean quit = false; String name; String dob;
        do {
            System.out.println("""
1. Take test for new license
2. Renew existing license
3. Move from out of state
4. Answer citation/suspended license
5. See current queue
6. Quit""");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("What is your name?");
                    name = sc.nextLine();
                    System.out.println("What is your date of birth?");
                    dob = sc.nextLine();
                    Customers.add(new NewTest(name,dob));
                    break;
                case 2:
                    System.out.println("What is your name?");
                    name = sc.nextLine();
                    Customers.add(new Renew(name));
                    break;
                case 3:
                    System.out.println("What is your name?");
                    name = sc.nextLine();
                    System.out.println("What state did you move from?");
                    String state = sc.nextLine();
                    Customers.add(new Move(name,state));
                    break;
                case 4:
                    System.out.println("What is your name?");
                    name = sc.nextLine();
                    System.out.println("What violation did you commit?");
                    String violation = sc.nextLine();
                    Customers.add(new Suspended(name,violation));
                    break;
                case 5:
                    for (Customer customer : Customers) System.out.println(customer.getCustomerInfo());
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Please choose one of the following inputs.");
            }
            System.out.println();
        } while(!quit);
    }
}