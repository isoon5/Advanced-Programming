public class Hospital {
    private String name;
    private int capacity;

    public Hospital(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public Hospital(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    @Override
    public String toString(){
        return this.name;
    }

    public int compareTo(Hospital anotherHospital){
        return anotherHospital.getName().compareTo(this.name);
    }

}
