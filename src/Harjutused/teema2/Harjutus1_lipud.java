package teema2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 1. Joonista eesti lipp kasutades kolme Rectangle
 * 2. Joonista Jaapani lipp kasutades Rectangle ja Circle
 */
public class Harjutus1_lipud extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        eestiLipp();
        jaapaniLipp();

    }

    private void jaapaniLipp() {
        Stage lava = new Stage();
        Pane pane = new Pane();
        Scene stseen = new Scene(pane, 500, 500);
        lava.setScene(stseen);

        Rectangle kast = new Rectangle(0, 0, 500, 500);
        pane.getChildren().add(kast);
        kast.setFill(Color.WHITE);

        Circle kast2 = new Circle(250, 250, 100);
        pane.getChildren().add(kast2);
        kast2.setFill(Color.RED);



        lava.show();
    }

    private void eestiLipp() {
        Stage lava2 = new Stage();
        Pane pane = new Pane();
        Scene stseen = new Scene(pane, 500, 500);
        lava2.setScene(stseen);

        Rectangle kast = new Rectangle(100, 100, 300, 100);
        pane.getChildren().add(kast);
        kast.setFill(Color.BLUE);

        Rectangle kast2 = new Rectangle(100, 200, 300, 100);
        pane.getChildren().add(kast2);
        kast2.setFill(Color.BLACK);

        Rectangle kast3 = new Rectangle(100, 300, 300, 100);
        pane.getChildren().add(kast3);
        kast3.setFill(Color.GREY);


        lava2.show();
    }
}
