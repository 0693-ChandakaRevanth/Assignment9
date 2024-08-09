import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class ExceptionHandlingWithResourceCleanUp {
    public static void main(String[] args) {
        File file = new File("input1.txt");
        try{
            file.createNewFile();
            System.out.println("File created");
        }catch(IOException e){
            System.out.println(e);
        }
        try(BufferedReader reader = new BufferedReader(new FileReader("input1.txt"))){
            String line;
            while((line= reader.readLine())!=null)
                System.out.println(line);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}