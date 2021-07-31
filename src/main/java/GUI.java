import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI {
    private final Cat cat = new Cat();

    public static void main() {
        GUI gui = new GUI();
        try {
            String eingabe = "0";
            while (!eingabe.equals("i") && !eingabe.equals("n") && !eingabe.equals("p") && !eingabe.equals("e") && !eingabe.equals("d")) {
                eingabe = JOptionPane.showInputDialog("Möchtest du eine (n)eue Katze hinzufügen," +
                        " dich über deine Katzen (i)nformieren, das Impf(d)atum aktualisieren," +
                        "ein S(p)iel spielen oder das Programm b(e)enden?");

                if (eingabe.equals("i")) {
                    gui.katzeninfos();
                } else if (eingabe.equals("n")) {
                    gui.newCat();
                } else if (eingabe.equals("p")) {
                    gui.playCats();
                } else if (eingabe.equals("d")) {
                    gui.changeImpftermin();
                } else if (eingabe.equals("e")) {
                    JOptionPane.showMessageDialog(null, "Programm wird beendet.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte wähle mit den Buchstaben i, n, p und e");
                }
            }
        } catch (RuntimeException ausnahme) {
            JOptionPane.showMessageDialog(null, "Programm wird abgebrochen", "Fehler", JOptionPane.WARNING_MESSAGE);
            System.out.print(ausnahme);
        }
    }

    private void playCats() {
        Cat.schnurren();
        GUI.main();
    }

    private void katzeninfos() {
        //System.out.println("Das Katzenarray wird erzeugt" + Cats.getCats());
        for (Cat cat : Cats.getCats()) {
            if (cat.isRund()) {
                JOptionPane.showMessageDialog(null, "Die Katze " +
                        cat.getKatzenname() + " ist rund! Er wurde zuletzt im " + cat.getImpfdatum() +
                        " geimpft.", "Infos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Die Katze " + cat.getKatzenname() + " ist schlank! " +
                        "Er wurde zuletzt im " + cat.getImpfdatum() + " geimpft.", "Infos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        GUI.main();
    }

    /**
     * NewCat ist eine Methode welche simple GUI-Elemente nutzt um dem Datensatz ein neues Katzenobjekt
     * hinzuzufügen, und es gleichzeitig in der txt-Datei zu speichern.
     */
    private void newCat() {
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
            while (!eingabe.equals("j") & !eingabe.equals("n")) {
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
        } catch (IOException ioAusnahme) {
            JOptionPane.showMessageDialog(null,
                    "Fehler beim Öffnen der Datei", "Fehler", JOptionPane.WARNING_MESSAGE);
        }
        Cat newCat = new Cat(katzenname, alter, impfdatum, gewicht, rund, suess);
        Cats.getCats().add(newCat);
        main();
    }

    private void changeImpftermin() {
        String newImpftermin;


        String eingabe = JOptionPane.showInputDialog("Bei welcher Katze soll das Impfdatum aktualisiert werden?");
        for (int i = 0; i < Cats.katzencount; i++) {
            if (Cats.getCats().get(i).getKatzenname().equals(eingabe)) {
                newImpftermin = JOptionPane.showInputDialog(null, Cats.getCats().get(i).getKatzenname() + " wurde im " + Cats.getCats().get(i).getImpfdatum() + " geimpft. Welches aktualisierte Impfdatum soll gespeichert werden?");
                Cats.getCats().get(i).setImpfdatum(newImpftermin);
            }
        }
        saveCompleteArray();
        main();
    }

    private void saveCompleteArray() {
        String katzenname = null;
        int alter = 0;
        String impfdatum = null;
        double gewicht = 0;
        boolean rund = false;
        boolean suess = false;
        try {

            File datei = new File("target/classes/Cats.txt");
           if (!datei.exists()) {
                datei.createNewFile();

            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "target/classes/Cats.txt", false));
            for (int i = 0; i < Cats.katzencount; i++) {
                if (i>0) {bw.write("\n");}
                bw.write("\n" + Cats.getCats().get(i).getKatzenname());
                bw.write("\n" + Cats.getCats().get(i).getAlter());
                bw.write("\n" + Cats.getCats().get(i).getImpfdatum());
                bw.write("\n" + Cats.getCats().get(i).getGewicht());
                if (Cats.getCats().get(i).isRund()) {bw.write("\n" + "true");}
                else {bw.write("\n" + "false");}
                if (Cats.getCats().get(i).isSuess()) {bw.write("\n" + "true");}
                else {bw.write("\n" + "false");}
            }
            bw.close();

        } catch (IOException ioAusnahme) {
            JOptionPane.showMessageDialog(null,
                    "Fehler beim Öffnen der Datei", "Fehler", JOptionPane.WARNING_MESSAGE);
        }
    }
}