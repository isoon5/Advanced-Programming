import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public void add(Document doc){
        documents.add(doc);
    }

    public Catalog(String name, String path){
        this.name = name;
        this.path = path;
    }

    public Document findbyId(String id){
        return documents.stream()
                .filter(d->d.getId().equals(id)).findFirst().orElse(null);
    }

    public String getPath() {
        return this.path;
    }
}
