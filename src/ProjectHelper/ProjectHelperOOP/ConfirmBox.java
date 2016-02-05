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
public class ConfirmBox {

    static boolean returnanswer;
    static Label nameLabel;
    static Button buttonSaveExit;

    public static boolean confirmBox(String y, String x, int z) {
        Stage window = new Stage();
        window.getIcons().add(new Image("ProjectHelperIcon.png"));

        Button buttonYes;
        Button buttonNo;

        VBox vbox = new VBox();
        Scene stseen = new Scene(vbox);
        window.initModality(Modality.APPLICATION_MODAL);

        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(8);

        if (z == 1) {
            //Label1: nimetus.
            nameLabel = new Label(x + LeftTreeView.n + "?");
        }

        if (z == 2) {
            nameLabel = new Label(x);

        }

        //Button: confirm Ei.
        buttonNo = new Button("Ei");
        buttonNo.setPrefSize(50, 25);

        //Button: confirm Jah.
        buttonYes = new Button("Jah");
        buttonYes.setPrefSize(50, 25);

        buttonNo.setOnAction(e -> {
            returnanswer = false;
            window.close();
        });

        buttonYes.setOnAction(e ->{
            returnanswer = true;
            window.close();
        });

        vbox.getChildren().addAll(nameLabel, buttonNo, buttonYes);

/*        if (z == 2){
            buttonSaveExit = new Button("Salvesta ja sulge");
            vbox.getChildren().addAll(buttonSaveExit);
            buttonSaveExit.setOnAction(e -> {
                TopPane.setupSave();
                returnanswer = true;
                window.close();
            });

        }*/

        window.setScene(stseen);
        window.setResizable(false);
        window.setTitle(y);
        window.showAndWait();                                                                                           // vajalik siis, kui window midagi returnib, ootab ära kasutaja inputi ennem, kui vastuse returnib!

        return returnanswer;

    }

}
