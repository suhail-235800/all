package in.stackroute.ust.domain;

public class Item {

    // class used to represent the items in the inventory
    int itemId;
    String itemName;
    String itemDesc;
    double itemPrice;
    int itemQty;

    Item(int itemId,String itemName,String itemDesc,double itemPrice,int itemQty){
        this.itemId=itemId;
        this.itemName=itemName;
        this.itemDesc=itemDesc;
        this.itemPrice=itemPrice;
        this.itemQty=itemQty;
    }
}
