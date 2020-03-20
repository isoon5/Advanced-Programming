import java.util.Comparator;

public class Main {
    public static void main(String[] args){

        Item book1 = new Book("Dragon Rising", 3,5);
        Item book2 = new Book("A blade in the dark", 3,5);
        Item food1 = new Food("Cabbage",2,4);
        Item food2 = new Food("Rabbit",5,10);
        Item weapon = new Weapon(WeaponType.SWORD,5,10);

        Knapsack collection = new Knapsack(10);
        collection.addItem(book1);
        collection.addItem(book2);
        collection.addItem(food1);
        collection.addItem(food2);
        collection.addItem(weapon);

        System.out.println("Unordered elements:"+ "\n" + collection);

        collection.sort(collection.getItems(), new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Ordered by name"+"\n"+collection);


    }
}
