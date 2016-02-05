package ProjectHelperOOP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Martin on 26.11.2015.
 *
 * Viide > Antud andmebaasi kood on loodud suuremal m22ral KristerV javaHarjutused - SQL_Login - Andmebaas p6hjal!!
 * Kohandatud on seda vastavalt k2esoleva projekti vajadustele.
 *
 */
public class Andmebaas {
    Connection conn = null;

    public Andmebaas() {
        looYhendus();
        looTabel();
        looTabelDetailid();
    }

    private void looYhendus() {
        try {
            Class.forName("org.sqlite.JDBC");                                                                           //Lae draiver sqlite.jar failist
            conn = DriverManager.getConnection("jdbc:sqlite:projektid.db");                                             //loo ühendus andmebaasi failiga
        } catch ( Exception e ) {                                                                                       //püüa kinni võimalikud errorid
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Opened database successfully");/////////////////////////////////////////////////////////////
    }

    private void looTabel() {
        String sql = "CREATE TABLE IF NOT EXISTS PROJECTS (ID INTEGER PRIMARY KEY, PROJECTNAME TEXT, PROJECTTEXT TEXT);";//Käsk ise on CREATE TABLE ja sulgude vahel on kõik tulbad, mida tahan, et tabel hoiaks.
        teostaAndmebaasiMuudatus(sql);
    }

    private void looTabelDetailid() {
        String sql = "CREATE TABLE IF NOT EXISTS PROJECTDETAILS (ID INTEGER PRIMARY KEY, PROJECTNAME TEXT, DETAILNUMBER TEXT, DETAILDATE TEXT, DETAILPRIORITY TEXT, DETAILEXPLANATION TEXT, DETAILSPECIFIC TEXT);";
        teostaAndmebaasiMuudatus(sql);
    }

    private void teostaAndmebaasiMuudatus(String sql) {
        try {
            Statement stat = conn.createStatement();                                                                    //Statement objekt on vajalik, et SQL_Login käsku käivitada
            stat.executeUpdate(sql);
            stat.close();                                                                                               //Statement tuleb samuti kinni panna nagu ka Connection.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvestaProjekt(String w) {
        String sql = "INSERT INTO PROJECTS (PROJECTNAME) VALUES ('"+w+"')";                                             //Andmete sisestamiseks on käsk INSERT. Esimestes sulgudes on tulabad KUHU salvestada, teistes sulgudes VALUES() on MIDA salvestada.
        teostaAndmebaasiMuudatus(sql);
    }

    public void sulgeYhendus() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Ühendus suletud");//////////////////////////////////////////////////////////////////////////
    }

    public ArrayList getProjectNames() {
        ArrayList projektinimed = new ArrayList();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT PROJECTNAME FROM PROJECTS;";

            ResultSet rs = stat.executeQuery(sql);                                                                      //Kui stat.executeQuery() toob tagasi tühja tulemuse, siis rs'i kasutada ei saa.

            while (rs.next()){                                                                                          //Kui oleks mitu rida andmeid, peaks tsükliga lahendama while (rs.next()) {}
                projektinimed.add(rs.getString("projectname"));
            }

            // Nopin käsitsi andmed ühelt realt välja
            /*andmed.put("username", rs.getString("username"));
            andmed.put("password", rs.getString("password"));
            andmed.put("fullname", rs.getString("fullname"));
            andmed.put("number", rs.getString("number"));
            andmed.put("address", rs.getString("address"));*/

            rs.close();
            stat.close();
            return projektinimed;

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return projektinimed;
    }

    public void kustutaProjekt(String n) {
        try {
            Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM PROJECTS WHERE PROJECTNAME = ('"+n+"');");
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void saveProjectText(String htmltxt, String projectname) {
        String sql = String.format("UPDATE PROJECTS SET PROJECTTEXT = '%s' WHERE PROJECTNAME = '" + projectname + "';", htmltxt);
        teostaAndmebaasiMuudatus(sql);
    }

    public HashMap getProjectText(String n) {
        HashMap projektidetailid = new HashMap();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM PROJECTS WHERE PROJECTNAME = '" + n + "' LIMIT 1;";
            ResultSet rs = stat.executeQuery(sql);

            projektidetailid.put("projectname", rs.getString("projectname"));
            projektidetailid.put("projecttext", rs.getString("projecttext"));

            rs.close();
            stat.close();
            return projektidetailid;

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return projektidetailid;
    }

    public HashMap getProjectDetailText(String n) {
        HashMap projektidetailitekst = new HashMap();
        if (n != null) {
            try {
                Statement stat = conn.createStatement();
                String sql = "SELECT * FROM PROJECTDETAILS WHERE ID = '" + n + "' LIMIT 1;";
                ResultSet rs = stat.executeQuery(sql);

                projektidetailitekst.put("id", rs.getString("id"));
                projektidetailitekst.put("detailspecific", rs.getString("detailspecific"));

                rs.close();
                stat.close();
                return projektidetailitekst;

            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        return projektidetailitekst;

    }

    public void kustutaProjektiDetail(String n, String n2) {
        try {
            Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM PROJECTDETAILS WHERE PROJECTNAME = ('"+n+"') AND ID = ('"+n2+"');");
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void kustutaProjektiDetailidKoik(String n){                                                                  //DetailsTableView.saveDetails();
        try {
            Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM PROJECTDETAILS WHERE PROJECTNAME = ('"+n+"');");
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void salvestaProjektiDetailid(String n, String number, String date, String priority, String explanation, String specific) { //DetailsTableView.saveDetails();
        if(true){
            String sql = "INSERT INTO PROJECTDETAILS (PROJECTNAME, DETAILNUMBER, DETAILDATE, DETAILPRIORITY, DETAILEXPLANATION, DETAILSPECIFIC) VALUES ('"+n+"', '"+number+"', '"+date+"', '"+priority+"', '"+explanation+"', '"+specific+"')";
            teostaAndmebaasiMuudatus(sql);
        }
    }

    public ObservableList getProjectDetails(String n) {
        //HashMap andmed = new HashMap();
        ObservableList<DetailsTableView.ProjectDetail> andmed = FXCollections.observableArrayList();
        System.out.println("getProjectDetails kaivitatud!");////////////////////////////////////////////////////////////

        if(true){
            try {
                Statement stat = conn.createStatement();
                String sql = "SELECT * FROM PROJECTDETAILS WHERE PROJECTNAME = '" + n + "';";
                ResultSet rs = stat.executeQuery(sql);

                while (rs.next()) {
                    andmed.add(new DetailsTableView.ProjectDetail(rs.getString("id"), rs.getString("detailnumber"), rs.getString("detaildate"), rs.getString("detailpriority"), rs.getString("detailexplanation"), rs.getString("detailspecific")));
                }

/*                while (rs.next()){
                    andmed.put("detailnumber", rs.getString("detailnumber"));
                    andmed.put("detaildate", rs.getString("detaildate"));
                    andmed.put("detailpriority", rs.getString("detailpriority"));
                    andmed.put("detailexplanation", rs.getString("detailexplanation"));
                }*/

                rs.close();
                stat.close();

                System.out.println("getProjectDetails loi HashMapi!");//////////////////////////////////////////////////
                return andmed;

            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        return andmed;
    }
}
