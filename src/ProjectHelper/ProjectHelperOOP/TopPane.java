package ProjectHelperOOP;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


/**
 * Created by Martin on 23.11.2015.
 */
public class TopPane {

    Button buttonNew;
    Button buttonDelete;
    static Button buttonSave;
    static AnchorPane anchorpane;
    static String justDeleted;

    public TopPane(){
        setupScene();
        setupNew();
        setupDelete();
        setupSaveButton();
    }

    private void setupScene() {
        anchorpane = new AnchorPane();
        anchorpane.setPrefHeight(90);
        HBox hbox = new HBox(10);

        Image image = new Image("ProjectHelperLogo.png");
        ImageView image1 = new ImageView();
        image1.setImage(image);
        image1.setFitHeight(46);
        image1.setFitWidth(200);
        image1.setX(14);
        image1.setY(14);

        anchorpane.setStyle("-fx-background-color: #ffffff;");

        //Button: uusProjekt.
        buttonNew = new Button("Uus");
        buttonNew.setPrefHeight(25);

        //Button: salvestaProjekt
        buttonSave = new Button("Salvesta");
        buttonSave.setPrefHeight(25);

        //Button: kustutaProjekt.
        buttonDelete = new Button("Kustuta");
        buttonDelete.setPrefHeight(25);

        anchorpane.getChildren().addAll(image1, hbox);
        hbox.getChildren().addAll(buttonNew, buttonSave, buttonDelete);
        hbox.setLayoutX(611);
        hbox.setLayoutY(25);
    }

    private void setupNew() {                                                                                           //Uue projekti nupp.
        buttonNew.setOnAction(e -> {
            NewProject a = new NewProject();
            System.out.println("Loon uut projekti!");///////////////////////////////////////////////////////////////////
        });
    }

    private void setupDelete() {                                                                                        //Kustutab projekti nimega "n". Ehk valitud projekti. Seej‰rel on vaja kuvada uus projektipuu.
        buttonDelete.setOnAction(e -> {
            if (LeftTreeView.n == null || LeftTreeView.n == "Minu projektid" || LeftTreeView.n == justDeleted) {        //Kui projekti nimi "n" = null, "Minu projektid" vıi vimmati kustutatud projekti nimi, siis kuvatakse veateade.
                AlertBox ab = new AlertBox("Viga!", "Projekti kustutamiseks vali projekt!");
            }else{
                boolean resultanswer = ConfirmBox.confirmBox("Ettevaatust!", "Kustuta projekt: ", 1);                   //Kui l‰heb l‰bi, siis kuvatakse kontrollteade, et saada kinnitust, kas ikka tıesti on vaja kustutada.
                System.out.println(resultanswer);///////////////////////////////////////////////////////////////////////
                if (resultanswer == true) {
                    System.out.println("Kustutan projekti!");///////////////////////////////////////////////////////////
                    Andmebaas a = new Andmebaas();
                    a.kustutaProjekt(LeftTreeView.n);                                                                   //Kustutab projektide tabelist projekti nimetuse. Tegeleb tabeliga "PROJECTS".
                    a.kustutaProjektiDetailidKoik(LeftTreeView.n);                                                      //Kustutab projektidetailide "PROJECTDETAILS" tabelist projektinimega "n" seonduvad detailid.
                    justDeleted = LeftTreeView.n;                                                                       //Ei lase uritada sama projekti rohkem kui korra kustutada.
                    LeftTreeView.renewTreeItems();                                                                      //Laseb funktsioonil uuendada projektide puu elemente.
                    a.sulgeYhendus();
                    LeftTreeView.n = null;                                                                              //Vajalik selleks, et toimiks leftTreeView.handleMouseClicked()  muudatuste kontrolli osa!
                    DetailsTableView.displayDetails();                                                                  //Kuvab projekti kustutamise j2rgselt tyhjuse.
                    LeftTreeView.handleMouseClicked2();                                                                 //Treeview selection hyppab kustutamise peale projektide puu tyvele, seega tuleb uuendada projekti kohta k2ivad andmed tyhjaks.
                }else{
                    System.out.println("M6tlesid umber ja ei kustuta projekti!");///////////////////////////////////////
                }
            }
        });
    }

    public static void setupSaveButton() {
        buttonSave.setOnAction(e -> {
            setupSave();
        });
    }


    public static void setupSave() {                                                                                    //Meetod, mis salvestab peaaknas sisestatud "‹ldise" HTMLEtior-i teksti ja projektidetailide andmed,
        System.out.println("Sisendid salvestatud!");////////////////////////////////////////////////////////////////////
        DetailsTableView.n2 = null;
        if (!DetailsTableView.table.getItems().isEmpty() && !DetailsTableView.table.getSelectionModel().getSelectedItems().isEmpty()) { //Kui detailide tabel on tyhi, siis j2rgnevaid funktsioone ei callita, muidu tekivad errorid. Sama ka siis kui detaili ei ole valitud.
            DetailsTableView.saveProjectDetailText();                                                                   //Salvestab projekti detaili kohta k‰iva teksti spetsiifilisest HTMLeditorist.
            DetailsTableView.saveDetails();                                                                             //Kutsub meetodi DetailsTableView.saveDetails();, mis kustutab projekti "n" kohta k‰ivad detailid tabelist "PROJECTDETAILS". Salvestab projekti detailid andmebaasi uuesti. Kustutada on vaja sıltuvalt DetailsTableView.java klassi olemusele, vastasel juhul esineksid topelt v‰‰rtused.
        }
        String htmltxt = RightSplitPane.editor.getHtmlText();                                                           //Vıtab HTMLEditor-i hetkel sisestatud teksti ja salvestab muutujasse "htmltxt".
        Andmebaas a = new Andmebaas();
        a.saveProjectText(htmltxt, LeftTreeView.n);                                                                     //Salvestab HTMLEditorist leitud teksti projektinime "n" all tabelisse "PROJECTS".
        a.sulgeYhendus();
    }
}
