import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Joonista ring, mille värvi saab kasutaja muuta
 */
public class JavaFxColorChange extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane stack = new GridPane();
        Scene scene = new Scene(stack, 300, 300);
        primaryStage.setScene(scene);

        Circle cr = new Circle(30, Color.RED);

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);

        cr.setFill(colorPicker.getValue());

        colorPicker.setOnAction((ActionEvent t) -> {
            cr.setFill(colorPicker.getValue());
        });


        stack.add(colorPicker, 1, 1);
        stack.add(cr, 4, 3);
        primaryStage.show();
    }
}
