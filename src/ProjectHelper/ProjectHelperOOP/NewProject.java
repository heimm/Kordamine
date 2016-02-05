package ProjectHelperOOP;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Created by Martin on 23.11.2015.
 */
public class NewProject {

    Stage window = new Stage();
    TextField nameinput;
    Button saveinput;

    public NewProject() {
        setupScene();
        setupSave();
    }


    private void setupScene() {
        GridPane gridpane = new GridPane();
        Scene stseen = new Scene(gridpane);
        window.initModality(Modality.APPLICATION_MODAL);                                                                //Blokeerib user inputi teistesse akendesse.
        window.getIcons().add(new Image("ProjectHelperIcon.png"));

        //GridPane: settings.
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setVgap(8);
        gridpane.setHgap(10);

        //Label1: nimetus.
        Label nameLabel = new Label("Projekti nimetus:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //TextField1: sisesta projekti nimi.
        nameinput = new TextField();
        GridPane.setConstraints(nameinput, 1, 0);

        //Button: salvesta.
        saveinput = new Button("Salvesta");
        GridPane.setConstraints(saveinput, 1, 1);

        gridpane.getChildren().addAll(nameLabel, nameinput, saveinput);
        window.setScene(stseen);
        window.setResizable(false);
        window.setTitle("Loo uus projekt");
        window.show();
    }

    private void setupSave() {                                                                                           //Kirjeldab, mis hakkab toimuma vajutades nuppu "Salvesta".
        saveinput.setOnAction(e -> {
            if (nameinput.getText().isEmpty()){                                                                          //Kui uue projekti aknasse nime ei ole kirjutatud, siis toob esile veateate.
                window.close();                                                                                          //Sulgeb "Loo uus projekt" akna.
                AlertBox ab = new AlertBox("Ettevaatust!", "Pead projekti nime sisestama!");
            }else{
                System.out.println(nameinput.getText() + " salvestatud!");/////////////////////////////////////////////
                window.close();                                                                                          //Sulge "Loo uus projekt" akna.
                String n = nameinput.getText();                                                                          //Loeb projekti nime sisestusest v‰‰rtuse ja salvestab muutujasse "n".
                Andmebaas a = new Andmebaas();
                a.salvestaProjekt(n);                                                                                    //Laseb andmebaasi instantsi kaudu uue projekti nime salvestada.
                a.saveProjectText("<html dir=\"ltr\"><head></head><body contenteditable=\"true\"></body></html>", n);    //Selleks, et juba projekti nime luues anda html editori slotti SQL andmebaasis ıige v‰‰rtus, v‰ltimaks lefttreeview klassis muudatuste kontrolli feili!
                LeftTreeView.renewTreeItems();                                                                           //Laseb funktsioonil uuendada projektide puu elemente.
                a.sulgeYhendus();
                LeftTreeView.n = null;                                                                                   //Vajalik selleks, et toimiks leftTreeView.handleMouseClicked() muudatuste kontrolli osa!

                DetailsTableView.displayDetails();                                                                       //Kutsub meetodi DetailsTableView.displayDetails(); Eesmargiks uue projekti loomisel tabelite puhastamine.
                RightSplitPane.editor.setHtmlText("");                                                                   //Tyhjendab projekti loomisel editori.
                RightSplitPane.editorspecific.setHtmlText("");                                                           //Tyhjendab projekti loomisel editori.
        }});
    }
}
