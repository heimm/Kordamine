import java.util.ArrayList;

/**
 * Siin failis kasutatakse objekti Foor, aga Foor klassi ei eksisteeri. Sinu �lesanne
 * on see luua. Pane t�hele, et mitte �kski objekti muutuja ei tohi olla
 * k�ttesaadav objektist v�ljaspoolt.
 *
 * K�esolevat klassi ei tohi muuta! Arvad, et ei j�� vahele? :)
 */
public class ObjektFoor {

    public static void main(String[] args) {

        String fooriNimetus = "S�le-Paldiski SR3A";
        Foor foor = new Foor(fooriNimetus);

        foor.syytaTuli("punane");
        foor.syytaTuli("kollane");
        foor.syytaTuli("roheline");
        foor.kustutaTuli("punane");
        foor.kustutaTuli("kollane");

        System.out.println("Fooril peaks p�lema ainult punane, tegelt p�leb: " + foor.misTuledPolevad());
        System.out.println("Foori nimetus on " + foor.votaNimetus());

        foor.hakkeridSaidKontrolli(); // Paanika!

        System.out.println("Fooris p�levad tuled: " + foor.misTuledPolevad());
        System.out.println("Foori nimetus on: " + foor.votaNimetus());
    }
}

class Foor {

    private static int pun = 0;
    private static int kol = 0;
    private static int roh = 0;
    private static String nimi;


    public Foor(String fooriNimetus) {
        nimi = fooriNimetus;

    }

    public void syytaTuli(String x) {
        if (x == "punane"){
            pun = 1;
        }else if(x == "kollane"){
            kol = 1;
        }else if(x == "roheline"){
            roh = 1;
        }

    }

    public void kustutaTuli(String x) {
        if (x == "punane"){
            pun = 0;
        }else if(x == "kollane"){
            kol = 0;
        }else if(x == "roheline"){
            roh = 0;
        }

    }

    public String misTuledPolevad() {
        ArrayList a = new ArrayList();

        if (pun == 1){
            a.add("punane");
        }
        if (kol == 1){
            a.add("kollane");
        }
        if (roh == 1){
            a.add("roheline");
        }

        return a.toString();

    }

    public String votaNimetus() {

        return nimi;
    }

    public void hakkeridSaidKontrolli() {
        pun = 1;
        kol = 1;
        roh = 1;
        nimi = "HAKITUD!";
    }
}
