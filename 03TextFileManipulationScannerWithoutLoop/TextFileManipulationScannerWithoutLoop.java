import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextManipulationScannerFileWithoutLoop
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        File file = new File("C:\\Users\\pc1\\Desktop\\christinejoyce.txt");
        Scanner sc = new Scanner(file);

        sc.useDelimiter("\\Z");

        System.out.println(sc.next());
    }
}
