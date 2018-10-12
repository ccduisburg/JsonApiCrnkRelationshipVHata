package com.codenotfound.crnk.com.edutilos.javafx;

import com.codenotfound.crnk.client.BlogClient;
import com.codenotfound.crnk.domain.model.Adress;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.List;

public class Example1  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Scene scene, scene2;
    private VBox root, root2;
    private Button btnFindUniById, btnListAdress;
    private TextField fieldUniId;
    private TextArea areaContent;
    private BlogClient client;
    private TableView table;
    private List<Adress> alladress;
    private GridPane gridPane;


    @Override
    public void start(Stage primaryStage) throws Exception {
        client = new BlogClient();
        client.init();
        addComponents();
        registerEvents();
        primaryStage.setTitle("List Data");
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    private void addComponents() {
        root = new VBox();
        root2 = new VBox();
        btnFindUniById = new Button("Find Worker By Id");
        fieldUniId = new TextField();
        areaContent = new TextArea();
        table = new TableView<>();
        gridPane = new GridPane();
        alladress = new ArrayList<>();
        btnListAdress = new Button("List Adress");
        root.getChildren().addAll(btnFindUniById, fieldUniId, areaContent, table);
        root2.getChildren().addAll(gridPane, btnListAdress);
        scene = new Scene(root, 500, 500);
        scene2 = new Scene(root2, 500, 500);
    }

    private void registerEvents() {
        ShowAllAdress();
        btnFindUniById.setOnAction(evt -> {
//            System.out.println("debug");


            try {
                long id = Long.parseLong(fieldUniId.getText());
                Adress adress = client.findOneAdress(id);
                areaContent.setText(adress.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                areaContent.setText(ex.getMessage());
            }
        });

        btnListAdress.setOnAction(event -> {

            try {
                showDataAufGrid();
                //ShowAllAdress();
            } catch (Exception ex) {
                ex.printStackTrace();

            }


        });
    }

    private void ShowAllAdress() {
        table.setEditable(true);
//            TableColumn firstNameCol = new TableColumn("id");
//            firstNameCol.setCellValueFactory( new PropertyValueFactory<Adress,Long>("id"));
        TableColumn strasse = new TableColumn("strasse");
        strasse.setCellValueFactory(new PropertyValueFactory<Adress, String>("strasse"));
        TableColumn hnummer = new TableColumn("Hausnummer");
        hnummer.setCellValueFactory(new PropertyValueFactory<Adress, Integer>("hnummer"));
        TableColumn PLZ = new TableColumn("PLZ");
        PLZ.setCellValueFactory(new PropertyValueFactory<Adress, String>("PLZ"));
        TableColumn city = new TableColumn("city");
        city.setCellValueFactory(new PropertyValueFactory<Adress, String>("city"));

        alladress.addAll(client.findAllAdress());
        table.getItems().clear();
        table.getItems().addAll(alladress);
        System.out.println(alladress);
        table.getColumns().addAll(strasse, hnummer, PLZ, city);

    }


    private void showDataAufGrid() {
       gridPane.getColumnConstraints().addAll(table.getItems());

    }
}
/*
 public void loadPersonStudents(List<PersonStudent> students) {
        tblvSchule.getItems().clear();
        tblvSchule.getItems().addAll(students);
    }
 */