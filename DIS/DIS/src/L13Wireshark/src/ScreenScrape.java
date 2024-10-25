import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ScreenScrape {
    private static boolean found = false;

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://valutakurser.dk ");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String line;
        found = false;
        while ((line = br.readLine()) != null && !found) {

            String[] a = line.split("/");
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("amerikanske-dollar")) {
                    found = true;
                }
            }
        }
        if (found){
            String s = line.substring(278,284);
            System.out.println("Kursen for USD er: " + s);
//            if (line.contains("USD")) {
//                String[] laks = line.split(">");
//                for (int i = 0; i < laks.length; i++) {
//                    if (laks[i].contains(",")) {
//                        laks[i].replaceAll("[^\\d.]", "");
//                        String[] måge = laks[i].split("<");
//
//                            System.out.println(måge[0]);
//                    }
//                }
//            }
        }
    }
}
