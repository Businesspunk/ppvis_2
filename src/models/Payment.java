package models;

public class Payment {

    protected int cost;
    protected String type;

    public Payment(int cost, String type){
        this.cost = cost;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }
}
