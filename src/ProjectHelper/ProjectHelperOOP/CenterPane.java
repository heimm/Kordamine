package ProjectHelperOOP;

import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Martin on 27.11.2015.
 */
public class CenterPane {
    SplitPane splitpane;

    public CenterPane(){

        setupScene();
    }

    private void setupScene() {

        LeftTreeView lps = new LeftTreeView();
        RightSplitPane rps = new RightSplitPane();

        splitpane = new SplitPane();
        splitpane.setOrientation(Orientation.HORIZONTAL);
        //StackPane child1 = new StackPane();
        //child1.setStyle("-fx-background-color: #5a8bdd;");
        //StackPane child2 = new StackPane();
        //child2.setStyle("-fx-background-color: #51b4ff;");
        splitpane.getItems().addAll(lps.stackpane, rps.splitpane);
        splitpane.setDividerPositions(0.15f);
    }
}
