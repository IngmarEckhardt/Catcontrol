import javax.swing.JOptionPane;

public class GUI {

    public static void Menue() {
        try {
            String eingabe = JOptionPane.showInputDialog("Möchtest du eine (n)eue Katze hinzufügen," +
                    "dich über deine Katzen (i)nformieren, das Impf(d)atum aktualisieren," +
                    "ein Spiel (s)pielen oder das Programm b(e)enden?");
            if (eingabe.equals("i")) {GUI.Katzeninfos();}
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
}
