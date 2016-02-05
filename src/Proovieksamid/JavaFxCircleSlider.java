import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Joonista ring, mille suurust saab kasutaja Slideriga muuta
 */
public class JavaFxCircleSlider extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane stack = new GridPane();
        Scene scene = new Scene(stack, 300, 300);
        primaryStage.setScene(scene);

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.setShowTickLabels(true);

        Circle ring = new Circle(30);

        slider.valueProperty().addListener((observable, vanaVaartus, uusVaartus) -> {
            ring.setRadius(slider.getValue());
            System.out.println("Uus v‰‰rtus on: " + uusVaartus.intValue());
        });

        stack.add(ring, 4, 3);
        stack.add(slider, 1, 1);
        //stack.getChildren().addAll(slider, ring);

        primaryStage.show();
    }

}
