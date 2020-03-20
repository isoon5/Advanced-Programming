public class Food implements Item{
    private String name;
    private double weight;
    private double value;

    public Food(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
    public String getName(){
        return name;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getValue(){
        return this.value;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setValue(){
        this.value = getWeight() * 2;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                '}'+"\n";
    }
}
