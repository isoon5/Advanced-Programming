import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;


public class CatalogUtil {
    public static void save(Catalog catalog)
        throws IOException{
        try(var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path){

        Catalog c = new Catalog(null, null);
        try{
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Catalog) in.readObject();
            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(c.toString());
            return c;
        }

    }

    public static Desktop view(String pathOrLink){
        Desktop d = Desktop.getDesktop();
        try{

            if(pathOrLink.contains("http") || pathOrLink.contains("https")){
            URI myUri = new URI(pathOrLink);


                d.browse(myUri);

            } else{

                File file = new File(pathOrLink);
                d.open(file);

            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        finally {
            return d;
        }
    }








}
