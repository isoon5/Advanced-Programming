public class Tour {
    private Client[] clients;
    private Vehicle[] vehicles;

    public Client[] getClient(){
        return clients;
    }
    public Vehicle[] getVehicle(){
        return vehicles;
    }
    public void setVehicles(Vehicle vehicle){
            this.vehicle = vehicle;
    }
    public void setClients(Client[] clients){
        this.client = client;
    }
}
