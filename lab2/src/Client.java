public class Client {
    private String name;
    private int order;
    public Client(String name, int order){
        this.name = name;
        this.order = order;
    }
    public String getName(){
        return name;
    }
    public int getOrder(){
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String toString(){
        return name;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
