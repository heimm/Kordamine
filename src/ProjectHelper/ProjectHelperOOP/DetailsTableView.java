package ProjectHelperOOP;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * Abina on antud klassi kirjutamisel kasutatud: https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
 */
public class DetailsTableView {

    static final HBox hbox = new HBox();
    static VBox vbox = new VBox();
    static TableView<ProjectDetail> table = new TableView<>();
    static ObservableList<ProjectDetail> data = FXCollections.observableArrayList();
    static String n2;
    static HashMap <String, String> projektidetailitekst;

    public DetailsTableView(){
        setupScene();
        setupAction();
    }


    public static void displayDetails(){                                                                                //Kasutatakse leftTreeView ja seal nupuvajutusel. Idee poolest peab kuvama vastavalt leftreeview.n-ile uue portsu projekti detaile.
        System.out.println(LeftTreeView.n);/////////////////////////////////////////////////////////////////////////////
        if(LeftTreeView.n == null || LeftTreeView.n == "Minu projektid"){                                               //Kui projektide puu peal klikid "Minu projektid" või LeftTreeView.n == null, siis asetab projektidetailide andmetabelisse rea tühje väärtusi. Selleks, et tabel tühi tunduks.
            //data = FXCollections.observableArrayList(new ProjectDetail("","", "", "", "", ""));                       //ObservabeListi asetatakse uus ProjectDetail klassi instants.
            table.setItems(null);                                                                                       //Tabelisse kuvatakse tyhjus.
        }else {                                                                                                         //Kui aga klikitakse tegelikule projekti nimele, siis:
            Andmebaas a = new Andmebaas();
            data = a.getProjectDetails(LeftTreeView.n);                                                                 //Vastavalt klikitud projekti nimele "n" on nüüd listi "data" andmeteks andmebaasidesse tehtud päringu tulemus.
            a.sulgeYhendus();
            table.setItems(data);                                                                                       //Tabel "table" sunnitakse kuvama uusi andmeid vastavalt listile "data".
        }
    }

    public static void saveDetails(){                                                                                   //Kasutusel > TopPane.saveDetails(); Eesmärgiks on salvestada tabelisse lisatud uued kirjed andmebaasi.
        Andmebaas a = new Andmebaas();
        a.kustutaProjektiDetailidKoik(LeftTreeView.n);                                                                  //Kustutab andmebaasist esmalt kõik vanad projekti kohta käivad detailikirjed. Muidu tekiks uute lisamisel topeltkirjed.

        for (ProjectDetail p : data) {                                                                                  //Iga ProjektiDetail klassi instants "p" listis "data" teeb läbi tsükli:
            String number = p.number.get();                                                                             //Küsib vastavalt klassis defineeritud andmemudelile väärtusi.
            String date = p.date.get();
            String priority = p.priority.get();
            String explanation = p.explanation.get();
            String specific = p.specific.get();
            a.salvestaProjektiDetailid(LeftTreeView.n, number, date, priority, explanation, specific);                  //Meetod andmebaasis salvestamaks projektidetailid vastavasse tabelisse.
        }
        a.sulgeYhendus();
        displayDetails();
    }

    public static void saveDetails2(){                                                                                   //saveDetails-i kloon! Kasutusel vigade v2ltimiseks! Ainus erinevus on l6pus displayDetails(); puudumine! Eesmärgiks on salvestada tabelisse lisatud uued kirjed andmebaasi.
        Andmebaas a = new Andmebaas();
        a.kustutaProjektiDetailidKoik(LeftTreeView.n);                                                                  //Kustutab andmebaasist esmalt kõik vanad projekti kohta käivad detailikirjed. Muidu tekiks uute lisamisel topeltkirjed.

        for (ProjectDetail p : data) {                                                                                  //Iga ProjektiDetail klassi instants "p" listis "data" teeb läbi tsükli:
            String number = p.number.get();                                                                             //Küsib vastavalt klassis defineeritud andmemudelile väärtusi.
            String date = p.date.get();
            String priority = p.priority.get();
            String explanation = p.explanation.get();
            String specific = p.specific.get();
            a.salvestaProjektiDetailid(LeftTreeView.n, number, date, priority, explanation, specific);                  //Meetod andmebaasis salvestamaks projektidetailid vastavasse tabelisse.
        }
        a.sulgeYhendus();
    }

    private static void deleteDetail() {                                                                                //K2ivitub, kui vajutatakse projektidetaili kustutamise nuppu!
        saveDetails2();                                                                                                  //Salvestab ennem kustutamise algust projekti kohta k2ivad detailid ja seda selleks, et kui oled vahepeal projekti selgitust muutnud, et oleks v6imalik andmebaasist yles leida kattuv kirje. Et oleks, mida kustutada.
        ProjectDetail pd = table.getSelectionModel().getSelectedItem();                                                 //Leiab viimati klikitud aktiivse tabeli veeru.

        try {                                                                                                           //Proovib j2rgnevad sammud l2bi viia.
            n2 = pd.getId();                                                                                            //Kutsub andmemudelis ProjectDetails kirjeldatud getterile getId() vastavalt ID tulba aktiivse v22rtuse.
            System.out.println(pd.getId());////////////////////////////////////////////////////////////////////////////
        }catch(NullPointerException e){                                                                                 //Kui saab NullPointerException errori, siis:
            n2 = null;
        }

        if (n2 == null){                                                                                                //Ehk kui projektidetaili ei ole valitud, siis:
            AlertBox ab = new AlertBox("Ettevaatust!", "Detaili kustutamiseks vali detail!");
        }else{                                                                                                          //Kui projektidetail on valitud, siis l2heb kustutamiseks:
            ConfirmBox cb = new ConfirmBox();
            if (cb.confirmBox("Ettevaatust!", "Kas soovid valitud detaili kustutada?", 2)) {                            //Palub kustutamise kinnitust.
                Andmebaas a = new Andmebaas();
                a.kustutaProjektiDetail(LeftTreeView.n, n2);                                                            //Kustutab detaili vastavalt parameetritele.
                a.sulgeYhendus();
                displayDetails();                                                                                       //Kuvab uue tabeli.
                RightSplitPane.editorspecific.setHtmlText("");                                                          //Kui kustutad detaili, siis kuvab spetsiifilises htmleditoris tyhja.
            }else{
                System.out.println("M6tlesid ymber!");//////////////////////////////////////////////////////////////////
            }
        }
    }

    private void setupAction() {                                                                                        //Lisab tabelile eventhandleri. Callitakse konstruktoris.
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            handleMouseClicked(event);
        };
        table.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);                                              //Evendiks on hiireklikk.
    }

    private void handleMouseClicked(MouseEvent event) {                                                                 //Kui event tekib, siis callitakse sisemine funktsioon:
        projectDetailText();
    }

    private static void projectDetailText(){                                                                            //Kui tabatakse hiireklikk, siis tehakse järgmist:
        ProjectDetail pd = table.getSelectionModel().getSelectedItem();                                                 //Kirjtuab üles klikitud rea.
        try {                                                                                                           //Proovib j2rgnevad sammud l2bi viia.
            n2 = pd.getId();                                                                                            //Kutsub andmemudelis ProjectDetails kirjeldatud getterile getId() vastavalt ID tulba aktiivse v22rtuse.
            System.out.println(pd.getId());/////////////////////////////////////////////////////////////////////////////
        }catch(NullPointerException e){                                                                                 //Kui saab NullPointerException errori, siis:
            n2 = null;
        }
        Andmebaas a = new Andmebaas();
        projektidetailitekst = new HashMap<>();
        projektidetailitekst = a.getProjectDetailText(n2);                                                              //Otsib teisest SQL tabelist projekti detaili kohta käiva spetsiifilise teksti ja salvestab tühja hashmappi.
        RightSplitPane.editorspecific.setHtmlText(projektidetailitekst.get("detailspecific"));                          //Kirjutab spetsiifilisse htmleditori leitud detaili kohta käiva teksti.
        a.sulgeYhendus();
    }

    static void saveProjectDetailText(){                                                                                //Funktsioon, mis aitab salvestada projekti detaili spetsiifilist teksti.
        ProjectDetail pd = table.getSelectionModel().getSelectedItem();                                                 //salvestab klikitud rea.
        pd.specific.set(RightSplitPane.editorspecific.getHtmlText());                                                   //Kirjutab üle rea tulba väärtuse vastavalt sellele, mis "spetsiifilises" HTLMeditoris kirjas on.
        data.remove(table.getSelectionModel().getSelectedItem());                                                       //eemaldab vana klikitud rea vanade väärtustega.
        data.add(pd);                                                                                                   //Lisab uue rea uue "spetsiifilise" tulba väärtusega. Muud tulbad on reas samad, mis varem.
    }

    private static void setupScene() {                                                                                  //Meetod callitakse konstruktoris ning kuvab tabeli koos tulpade, sisendikohtade ja nuppudega. Määrab ka nuppude tegevuse.
        table.setEditable(true);

/*        TableColumn idColumn = new TableColumn("Id");
        idColumn.setMinWidth(75);
        idColumn.setCellValueFactory(
                new PropertyValueFactory<ProjectDetail, String>("id"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<ProjectDetail, String>>() {
                    @Override
                    public void handle(CellEditEvent<ProjectDetail, String> t) {
                        ((ProjectDetail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setNumber(t.getNewValue());
                    }
                }
        );*/

        TableColumn numberColumn = new TableColumn("Number");
        numberColumn.setMinWidth(75);
        numberColumn.setCellValueFactory(
                new PropertyValueFactory<ProjectDetail, String>("number"));
        numberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        numberColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<ProjectDetail, String>>() {
                    @Override
                    public void handle(CellEditEvent<ProjectDetail, String> t) {
                        ((ProjectDetail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setNumber(t.getNewValue());
                    }
                }
        );

        TableColumn dateColumn = new TableColumn("Kuupaev");
        dateColumn.setMinWidth(75);
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<ProjectDetail, String>("date"));
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<ProjectDetail, String>>() {
                    @Override
                    public void handle(CellEditEvent<ProjectDetail, String> t) {
                        ((ProjectDetail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDate(t.getNewValue());
                    }
                }
        );

        TableColumn priorityColumn = new TableColumn("Prioriteet");
        priorityColumn.setMinWidth(75);
        priorityColumn.setCellValueFactory(
                new PropertyValueFactory<ProjectDetail, String>("priority"));
        priorityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priorityColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<ProjectDetail, String>>() {
                    @Override
                    public void handle(CellEditEvent<ProjectDetail, String> t) {
                        ((ProjectDetail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPriority(t.getNewValue());
                    }
                }
        );

        TableColumn explanationColumn = new TableColumn("Selgitus");
        explanationColumn.setMinWidth(200);
        explanationColumn.setCellValueFactory(
                new PropertyValueFactory<ProjectDetail, String>("explanation"));
        explanationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        explanationColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<ProjectDetail, String>>() {
                    @Override
                    public void handle(CellEditEvent<ProjectDetail, String> t) {
                        ((ProjectDetail) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setExplanation(t.getNewValue());
                    }
                }
        );

        table.setItems(data);
        table.getColumns().addAll(numberColumn, dateColumn, priorityColumn, explanationColumn);

        final TextField addNumber = new TextField();
        addNumber.setPromptText("Number");
        addNumber.setMaxWidth(numberColumn.getPrefWidth());
        final TextField addDate = new TextField();
        addDate.setMaxWidth(dateColumn.getPrefWidth());
        addDate.setPromptText("Kuupaev");
        final TextField addPriority = new TextField();
        addPriority.setMaxWidth(priorityColumn.getPrefWidth());
        addPriority.setPromptText("Prioriteet");
        final TextField addExplanation = new TextField();
        addExplanation.setMaxWidth(explanationColumn.getPrefWidth());
        addExplanation.setPromptText("Selgitus");

        final Button deleteButton = new Button("Kustuta");
        deleteButton.setOnAction(e -> {
            deleteDetail();
        });

        final Button addButton = new Button("Lisa");
        addButton.setOnAction(e -> {
            data.add(new ProjectDetail(
                    "",                                                                                                 //Lisab ID tulpa tyhjuse sest seda v22rtust tulpa me ise ei kirjuta! Seda teeb auto increment andmebaasis!
                    addNumber.getText(),
                    addDate.getText(),
                    addPriority.getText(),
                    addExplanation.getText(),
                    "<html dir=\"ltr\"><head></head><body contenteditable=\"true\"></body></html>"));                   //HTMLeditori "tyhi tekst".
            addNumber.clear();
            addDate.clear();
            addPriority.clear();
            addExplanation.clear();
            RightSplitPane.editorspecific.setHtmlText("");

            saveDetails();                                                                                              //Salvestab lisatud detaili andmebaasi.
        });

        hbox.getChildren().addAll(addNumber, addDate, addPriority, addExplanation, addButton, deleteButton);
        hbox.setSpacing(3);

        vbox.setSpacing(5);
        vbox.getChildren().addAll(table, hbox);
    }

    public static class ProjectDetail {

        private final SimpleStringProperty id;
        private final SimpleStringProperty number;
        private final SimpleStringProperty date;
        private final SimpleStringProperty priority;
        private final SimpleStringProperty explanation;
        private final SimpleStringProperty specific;

        public ProjectDetail(String id1, String number1, String date1, String priority1, String explanation1, String specific1) {

            this.id = new SimpleStringProperty(id1);
            this.number = new SimpleStringProperty(number1);
            this.date = new SimpleStringProperty(date1);
            this.priority = new SimpleStringProperty(priority1);
            this.explanation = new SimpleStringProperty(explanation1);
            this.specific = new SimpleStringProperty(specific1);
        }

        public String getId() {

            return id.get();
        }

        public void setId(String number1) {

            id.set(number1);
        }

        public String getNumber() {

            return number.get();
        }

        public void setNumber(String number1) {

            number.set(number1);
        }

        public String getDate() {

            return date.get();
        }

        public void setDate(String number1) {

            date.set(number1);
        }

        public String getPriority() {

            return priority.get();
        }

        public void setPriority(String number1) {

            priority.set(number1);
        }

        public String getExplanation() {

            return explanation.get();
        }

        public void setExplanation(String number1) {

            explanation.set(number1);
        }

        public String getSpecific() {

            return specific.get();
        }

        public void setSpecific(String x) {

            specific.set(x);
        }
    }
}

