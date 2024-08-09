package Try_With_MultipleResources;
import java.io.*;
public class Try_With_MultipleResources {
        public static void main(String[] args) {
            File file1 = new File("Try_With_MultipleResources/file1.txt");
            try {
                if (file1.createNewFile())
                    System.out.println(file1.getName() + " created");
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file2 = new File("Try_With_MultipleResources/file2.txt");
            try {
                if (file2.createNewFile())
                    System.out.println(file2.getName() + " created");
            } catch (IOException e) {
                e.printStackTrace();
            }
            File destination_file = new File("Checked_Unchecked/destination.txt");
            try {
                if (destination_file.createNewFile())
                    System.out.println(destination_file.getName() + " created");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader reader1 = new BufferedReader(new FileReader("Try_With_MultipleResources/file1.txt"));
                 BufferedReader reader2 = new BufferedReader(new FileReader("Try_With_MultipleResources/file2.txt"));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("Try_With_MultipleResources/destination.txt"))) {
                String line;
                while ((line = reader1.readLine()) != null) {
                    writer.write(line);
                }
                writer.write("\n");

                while ((line = reader2.readLine()) != null) {
                    writer.write(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}