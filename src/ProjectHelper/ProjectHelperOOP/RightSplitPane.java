package ProjectHelperOOP;

import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;

/**
 * Created by Martin on 3.12.2015.
 */
public class RightSplitPane {
    static SplitPane splitpane;
    static HTMLEditor editor;
    static HTMLEditor editorspecific;

    public RightSplitPane(){
        setupScene();
    }

    private void setupScene() {
        splitpane = new SplitPane();
        splitpane.setOrientation(Orientation.VERTICAL);

        // Ulemine osa, algus.
        DetailsTableView dtv = new DetailsTableView();
        //Ulemine osa, lopp.

        //Alumine osa, algus.
        editor = new HTMLEditor();
        editorspecific = new HTMLEditor();

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        tab1.setText("Uldine");
        tab2.setText("Spetsiifiline");
        tab1.setContent(editor);
        tab2.setContent(editorspecific);
        tabPane.getTabs().addAll(tab1, tab2);
        //Alumine osa, lopp.

        splitpane.getItems().addAll(dtv.vbox, tabPane);
        splitpane.setDividerPositions(0.5f);
    }
}
