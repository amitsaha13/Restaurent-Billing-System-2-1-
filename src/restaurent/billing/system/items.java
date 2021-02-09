package restaurent.billing.system;
//Class for items which returns item_id,item_name,item_price

class items {

    private String Item_ID, Item_NAME, Item_Price;

    public items(String Item_ID, String Item_NAME, String Item_Price) {
        this.Item_ID = Item_ID;
        this.Item_NAME = Item_NAME;
        this.Item_Price = Item_Price;
    }

    public String getID() {
        return Item_ID;
    }

    public String getItemName() {
        return Item_NAME;
    }

    public String getItemPrice() {
        return Item_Price;
    }

}
