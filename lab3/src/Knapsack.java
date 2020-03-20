import java.util.*;

public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Knapsack(List<Item> items) {
        this.items = items;
    }

    public Knapsack(double capacity) {
        this.capacity = capacity;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void sort(List<Item> list, Comparator<?super Item>c){
        list.sort(c);

    }

    public void printItems(){
        for (Item item:items) {
            System.out.println(item);

        }

    }

    public String toString() {
        return "Knapsack{" +
                "items="+"\n" + items +
                '}';
    }


}
