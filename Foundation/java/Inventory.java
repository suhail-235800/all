package in.stackroute.ust.domain;

public class Inventory {

    // class used to manage the items in the inventory
    Item[] inventory = new Item[10];
    int count = 0;

    public void addItem(String name,String desc,double price,int qty){
        Item item = new Item(count+1,name,desc,price,qty);
        inventory[count]=item;
        count++;
    }

    public void displayItems(){
        System.out.println("\nItemId\t\tItemName\tItemDescription\t\t\tItemPrice\tItemQuantity");
        System.out.println("......\t\t........\t...............\t\t\t.........\t............");
        for (int i=0;i<count;i++) {
            System.out.println(inventory[i].itemId+"\t\t\t"+inventory[i].itemName+"\t\t"+inventory[i].itemDesc+
                    "\t\t\t\t"+inventory[i].itemPrice+"\t\t"+inventory[i].itemQty);
        }
    }

    public void searchItem(String name){
        int flag=0;
        System.out.println("\nItemId\t\tItemName\tItemDescription\t\t\tItemPrice\tItemQuantity");
        System.out.println("......\t\t........\t...............\t\t\t.........\t............");
        for (int i=0;i<count;i++) {
            if(inventory[i].itemName.equals(name)){
                System.out.println(inventory[i].itemId+"\t\t\t"+inventory[i].itemName+"\t\t"+inventory[i].itemDesc+
                        "\t\t\t\t"+inventory[i].itemPrice+"\t\t"+inventory[i].itemQty);
                flag=1;
            }
        }
        if(flag == 0){
            System.out.println("Not found.");
        }
    }
}
