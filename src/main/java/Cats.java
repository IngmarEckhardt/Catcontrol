
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cats extends Cat {
    public static int katzencount;
    private static final ArrayList<Cat> cats = new ArrayList<Cat>();

    public static ArrayList<Cat> getCats() {
        return cats;
    }

    public static void main() {
        String linie;
        String katzenname;
        int alter;
        String impfdatum;
        double gewicht;
        boolean rund;
        boolean suess;



        try {
            FileInputStream fis = new FileInputStream("target/classes/Cats.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            linie = br.readLine();

            while (linie != null) {
                if ("".equals(linie)) {
                    katzencount++;
                }
                linie = br.readLine();
            }
            br.close();
        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
        try {

            FileInputStream fis2 = new FileInputStream("target/classes/Cats.txt");
            InputStreamReader isr2 = new InputStreamReader(fis2);
            BufferedReader br2 = new BufferedReader(isr2);

            for (int i = 0; i < katzencount; i++) {
                linie = br2.readLine();
                linie = br2.readLine();
                katzenname = linie;
                linie = br2.readLine();
                alter = Integer.parseInt(linie);
                linie = br2.readLine();
                impfdatum = linie;
                linie = br2.readLine();
                gewicht = Double.parseDouble(linie);
                linie = br2.readLine();
                rund = Boolean.parseBoolean(linie);
                linie = br2.readLine();
                suess = Boolean.parseBoolean(linie);
                Cat newCat = new Cat(katzenname, alter, impfdatum, gewicht, rund, suess);
                cats.add(newCat);
                System.out.println("Die Katze " + newCat + " wurde erzeugt.");
            }
            br2.close();
            System.out.println();
        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
        // System.out.println("Das Katzenarray wurde erstellt 2" + cats);

    }
}