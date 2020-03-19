import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog)
        throws IOException{
        try(var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
        throws InvalidClassException{
        try(var oos = new ObjectInputStream(
                new FileInputStream(path))){
            oos.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ;
    }
}
