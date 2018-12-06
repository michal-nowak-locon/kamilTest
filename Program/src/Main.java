import java.io.*;

public class Main {

    public static void main(String[] args) {

        String plik = "C:/Users/Kamil/Desktop/data.txt";
        String linia = "";
        String znak = ",";

        for (int i = 0; i < 5; i++)
            try (BufferedReader br = new BufferedReader(new FileReader(plik))) {

                while ((linia = br.readLine()) != null) {
                    String[] a = linia.split(znak);
                    System.out.println(a[i]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
