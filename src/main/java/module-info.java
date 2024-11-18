module com.example.pjatkpasswordmanagerv3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pjatkpasswordmanagerv3 to javafx.fxml;
    exports com.example.pjatkpasswordmanagerv3;
}