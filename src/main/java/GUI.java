import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI {

    public static void Menue() {
        try {
            String eingabe = JOptionPane.showInputDialog("Möchtest du eine (n)eue Katze hinzufügen," +
                    " dich über deine Katzen (i)nformieren, das Impf(d)atum aktualisieren," +
                    "ein Spiel (s)pielen oder das Programm b(e)enden?");
            if (eingabe.equals("i")) {GUI.Katzeninfos();}
            else if (eingabe.equals("n")) {GUI.NewCat();}
        }
        catch (RuntimeException ausnahme) {
                JOptionPane.showMessageDialog(null,"Bitte das nächste Mal einen der vorgegebenen Buchstaben nutzen", "Fehler", JOptionPane.WARNING_MESSAGE);
                System.out.print(ausnahme);
            }
        }

    public static void Katzeninfos() {
        for (Cat cat : Cats.getCats()) {
            if (cat.isRund()) {
                JOptionPane.showMessageDialog(null, "Die Katze " +
                        cat.getKatzenname() + " ist rund! Er wurde zuletzt im " + cat.getImpfdatum() +
                        " geimpft.", "Infos", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Die Katze " + cat.getKatzenname() + " ist schlank! " +
                        "Er wurde zuletzt im " + cat.getImpfdatum() + " geimpft.", "Infos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /** NewCat ist eine Methode welche simple GUI-Elemente nutzt um dem Datensatz ein neues Katzenobjekt
     * hinzuzufügen, und es gleichzeitig in der txt-Datei zu speichern. */
    public static void NewCat() {
        String katzenname = null;
        int alter = 0;
        String impfdatum = null;
        double gewicht = 0;
        boolean rund = false;
        boolean suess = false;


        JOptionPane.showMessageDialog(null, "Geben Sie jetzt die ihnen bekannten Eigenschaften" +
                " ihrer neuen Katze ein. Wenn Sie Eigenschaften nicht kennen, überspringen Sie das Feld ohne Eingabe.");
        try {
            File datei = new File("target/classes/Cats.txt");
            boolean neu = false;
            if (!datei.exists()) {
                datei.createNewFile();
                neu = true;
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "target/classes/Cats.txt", true));
            if (!neu) {
                bw.write("\n");
            }
            String eingabe = JOptionPane.showInputDialog("Der Name der Katze ist: ");
            katzenname = eingabe;
            bw.write("\n" + eingabe);
            eingabe = JOptionPane.showInputDialog("Das Alter der Katze in Jahren ist: ");
            alter = Integer.parseInt(eingabe);
            bw.write("\n" + eingabe);
            eingabe = JOptionPane.showInputDialog("Die letzte Impfung der Katze war im (Monat Jahr): ");
            impfdatum = eingabe;
            bw.write("\n" + eingabe);
            eingabe = JOptionPane.showInputDialog("Das Gewicht der Katze ist (kg mit zwei Kommastellen) ");
            gewicht = Double.parseDouble(eingabe);
            bw.write("\n" + eingabe);
            eingabe = "0";
            while (!eingabe.equals("j")  & !eingabe.equals("n")) {
                eingabe = JOptionPane.showInputDialog("Die Katze ist rund (j/n)");
                if (eingabe.equals("j")) {
                    rund = true;
                    bw.write("\n" + "true");
                } else if (eingabe.equals("n")) {
                    rund = false;
                    bw.write("\n" + "false");
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie einen " +
                            "gültigen Wert ein", "Fehler", JOptionPane.WARNING_MESSAGE);
                }
            }
            eingabe = "0";
            while (!eingabe.equals("j") & !eingabe.equals("n")) {
                eingabe = JOptionPane.showInputDialog("Die Katze ist suess (j/n)");
                if (eingabe.equals("j")) {
                    suess = true;
                    bw.write("\n" + "true");
                } else if (eingabe.equals("n")) {
                    suess = false;
                    bw.write("\n" + "false");
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie einen " +
                            "gültigen Wert ein", "Fehler", JOptionPane.WARNING_MESSAGE);
                }
            }
            bw.close();
        }
        catch (IOException ioAusnahme) {
            JOptionPane.showMessageDialog(null,
                    "Fehler beim Öffnen der Datei", "Fehler", JOptionPane.WARNING_MESSAGE);
        }
        Cat newCat = new Cat (katzenname,alter,impfdatum,gewicht,rund,suess);
        Cats.addKatze(newCat);
        System.out.println(Cats.getCat(2));
    }
}
