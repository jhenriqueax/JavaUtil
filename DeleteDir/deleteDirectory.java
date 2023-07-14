import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
 
class Main{

     public static void main(String[] args)
    {
        File file = new File("/User/Jhenriqueax/Desktop/folder/.");
 
        try {
            deleteDirectory(file.toPath());
            System.out.println("Directory deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteDirectory(Path directory) throws IOException
    {
        Files.walk(directory)
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
    }
}