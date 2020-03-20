public class Depot {
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    private Vehicle[] vehicles;

    public Vehicle[] getVehicles(){
        return vehicles;
    }

    public Depot(String name){
        this.name = name;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles){
            v.setDepot(this);
        }
    }
}
