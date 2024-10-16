import java.io.*;

public class TextFileManipulationBufferedReader {

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\pc1\\Desktop\\cjt.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }
}
