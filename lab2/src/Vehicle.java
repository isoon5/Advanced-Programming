public abstract class Vehicle {
    private String name;
    private Depot depot;
    //private VehicleType type;
    public Vehicle(String name){ this.name = name; }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
    }
    public Depot getDepot(){
        return depot;
    }

    public String toString() {
        return "Vehicle [name=" + name + ", depot=" + depot + "]";
    }


    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }

}
