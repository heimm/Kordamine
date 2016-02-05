import java.util.ArrayList;

//*
//* Siin failis kasutatakse objekti Laev, aga Laev klassi ei eksisteeri. Sinu �lesanne
//* on see luua. Pane t�hele, et mitte �kski objekti muutuja ei tohi olla
//* k�ttesaadav objektist v�ljaspoolt.
//*
//* K�esolevat klassi ei tohi muuta! Arvad, et ei j�� vahele? :)

public class ObjektLaev {

    public static void main(String[] args) {

        String laevaNimi = "Laineraidur";
        Laev raidur = new Laev(laevaNimi);

        raidur.lisaReisija("Teet Kalluste");
        raidur.lisaReisija("Peeter Kaan");
        raidur.lisaReisija("Maire Kaunaste");
        raidur.eemaldaReisija("Peeter Kaan");

        System.out.println("Pardal on j�rgmised isikud: " + raidur.votaReisijad());
        System.out.println("Pardal on nii mitu inimest: " + raidur.reisijateArv());
        System.out.println("Laeva nimi on " + raidur.misNimi());

        raidur.kalaHammustasKummipaatiAugu(); // Paanika!! mis n��d saab?

        System.out.println("Pardal on j�rgmised isikud: " + raidur.votaReisijad());
        System.out.println("Pardal on nii mitu inimest: " + raidur.reisijateArv());
        System.out.println("Laeva nimi on " + raidur.misNimi());
    }
}

class Laev {

    private ArrayList<String> a = new ArrayList();
    private String listString = "";
    private int arv;
    private String s;


    public Laev(String laevaNimi) {
        s = laevaNimi;
    }

    public void lisaReisija(String s) {
        if (a.contains(s)){
            System.out.println("Ups!");
        }else {
            a.add(s);
        }
    }

    public void eemaldaReisija(String s) {
        a.remove(s);
    }

    public String votaReisijad() {
        for (String s : a)
        {
            listString += s + "\t";
        }

        return listString;
    }


    public String reisijateArv() {
        arv = 0;
        for (String s : a){
            arv += 1;
        }
        String strI = String.valueOf(arv);
        return strI;
    }

    public String misNimi() {

        return s;
    }

    public void kalaHammustasKummipaatiAugu() {
        a.removeAll(a);
        listString = "";
    }
}

