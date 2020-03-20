public class Book implements Item {
    private String name;
    private double pageNumber;
    private double value;

    public Book(String name, int pageNumber, double value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPageNumber(double pageNumber){
        this.pageNumber = pageNumber;
    }
    public void setValue(double value){
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public double getWeight(){
        return this.pageNumber / 100;
    }

    public double getValue(){
        return this.value;
    }

    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pageNumber=" + pageNumber +
                ", value=" + value +
                '}'+"\n";
    }
}
