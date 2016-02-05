package ProjectHelperOOP;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Martin on 23.11.2015.
 */
public class MainWindow{

    private static Stage lava = new Stage();
    private static BorderPane border;
    private static Scene stseen;

    public MainWindow() {

        setupScene();
        setupClose();
    }

    public static void setupScene() {

        border = new BorderPane();
        stseen = new Scene(border, 800, 600);

        lava.getIcons().add(new Image("ProjectHelperIcon.png"));

        TopPane tp = new TopPane();
        border.setTop(tp.anchorpane);
        //LeftPane lp = new LeftPane();
        //border.setLeft(lp.vbox);// VT ka viidet leftPane uleval! Nii saab viidata teise classi tipus defineeritud muutujale!!!!!
        CenterPane cp = new CenterPane();
        border.setCenter(cp.splitpane);

        //border.setLeft(LeftPane.getLeftPane()); Vana, aga toimis!

        lava.setScene(stseen);
        lava.setResizable(false);
        lava.setTitle("Project Helper version 1.0");
        lava.show();
    }

    private void setupClose() {
        lava.setOnCloseRequest(e ->{
            e.consume();
            ConfirmBox cb = new ConfirmBox();
            if (cb.confirmBox("Ettevaatust!", "Kas soovid programmi sulgeda?", 2)){
                lava.close();
            }else{
                System.out.println("Motlesid umber ja ei sulge akent!");
            }
        });
    }

}
