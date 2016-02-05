import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sulle antakse ette mitu gruppi tudengite hindeid. Kuna maksimum hinne on
 * tegelikult 60 punkti, pead esiteks kõik suuremad arvud 60 peale ümardama.
 * Teiseks leia mitu tudengit said alla keskmise iga grupi kohta?
 */
public class TudengidAllaKeskmise {

    // Main klass on ainult sulle endale testimiseks
    public static void main(String[] args) {

        System.out.println(allaKeskmise(new int[]{19, 45, 55, 67, 89}));
        System.out.println(allaKeskmise(new int[]{55, 23, 88, 56, 43, 90, 34}));
        System.out.println(allaKeskmise(new int[]{21, 85, 45}));

    }

    // Siia meetodi sisse kirjuta lahendus.
    private static int allaKeskmise(int[] ints) {
        System.out.println(Arrays.toString(ints));
        //ArrayList a =new ArrayList();
        int[] m;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 60){
                ints[i] = 60;
            }else{
                ints[i] = ints[i];
            }

        }

        System.out.println(Arrays.toString(ints));

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }

        int kesk = sum / ints.length;
        System.out.println(kesk);

        int allak = 0;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] < kesk){
                allak += 1;
            }
        }

        System.out.println(allak);

        return 0;
    }

}
