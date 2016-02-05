import java.util.ArrayList;

//*
//* Siin failis kasutatakse objekti Kassa, aga Kassa klassi ei eksisteeri. Sinu ülesanne
// * on see luua. Pane tähele, et mitte ükski objekti muutuja ei tohi olla
//* kättesaadav objektist väljaspoolt.
//*
// * Käesolevat klassi ei tohi muuta - mitte ühtegi tähemärki! Arvad, et ei jää vahele? :)


public class ObjektKassa {

    public static void main(String[] args) {

        String kassapidaja = "Laine";
        Kassa kassa = new Kassa(kassapidaja);

        kassa.lisaToode("Piim");
        kassa.lisaToode("Sai");
        kassa.lisaToode("Lillkapsas");
        kassa.lisaToode("Lamuu jäätis");
        kassa.lisaToode("Kanepiküpsis");
        kassa.eemaldaToode("Piim");
        kassa.eemaldaToode("Sai");
        kassa.lisaToode("Leib");

        System.out.println("Klient ostis järgmised tooted: " + kassa.votaTooted());
        System.out.println("Tooteid on kokku: " + kassa.votaToodeteArv());
        System.out.println("Kassapidaja nimi on " + kassa.votaKassapidajaNimi());

        kassa.kliendilPoleRaha(); // Mis nüüd saab?

        System.out.println("Klient ostis järgmised tooted: " + kassa.votaTooted());
        System.out.println("Tooteid on kokku: " + kassa.votaToodeteArv());
    }
}

class Kassa {

    private static ArrayList<String> korv = new ArrayList();
    private static String nimi;

    public Kassa(String kassapidaja) {
        nimi = kassapidaja;
    }

    public void lisaToode(String x) {
        korv.add(x);
    }

    public void eemaldaToode(String x) {
        korv.remove(x);
    }

    public String votaTooted() {
        return korv.toString();
    }

    public String votaToodeteArv() {
        return String.valueOf(korv.size());
    }

    public String votaKassapidajaNimi() {

        return nimi;
    }

    public void kliendilPoleRaha() {
        korv.clear();
    }
}

