import java.util.ArrayList;

//*
//* Siin failis kasutatakse objekti Seljakott, aga Seljakott klassi ei eksisteeri. Sinu �lesanne
//* on see luua. Pane t�hele, et mitte �kski objekti muutuja ei tohi olla
//* k�ttesaadav objektist v�ljaspoolt.
//*
//* K�esolevat klassi ei tohi muuta! Arvad, et ei j�� vahele? :)

public class ObjektSeljakott {

    public static void main(String[] args) {

        String omanikuNimi = "Kihnu Virve";
        Seljakott kott = new Seljakott(omanikuNimi);

        kott.lisaAsi("Hambapasta");
        kott.lisaAsi("Hambahari");
        kott.lisaAsi("Pleier");
        kott.lisaAsi("Langevari");
        kott.eemaldaAsi("Langevari"); // Ah mis sellest ikka vedada, saab ilma ka

        System.out.println("Kotis on j�rgmised asjad: " + kott.misOnKotis());
        System.out.println("Asju on kotis nii mitu: " + kott.mituAsjaOnKotis());
        System.out.println("Omaniku nimi on: " + kott.omanikuNimi());

        kott.rebene(); // oh shit, mis n��d saab?

        System.out.println("Kotis on j�rgmised asjad: " + kott.misOnKotis());
        System.out.println("Asju on kotis nii mitu: " + kott.mituAsjaOnKotis());
    }
}

class Seljakott {


    private static ArrayList<String> seljakott = new ArrayList();
    private static String name;

    public Seljakott(String omanikuNimi) { //Konstruktor on see
        name = omanikuNimi;
    }

    public void lisaAsi(String x) {

        seljakott.add(x);

    }

    public void eemaldaAsi(String x) {
        seljakott.remove(x);

    }

    public String misOnKotis() {
        return seljakott.toString();
    }

    public String mituAsjaOnKotis() {

        int counter = 0;
        for (String s : seljakott) {
            counter += 1;
        }

        return Integer.toString(counter);
    }

    public String omanikuNimi() {

        return name;
    }

    public void rebene() {
        seljakott.clear();
    }
}
