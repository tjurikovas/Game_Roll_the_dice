import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Guess {
    private static int z;

    public static void main(String[] args) throws IOException {

        File f = new File("my.txt");
        f.createNewFile();

        if(f.exists()){
            Scanner scanner = null;
            try {
                scanner = new Scanner(f);
                if (scanner.hasNextInt()) {
                    z = scanner.nextInt();
                    System.out.println(z);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File not found!");
        }
    }

}
