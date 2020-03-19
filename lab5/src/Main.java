import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    Main app = new Main();
    app.testCreateSave();
    app.testLoadView();


    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "d:/java/catalog.ser");
        Document document = new Document("java1", "Java Course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type","Slides");
        catalog.add(document);

        CatalogUtil.save(catalog);
    }

    private void testLoadView(){
        Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
        Document doc = catalog.findbyId("java1");
        CatalogUtil.view(doc.getLocation());
    }
}
