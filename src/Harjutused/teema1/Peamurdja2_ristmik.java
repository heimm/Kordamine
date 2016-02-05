package teema1;

import javafx.application.Application;
import javafx.stage.Stage;
import lib.Foor;

/**
 * Täpselt nagu oli fooriga, on nüüd ristmikuga. Kuidas esiteks
 * ristmik üles ehitada loe Foori README.md-st: https://github.com/KristerV/javaHarjutused
 */
public class Peamurdja2_ristmik extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Foor foor1 = new Foor(Foor.YLEMINE, primaryStage);
        Foor foor2 = new Foor(Foor.ALUMINE, primaryStage);
        Foor foor3 = new Foor(Foor.PAREM, primaryStage);
        Foor foor4 = new Foor(Foor.VASAK, primaryStage);

        vilgutaFoorid1(foor1);
        vilgutaFoorid1(foor2);
        vilgutaFoorid2(foor3);
        vilgutaFoorid2(foor4);

    }

    public void vilgutaFoorid1(Foor foor) {


        int count = 0;
        while (count < 10) {


            foor.vahetaPunast();
            foor.paus(14);
            foor.vahetaKollast();
            foor.paus(2);
            foor.vahetaPunast();
            foor.vahetaKollast();
            foor.vahetaRohelist();
            foor.paus(3);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.vahetaKollast();
            foor.paus(1);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.1);


            count = count + 1;
        }
    }

    public void vilgutaFoorid2(Foor foor){

        int count = 0;
        while (count < 10) {

            foor.vahetaPunast();
            foor.vahetaKollast();
            foor.paus(2);
            foor.vahetaPunast();
            foor.vahetaKollast();
            foor.vahetaRohelist();
            foor.paus(3);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.paus(0.5);
            foor.vahetaRohelist();
            foor.vahetaKollast();
            foor.paus(1);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.paus(0.5);
            foor.vahetaKollast();
            foor.syytaPunane();
            foor.paus(14);
            foor.kustutaPunane();
            foor.paus(0.1);

            count = count + 1;
        }

    }

}
