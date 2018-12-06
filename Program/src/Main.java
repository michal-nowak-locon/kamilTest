import java.io.*;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {

        String file = "C:/Users/Kamil/Desktop/data.txt";
        String line = "";
        String sign = ",";

        for (int i = 0; i > -1; i++) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                while ((line = br.readLine()) != null) {
                    String[] a = line.split(sign);
                    out.println(a[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}