/**Dieses Programm erschafft Katzen als Objekte und stopft sie in einen Objektcontainer,
 * verschiedene Umwandlungsoperationen werden dadurch ermöglich */
public class CatControl {

    public static void main(String[] args) {
        //Die Katzen werden als Objekte der Klasse Cat aus Cats.txt erschaffen und in den Katzencontainer gesteckt
        Cats.catKreation();
        //Wir lesen Werte aus dem Container aus
        //Cats.checkCats();
        //Wir checken ob wir Objekte aus dem Container herausnehmen können
        GUI.Menue();
    }
}
