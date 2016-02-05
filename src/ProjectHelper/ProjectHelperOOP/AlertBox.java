package ProjectHelperOOP;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Martin on 2.12.2015.
 */
public class AlertBox {

    String title;
    String message;

    public AlertBox(String s, String s1) {
        title = s;
        message = s1;
        setupScene();
    }

    private void setupScene() {
        Stage window = new Stage();
        window.getIcons().add(new Image("ProjectHelperIcon.png"));

        VBox vbox = new VBox();
        Scene stseen = new Scene(vbox, 200, 75);
        window.initModality(Modality.APPLICATION_MODAL);

        Button button = new Button("Jah");
        button.setOnAction(e-> {
            window.close();
        });

        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(8);

        Label nameLabel = new Label(message);

        vbox.getChildren().addAll(nameLabel, button);
        window.setScene(stseen);
        window.setResizable(false);
        window.setTitle(title);
        window.showAndWait();
    }
}
