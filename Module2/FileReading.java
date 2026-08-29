package Module2;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class FileReading {
    public static void main(String[] args ){
        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                System.out.println("The doubled value of number is: " + (number *2)); 
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage())   ;
        }
    }
}