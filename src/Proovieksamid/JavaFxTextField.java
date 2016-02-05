import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Loo Label, mille sisu saab kasutaja TextFieldi kaudu muuta.
 */
public class JavaFxTextField extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox stack = new VBox();
        Scene scene = new Scene(stack, 300, 300);
        primaryStage.setScene(scene);

        TextField textfield = new TextField();

        Button button = new Button("MUUDA");

        Label label = new Label();

        button.setOnAction(event -> {
            label.setText(textfield.getText());
        });

        stack.getChildren().addAll(textfield, button, label);

        primaryStage.show();
    }
}

