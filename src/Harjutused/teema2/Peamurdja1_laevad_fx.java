package teema2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Joonista laevade pommitamine kasutades JavaFXi.
 */
public class Peamurdja1_laevad_fx extends Application {
    Stage lava;
    GridPane laud;
    int lauaPikkusLaevades = 4;
    int laevaServPikslites = 50;


    @Override
    public void start(Stage primaryStage) throws Exception {
        lava = primaryStage;
        seadistaLava();
        paigutaLaevad();
        reageeriKlikile();
        // kasOnLaevu();
        // gameOver();

    }

    private void reageeriKlikile() {
        laud.setOnMouseClicked(event -> {
            Rectangle ruut = (Rectangle) event.getTarget();
            String ruuduId = ruut.getId();
            if (ruuduId.equals("laev")) {
                System.out.println("PIHTAS");
                ruut.setFill(Color.RED);
                ruut.setId("pihtas");
            }else if (ruuduId.equals("meri")){
                System.out.println("MÖÖDA");
                ruut.setFill(Color.BLACK);
            }else if (ruuduId.equals("pihtas")){
                System.out.println("laip!");
            }

            if (!laevuOnAlles()){
                System.out.println("GAME OVER.");

            }
        });
    }

    private boolean laevuOnAlles() {
        for (Node ruut : laud.getChildren()) {
            if (ruut.getId().equals("laev")) {
                return true;
            }
        }
        return false;
    }

    private void paigutaLaevad() {
        for (int i = 0; i < lauaPikkusLaevades; i++) {
            for (int j = 0; j <lauaPikkusLaevades; j++) {
                Rectangle ruut = new Rectangle(laevaServPikslites, laevaServPikslites);
                int random = (int) (Math.random() * 2);
                if (random == 1){
                    ruut.setId("laev");
                }else if (random == 0){
                    ruut.setId("meri");
                }
                ruut.setStroke(Color.BLACK);
                ruut.setFill(Color.BLUE);
                laud.add(ruut, i, j);

            }

        }
    }

    private void seadistaLava() {

        laud = new GridPane();
        Scene manguStseen = new Scene(laud, laevaServPikslites*lauaPikkusLaevades +lauaPikkusLaevades, laevaServPikslites*lauaPikkusLaevades +lauaPikkusLaevades);
        lava.setScene(manguStseen);
        lava.show();
        lava.setOnCloseRequest(event -> System.exit(0));
    }
}
