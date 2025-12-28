package Stationary_Billing_System;
import java.util.*;

class StationaryItem {
    Scanner sc = new Scanner(System.in);
    protected int stock;
    protected int requirement;
    protected int price;

    public StationaryItem(int stock, int price) {
        this.stock = stock;
        this.price = price;
    }

    /**
	 * @deprecated Use {@link #updateStock(UpdateStockParameter)} instead
	 */
	public void updateStock() {
		updateStock(new UpdateStockParameter());
	}

	public void updateStock(UpdateStockParameter parameterObject) {
    	String[] item = {"pencils","pen","books"};
    	for(int j = 0;j<=2;j++) {
    	for(String i : item) {
//        System.out.print("Enter the stock of the "+ i + " present in the store: ");
        	System.out.print("Enter the stock of the "+ i + " present in the store: ");
        	stock = sc.nextInt();	
        	 sc.nextLine(); // Consume the newline character left in the buffer

           }
    	 break;
        }
       
    }

    public void setRequirement() {
        System.out.println("Enter the number of items the customer wants: ");
        requirement = sc.nextInt();
    }

    public void checkStock() {
        if (requirement > stock) {
            System.out.println("Sorry... Items are out of stock.");
        }
    }

    public void generateBill() {
        int totalBill = price * requirement;
        System.out.println("Total amount for the item: $" + totalBill);
    }
}

class Pencil extends StationaryItem {
    public Pencil() {
        super(100, 10);
    }
}

class Pen extends StationaryItem {
    public Pen() {
        super(100, 20);
    }
}

class Book extends StationaryItem {
    public Book() {
        super(50, 50);
    }
}

class UserInterface {
    Scanner sc = new Scanner(System.in);
    Pencil pencil = new Pencil();
    Pen pen = new Pen();
    Book book = new Book();

    public void operations() {
        System.out.println("\n1. To check Stationary items available.");
        System.out.println("2. To Check Stock present in the store.");
        System.out.println("3. To update the amount of stock.");
        System.out.println("4. To place order (Add items to bill)");
        System.out.println("5. Generate bill");
        System.out.println("6. Exit");
    }

    public void menu() {
        System.out.println("The stationary items present in a store are:->");
        System.out.println("1. Pencil\t:\t$10");
        System.out.println("2. PEN\t\t:\t$20");
        System.out.println("3. Book\t\t:\t$50");
    }

    public void stockCheck() {
        System.out.println("Stock of pencil present in the store: " + pencil.stock);
        System.out.println("Stock of pEN present in the store: " + pen.stock);
        System.out.println("Stock of book present in the store: " + book.stock);
    }

    public void stockUpdate() {
        pencil.updateStock(new UpdateStockParameter());
        pen.updateStock(new UpdateStockParameter());
        book.updateStock(new UpdateStockParameter());
    }

    public void placeOrder() {
    	System.out.println("Enter the number of pencil customer Want.");
        pencil.setRequirement();
        pencil.checkStock();
        System.out.println("Enter the number of pen customer Want.");
        pen.setRequirement();
        pen.checkStock();
        System.out.println("Enter the number of books customer Want.");
        book.setRequirement();
        book.checkStock();
    }

    public void generateBill() {
        pencil.generateBill();
        pen.generateBill();
        book.generateBill();
        int totalBill = pencil.price * pencil.requirement + pen.price * pen.requirement + book.price * book.requirement;
        System.out.println("Total Price: $" + totalBill);
    }
}

class StockManagement {
    UserInterface userInterface = new UserInterface();
    private String username;
    private String password;

    Scanner input = new Scanner(System.in);

    public StockManagement(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void checkAuthentication() {
   
        System.out.println("Enter Username");
        String managerUsername = input.nextLine();
        System.out.println("Enter Password");
        String managerPassword = input.nextLine();

        if (managerUsername.equals(username) && managerPassword.equals(password)) {
            userInterface.stockCheck();
        } else {
            System.out.println("Wrong Password.. Exiting the Stationary Stock System.");
            System.exit(0);
        }
    }
}

class Biller{
	UserInterface userInterface = new UserInterface();
    private String username;
    private String password;

    Scanner input = new Scanner(System.in);
    
    public Biller(String Username, String Password) {
		// TODO Auto-generated constructor stub
        this.username = Username;
        this.password = Password;
	}
	
    public void checkAuthentication() {	   
            System.out.println("Enter Username");
            String billerUsername = input.nextLine();
            System.out.println("Enter Password");
            String billerPassword = input.nextLine();

            if (billerUsername.equals(username) && billerPassword.equals(password)) {
            	userInterface.generateBill();
            } else {
                System.out.println("Wrong Password.. Exiting the Stationary Stock System.");
                System.exit(0);
            }
    }
}

public class Stationary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserInterface userInterface = new UserInterface();
        StockManagement stockManagement = new StockManagement("MEGHA", "MEGZ");
        Biller Shopekeeper = new Biller("Megha","megz");

        System.out.println("\t\t\t\t\t\tSTATIONARY BILLING SYSTEM");
        boolean loop = true;
        while(loop) {
        userInterface.operations();

        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                userInterface.menu();
                System.out.println("Do you want to perform further operations?");
        		System.out.println("Enter 1 for yes and 0 for no");
        		int n = input.nextInt();
        		if (n == 1) {
                userInterface.operations();
                System.out.print("\nEnter your choice: ");
                choice = input.nextInt();
                input.nextLine();
                }
                break;
            case 2:
                System.out.println("Enter Stock_Manager UserName:");
                stockManagement.checkAuthentication();
                System.out.println("Do you want to perform further operations?");
        		System.out.println("Enter 1 for yes and 0 for no");
        		int M = input.nextInt();
        		if (M == 1) {
                userInterface.operations();
                System.out.print("\nEnter your choice: ");
                choice = input.nextInt();
                input.nextLine();
                }
                break;
            case 3:
            	System.out.println("Enter Stock_Manager UserName:");
                stockManagement.checkAuthentication();
                userInterface.stockUpdate();
                System.out.println("Do you want to perform further operations?");
        		System.out.println("Enter 1 for yes and 0 for no");
        		int o = input.nextInt();
        		if (o == 1) {
                userInterface.operations();
                System.out.print("\nEnter your choice: ");
                choice = input.nextInt();
                input.nextLine();
                }
                break;
            case 4:
                userInterface.placeOrder();
                System.out.println("Do you want to perform further operations?");
        		System.out.println("Enter 1 for yes and 0 for no");
        		int p = input.nextInt();
        		if (p == 1) {
                userInterface.operations();
                System.out.print("\nEnter your choice: ");
                choice = input.nextInt();
                input.nextLine();
                }
                break;
            case 5:
            	System.out.println("Enter Biller UserName:");
            	Shopekeeper.checkAuthentication();
            	userInterface.generateBill();
                break;
            case 6:
                System.out.println("Exiting the Stationary Billing System.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                input.close();

            }
        }
    }
}
