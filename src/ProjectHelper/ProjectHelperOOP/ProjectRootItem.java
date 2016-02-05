package ProjectHelperOOP;

import javafx.scene.control.TreeItem;

/**
 * Created by Martin on 30.11.2015.
 */
public class ProjectRootItem {

    String projektinimetus;
    TreeItem<String> treeitem;

    public ProjectRootItem(String x){
        projektinimetus = x;
        setupTreeItem();
    }

    private void setupTreeItem() {
        treeitem = new TreeItem<>(projektinimetus);
    }
}
