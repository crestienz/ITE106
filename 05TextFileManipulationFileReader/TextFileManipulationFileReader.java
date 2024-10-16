import java.io.*;

public class TextFileManipulationFileReader {
    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("C:\\Users\\pc1\\Desktop\\cjat.txt");
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char)i);
    }
}
