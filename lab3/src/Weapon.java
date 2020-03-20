public class Weapon implements Item {
    private WeaponType type;
    private double weight;
    private double value;

    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    public void setPageNumber(double weight){
        this.weight = weight;
    }
    public void setValue(double value){
        this.value = value;
    }
    public void setType(WeaponType type){
        this.type = type;
    }
    public String getName(){
        return type.name();
    }

    public double getWeight(){
        return this.weight;
    }

    public double getValue(){
        return this.value;
    }
    public String toString() {
        return "Weapon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                '}'+"\n";
    }
}
