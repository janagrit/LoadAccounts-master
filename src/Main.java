import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String fileName;
    String userChoice;
    List<String[]> content = null;
    List<Account> accounts = new ArrayList<>();

    System.out.println("******************** DUOTECH BANK ACCOUNT MANAGEMENT APPLICATION ********************");

    System.out.print("Please enter the name of the file to load (customers1.csv, customers2.csv or customers3.csv): ");
    fileName = sc.next();

    content = Utility.readFromCSV(fileName);

    for (String[] strings : content) {
      if(strings[2].equals("Checking")){
        accounts.add(new Checking(strings[0], strings[1], Double.parseDouble(strings[3])));
      }
      else{
        accounts.add(new Savings(strings[0], strings[1], Double.parseDouble(strings[3])));
      }
    }

    System.out.println("-------------------------------------------------------------------------------------");
    System.out.println("All the information has been loaded and accounts are being generated...");
    System.out.println("-------------------------------------------------------------------------------------");
    System.out.println("Here's the list of bank accounts that have been created:");
    System.out.println("-------------------------------------------------------------------------------------");

    for (Account account : accounts) {
      System.out.print(account.showInfo());
      System.out.println("*************************************************************");
    }

    System.out.println("Would you like to load another file: (y/n)");
    userChoice = sc.next();

    while(!userChoice.equals("n")){

      System.out.print("Please enter the name of the file to load: ");
      fileName = sc.next();

      content = Utility.readFromCSV(fileName);

      for (String[] strings : content) {
        if(strings[2].equals("Checking")){
          accounts.add(new Checking(strings[0], strings[1], Double.parseDouble(strings[3])));
        }
        else{
          accounts.add(new Savings(strings[0], strings[1], Double.parseDouble(strings[3])));
        }
      }

      System.out.println("-------------------------------------------------------------------------------------");
      System.out.println("All the information has been loaded and accounts are being generated...");
      System.out.println("-------------------------------------------------------------------------------------");
      System.out.println("Here's the list of bank accounts that have been created:");
      System.out.println("-------------------------------------------------------------------------------------");

      for (Account account : accounts) {
        System.out.print(account.showInfo());
        System.out.println("*************************************************************");
      }

      System.out.println("Would you like to load another file: (y/n)");
      userChoice = sc.next();
    }


    System.out.println("THANK YOU FOR USING DUOTECH BMA! GOODBYE!");
  }
}
