module com.school.test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.school.test to javafx.fxml;
    exports com.school.test;
}