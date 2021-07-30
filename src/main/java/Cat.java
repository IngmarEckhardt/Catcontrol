public class Cat {
    private final String katzenname;
    private int alter;
    private String impfdatum;
    private double gewicht;
    private boolean rund;
    private boolean suess;
    private boolean schnurrt;
    private boolean spielt;
    private boolean fight;
    private int ort;

    public Cat(String katzenname, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {
        this.katzenname = katzenname;
        this.alter = alter;
        this.impfdatum = impfdatum;
        this.gewicht = gewicht;
        this.rund = rund;
        this.suess = suess;
        schnurrt = false;
        spielt = false;
        fight = false;
        ort = 0;
    }

    //@Override
    public String toString() {
        return "Cat{" + katzenname + '}';
    }

    public String getKatzenname() {
        return katzenname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getImpfdatum() {
        return impfdatum;
    }

    public void setImpfdatum(String impfdatum) { this.impfdatum = impfdatum; }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
    public boolean isRund() {
        return rund;
    }

    public void setRund(boolean rund) {
        this.rund = rund;
    }

    public boolean isSuess() {
        return suess;
    }

    public void setSuess(boolean suess) {
        this.suess = suess;
    }
    public boolean isSchnurrt() {
        return schnurrt;
    }

    public void setSchnurrt(boolean schnurrt) {
        this.schnurrt = schnurrt;
    }

    public boolean isSpielt() {
        return spielt;
    }

    public void setSpielt(boolean spielt) {
        this.spielt = spielt;
    }

    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }

    public int getOrt() {
        return ort;
    }

    public void setOrt(int ort) {
        this.ort = ort;
    }

    public static void miauen() {
        System.out.println("Miau");
    }

    public static void fauchen() {
        System.out.println("Fauch!!!");
    }
    public static void schnurren() {
        System.out.println("Schnurr");
    }

    public static void essen() {
        System.out.println("Mampf, mampf, mampf");
    }
}
