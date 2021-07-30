import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cats {
    private static int katzencount = 0;
    private static ArrayList<Cat> cats = new ArrayList<Cat>();
    private static Cat ernst;
    private static Cat katzilla;

    /** Die Methode catKreation erzeugt Objekte aus der Datei cats.txt und reiht sie nach der Erzeugung in eine
     * ArrayList ein.*/
    public static void catKreation() {
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
                if ("".equals(linie)) {katzencount++;}
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
                addKatze(newCat);
                System.out.println("Die Katze " + newCat + " wurde erzeugt.");
            }
            br2.close();
            System.out.println("");
        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
    }

    /** Mit der Methode addKatze mit dem Parameter eines Objekts der Klasse Cat, reiht man das Objekt
     * in eine arrayList ein. Das hinzuzufügende Objekt dient als Parameter.*/
    protected static void addKatze(Cat katze) {
        cats.add(katze);
    }

    /** Die Methode checkCats überprüft Körperbau und Impfstatus der Katzen*/
    public static void checkCats() {
        for (Cat cat : cats) {
            if (cat.isRund()) {
                System.out.print("Die Katze " + cat.getKatzenname() + " ist rund! ");
            }
            else System.out.print("Die Katze " + cat.getKatzenname() + " ist schlank! ");

            System.out.println("Er wurde zuletzt im " + cat.getImpfdatum() + " geimpft.");
            //cat.setImpfdatum("September 2021");

            System.out.println("Die neueste Impfung der Katze geschah im " + cat.getImpfdatum());
            System.out.println("");
        }
    }
    /**Mit der Methode getKatzencount kann man die Anzahl der Katzenobjekte im Datensatz ausgeben*/
    public static int getKatzencount() {
        return katzencount;
    }
    /** Mit der Methode setKatzencount kann der Zähler der Objektanzahl verändert werden. Der neue Zähler
     * dient als Parameter */
    public static void setKatzencount(int katzencount) {
        Cats.katzencount = katzencount;
    }
    /** Die Methode getCats gibt die arrayList aller erzeugten Katzen-Objekte aus */
    public static ArrayList<Cat> getCats() {
        return cats;
    }
    /** Die Methode getCat gibt ein einzelnes Katzenobjekt aus der arrayList heraus, der Parameter dient als Parameter beim Listenzugriff*/
    public static Cat getCat(int catCount) {

        return  Cats.cats.get(catCount);
    }

    /** Mit der Methode setCats kann die bestehende ArrayList komplett ausgetauscht werden, die neue
     * ArrayList dient als Parameter */
    public void setCats(ArrayList<Cat> cats) {
        Cats.cats = cats;
    }
    /** Die Methode getErnst gibt das Katzenobjekt ernst zurück*/
    public static Cat getErnst() {
        return ernst;
    }
    /** Die Methode getKatzilla gibt das Katzenobjekt katzilla zurück*/
    public static Cat getKatzilla() {
        return katzilla;
    }
    /** Die Methode setKatzilla erlaubt es das das Katzenobjekt katzilla neu zuzuweisen*/
    public static void setKatzilla(Cat katzilla) {
        Cats.katzilla = katzilla;
    }
    /** Die Methode setKatzilla erlaubt es das das Katzenobjekt ernst neu zuzuweisen*/
    public static void setErnst(Cat ernst) {
        Cats.ernst = ernst;
    }
    //Hier wird der Katzencontainer bei Bedarf geprüft
    public static void checkKatzencontainer() {
        System.out.println("Die Zuweisung des Katzencontainers im Speicher wurde referenziert mit: " + cats);
        System.out.println("Deine erste Katze im Katzencontainer ist: " + cats.get(0));
        System.out.println("Check erfolgreich.");
        System.out.println("");
    }
}
