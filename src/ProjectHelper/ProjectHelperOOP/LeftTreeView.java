package ProjectHelperOOP;

import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Martin on 27.11.2015.
 */
public class LeftTreeView {

    static String n;
    static TreeView<String> treeview;
    StackPane stackpane;
    private static ArrayList<String> projektinimed;
    static HashMap <String, String> projektidetailid;
    static TreeItem<String> rootItem = new TreeItem<>("Minu projektid");

    public LeftTreeView(){
        setupScene();
        setupAction();
    }

    public void setupScene() {
        stackpane = new StackPane();
        rootItem = new TreeItem<>("Minu projektid");
        rootItem.setExpanded(true);
        treeview = new TreeView<>(rootItem);
        stackpane.getChildren().addAll(treeview);

        Andmebaas a = new Andmebaas();
        projektinimed = a.getProjectNames();                                                                            //Hangib andmebaasi SQL tabelist projektide nimetused.
        for (String x : projektinimed){                                                                                 //Loopib läbi vastava arraylisti.
            ProjectRootItem pri = new ProjectRootItem(x);                                                               //Iga nimetuse kotha luuakse uus projektide puu rootitem.
            rootItem.getChildren().addAll(pri.treeitem);                                                                //Kinnitab rootitemi puu külge.
        }
        a.sulgeYhendus();
    }

    public static void renewTreeItems(){                                                                                //Kasutatakse > TopPane.setupDelete(); ja NewProject.setupSave(); Eesmärgiks on peale projektide lisamist või kustutamist projektide puu uuendamine.
        rootItem.getChildren().setAll();                                                                                //Asetab rootItem-isse projektinimetuste asemel tühjuse, ehk kustutab nimed treeviews ära. removeAll variant siin ei toiminud.
        Andmebaas a = new Andmebaas();
        projektinimed = a.getProjectNames();                                                                            //Tõmbab Andmebaasi instantsist endale projektinimede Array.
        for (String x : projektinimed){                                                                                 //Käib läbi kõik "projektinimed" Array elemendid.
            ProjectRootItem pri = new ProjectRootItem(x);                                                               //Iga "projektinimed" elemendiga "x" kutsutakse loodud klass "ProjectRootItem".
            rootItem.getChildren().add(pri.treeitem);                                                                   //Loodud klassi "ProjectRootItem" instantsist tõmmatakse väärtus "treeitem". See lisatakse "rootItem"-i sisse, kuhu eelnevalt oli asetatud tühjus.
        }
        a.sulgeYhendus();
    }

    private void setupAction() {                                                                                        //Lisab projektide puule klikkimise eventhandleri.
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            handleMouseClicked(event);
        };
        treeview.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);                                           //Evendiks on mouseklick.
    }

    private void handleMouseClicked(MouseEvent event) {                                                                 //Abiks on TreeView item "setonaction" puhul:  http://stackoverflow.com/questions/15792090/javafx-treeview-item-action-event
        //Muudatute kontroll algab!
        if (n != null && !(n.equals("Minu projektid"))){                                                                //Kui klikitud projekti väärtus ei ole "null" ega "Minu projektid", siis:
            Andmebaas c = new Andmebaas();
            HashMap<String, String> hm;                                                                                 //Luuakse uus tühi HashMap.
            hm = c.getProjectText(n);                                                                                   //Tühja HashMap-i tõmmatakse andmebaasi instantsist projekti nimega "n" "Üldise HTMLEditor-i" tekst.
            c.sulgeYhendus();
            System.out.println("~~~~~~~~~~~~~~" + n);///////////////////////////////////////////////////////////////////
            System.out.println("~~~~~~~~~~~~~~" + hm.get("projecttext"));///////////////////////////////////////////////
            System.out.println("~~~~~~~~~~~~~~" + RightSplitPane.editor.getHtmlText());/////////////////////////////////
            if (hm.get("projecttext") != null){                                                                         //Kui andmebaasist väljatõmmatud tekst eksisteerib, siis samm edasi:
                if(!(hm.get("projecttext")).equals(RightSplitPane.editor.getHtmlText())){                               //Kui projekti "n" andmebaasis leiduv tekst EI ÜHILDU hetkel HTMLEditor-is kirjapanduga, siis:
                    ConfirmBox cb = new ConfirmBox();                                                                   //siis: Kutsume esile kinnituste popupi "kas soovid salvestada?".
                    if (cb.confirmBox("Ettevaatust!", "Salvesta muudatused projektis: ", 1)) {
                        TopPane.setupSave();                                                                            //Kui on soov muudatused salvestada, siis kutsume meetodi TopPane.setupSave();
                    }
                }
            }
        }
        //Muudatuste kontroll l6ppeb!

        event.getPickResult().getIntersectedNode();                                                                     //Mis väärtusele puul klikiti?
        handleMouseClicked2();
    }

    public static void handleMouseClicked2(){                                                                           //Nupuvajutusele reageerimine l66dud kaheks, sest nii on lihtsam mujalt callida nupuvajutuse meetodit. N2iteks TopPane.setupDelete(); alt.
        n = (String) ((TreeItem)treeview.getSelectionModel().getSelectedItem()).getValue();                             //Klikitud projekti nimetus salvestatakse muutujasse.
        DetailsTableView.n2 = null;                                                                                     //Kui projekti puu peale klikkides projekti nime vahetada, siis kaotab projektidetaili v22rtuse, v2ltimaks valesid kustutamisi.
        if (n == "Minu projektid"){                                                                                     //Kui klikitakse projektide puu rooti, siis peavad tabelid tühjaks saama.
            System.out.println("Klikid projektide puu rooti, see ei tee midagi!");//////////////////////////////////////
            DetailsTableView.displayDetails();                                                                          //Kutsub meetodi DetailsTableView.displayDetails(); Eesmargiks projektide puu juurele klikkides tabelite puhastamine.
            RightSplitPane.editor.setHtmlText("");
            RightSplitPane.editorspecific.setHtmlText("");
        }else{
            System.out.println("Avan projekti: " + n);//////////////////////////////////////////////////////////////////
            Andmebaas a = new Andmebaas();
            projektidetailid = new HashMap<>();
            projektidetailid = a.getProjectText(n);                                                                     //Võtab SQL tabelist projekti üldise teksti HTMLeditorisse.
            DetailsTableView.displayDetails();                                                                          //Kutsub meetodi DetailsTableView.displayDetails();, mis tõmbab andmebaasi tabelist "PROJECTDETAILS" projekti "n" projektidetailide andmed ja söödab need DetailsTableView andmemudelisse.
            RightSplitPane.editorspecific.setHtmlText("");                                                              //Selleks, et kui klikid teisele projektile, et siis detailispetsiifilise info htmleditor kuvaks tyhja.

            if ((projektidetailid.get("projecttext")== null)) {                                                         //Kui projekti üldist htmleditori teksti ei ole.
                RightSplitPane.editor.setHtmlText("");
            }else{
                RightSplitPane.editor.setHtmlText(projektidetailid.get("projecttext"));                                 //Kui on tekst, siis:
            }
            a.sulgeYhendus();
        }
    }
}
