package com.example.pjatkpasswordmanagerv3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.*;

public class AfterLogin implements Initializable {

    public TextField searchBar;
    private int startid = 0;

    public TextField inputName;
    public TextField inputPassword;
    public TextField inputCategory;
    public TextField inputPage;
    public Button submit;
    public TextField inputId;
    public Button remove;
    public Button add;

    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> name;
    @FXML
    private TableColumn<User, String> password;
    @FXML
    private TableColumn<User, String> category;
    @FXML
    private TableColumn<User, String> page;


    @FXML
    private TableView<User> table;


    public int getNewId(){
        ObservableList<User> currectTableData = dataList;
        for (User table : currectTableData){
            if(table.getId()>startid){
                startid=table.getId();
            }
        }
        startid++;
        return startid;


    }

    @FXML
    void togglbutton(ActionEvent event) {

    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("hello-view.fxml", 1);
    }

    ObservableList<User> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        category.setCellValueFactory(new PropertyValueFactory<User, String>("category"));
        page.setCellValueFactory(new PropertyValueFactory<User, String>("page"));
        setupTable();


        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);

            searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(user -> {
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if(user.getCategory().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            } );

        SortedList<User> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);



    }


    @FXML
    void SubmitAction(ActionEvent event){
        try {
            ObservableList<User> currectTableData = table.getItems();
            int currectTableId = Integer.parseInt(inputId.getText());

            for (User table : currectTableData) {
                if (table.getId() == currectTableId) {
                    table.setCategory(inputCategory.getText());
                    table.setPage(inputPage.getText());
                    table.setPassword(inputPassword.getText());
                    table.setName(inputName.getText());




                    break;
                }

            }
            table.setItems(currectTableData);
            table.refresh();
        }catch (Exception ignored){}
    }
    @FXML
    void rowClicked(MouseEvent event) {
        User clickedUser = table.getSelectionModel().getSelectedItem();
        try {
            inputId.setText(String.valueOf(clickedUser.getId()));
            inputName.setText(String.valueOf(clickedUser.getName()));
            inputPassword.setText(String.valueOf(clickedUser.getPassword()));
            inputCategory.setText(String.valueOf(clickedUser.getCategory()));
            inputPage.setText(String.valueOf(clickedUser.getPage()));
        }catch (Exception ignored){}

    }
    private void setupTable() {
        User user0 = new User(1, "Hasło1", "123", "Ładna", "www.arkinoego.pl");
        User user1 = new User(2, "Hasło2", "133", "JAKAŚ", "www.arkinoego.com");
        User user2 = new User(3, "Hasło3", "1235", "Łssdasa", "wwWWW.plpl");

        table.getItems().addAll(user0,user1,user2);
        dataList.addAll(user0,user1,user2);



    }

    public void RemoveOnAction(ActionEvent actionEvent) {
        try {
            int selectedID = table.getSelectionModel().getSelectedIndex();
            dataList.remove(selectedID);
        }catch (Exception ignored){}
    }
    @FXML
    public void addOnAction(ActionEvent actionEvent) {
        User user = new User(getNewId(),
                inputName.getText(),
                inputPassword.getText(),
                inputCategory.getText(),
                inputPage.getText());

        dataList.add(user);


    }





    public void ImportDataOnAction(ActionEvent actionEvent) throws IOException {

        String filePath = "C:\\Users\\osiak\\Desktop\\PJATKPasswordManagerv3\\testpliki.txt";
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        Object[] tableLines = br.lines().toArray();

        for (Object tableLine : tableLines) {

            String line = tableLine.toString().trim();
            String[] dataRow = line.split("/");


        }


       // int userid;
       // String username, userpassword, usercategory, userpage;
//        User user = new User(0,null,null,null,null);
//        for (int j = 0; j < 5 ; j++) {
//
//            for (int i = 0; i < tableLines.length; i++) {
//                String line = tableLines[i].toString().trim();
//                String[] dataRow = line.split("/");
//                if(user.getId()==0) {
//                    user.setId(Integer.parseInt(String.valueOf(dataRow)));
//                    break;
//                }
//                if(user.getName()==null) {
//                    user.setName(String.valueOf(dataRow));
//                    break;
//                }
//                if(user.getPassword()==null) {
//                    user.setPassword(String.valueOf(dataRow));
//                    break;
//                }
//                if(user.getCategory()==null) {
//                    user.setCategory(String.valueOf(dataRow));
//                    break;
//                }
//                if(user.getPage()==null) {
//                    user.setPage(String.valueOf(dataRow));
//                    break;
//                }
//            }


//            table.getItems().add(new User(user.getId(),user.getName(), user.getPassword(),user.getCategory(),user.getPage()));
//            dataList.add(user);
           // user = new User(userid,username,userpassword,usercategory,userpage);

//        }

    }
}

