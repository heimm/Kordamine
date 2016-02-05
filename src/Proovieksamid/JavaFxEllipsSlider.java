import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Joonista Ellipse, mille ringjoone paksust saab kasutaja slideriga muuta.
 */
public class JavaFxEllipsSlider extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox stack = new HBox();
        Scene scene = new Scene(stack, 400, 400);
        primaryStage.setScene(scene);

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(60);
        slider.setValue(30);
        Ellipse ring = new Ellipse(60, 30);
        ring.setStrokeWidth(15);
        ring.setStroke(Color.BLACK);
        ring.setFill(Color.RED);


        slider.valueProperty().addListener((observable, vanaVaartus, uusVaartus) -> {
            System.out.println("Uus v‰‰rtus on: " + uusVaartus.intValue());
            ring.setStrokeWidth(uusVaartus.intValue());
        });


        stack.getChildren().addAll(slider, ring);

        primaryStage.show();
    }
}

