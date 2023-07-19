package in.stackroute.ust;

import in.stackroute.ust.domain.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inventory management application - proptotype 1.0");

        // this will be the main entry point for the application,
        // this will be a menu-driven application
        // the menu will have the following options:
        // 1. Add item
        // 2. Search item
        // 3. Display all items
        // 4. Exit
        int choice;
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n\t\t\t\t  MENU\n\t\t\t\t  ....");
            System.out.println("1: Add an Item\t\t\t2: Search an Item\n3: Display Items\t\t4: Exit the Program");
            System.out.println("\nEnter your choice: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1: {
                            String name,desc;
                            double price;
                            int qty;
                            System.out.println("\nEnter the Details:\n.................");
                            System.out.println("Item Name: ");
                            name=scanner.next();
                            System.out.println("Item Description: ");
                            desc=scanner.next();
                            System.out.println("Item Price: ");
                            price=scanner.nextDouble();
                            System.out.println("Item Quantity: ");
                            qty=scanner.nextInt();
                            inventory.addItem(name,desc,price,qty);
                        }
                        break;
                case 2: {
                            System.out.println("Enter the Item Name: ");
                            inventory.searchItem(scanner.next());
                        }
                        break;
                case 3: inventory.displayItems();
                        break;
                case 4: System.out.println("Have a Good Day!");
                        break;
                default: System.out.println("Enter a Valid Choice");
            }
        }while (choice!=4);
    }
}