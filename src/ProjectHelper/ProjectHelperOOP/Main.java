package ProjectHelperOOP;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Martin on 23.11.2015.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        new MainWindow();
    }
}

/**
 * Class: MainWindow
 *      Kuvab esimese akna.
 *
 * Class: ProjectDetails
 *      Kuvab projekti detailide akna.
 *
 * Class: NewProject
 *      Loob uue projekti akna.
 *
 * Class: TopPane
 *      Loob uue HBoxi.
 *      Lisab HBoxile nupud.
 *      Lisab HBoxi MainWindowisse.
 *
 * Class: LeftPane
 *      Loob uue menuu.
 *      V6tab menuusse v22rtused andmebaasist.
 */