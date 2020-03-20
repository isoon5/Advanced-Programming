public interface Item {
    String getName();
    double getWeight();
    double getValue();
    default double profitFactor(){
        return getValue() / getWeight();
    }
}
