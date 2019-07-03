package com.sqlite.hibernate.controller;

import com.sqlite.hibernate.Main;
import com.sqlite.hibernate.config.HibernateUtil;
import com.sqlite.hibernate.config.SiswaUploadXls;
import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.SiswaEntity;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.util.Pair;


import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class SiswaController implements Initializable {
    public TextField txtNis;
    public TextField txtNama;
    public TextField txtNilai;
    public TextField txtKelas;
    public TextField txtGuru;
    public TableView tblSiswa;
    public TableColumn columnNis;
    public TableColumn columnNama;
    public TableColumn columnNilai;
    public TableColumn columnKelas;
    public TextField txtPath;
    public Button btnUpload;
    public GridPane form;


    SiswaDao dao = HibernateUtil.getSiswaDao();
    private Main application;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        form.setVisible(false);
        loadData();
        columnNis.setCellValueFactory(new PropertyValueFactory<SiswaEntity, String>("nis"));
        columnNama.setCellValueFactory(new PropertyValueFactory<SiswaEntity, String>("nama"));
        columnNilai.setCellValueFactory(new PropertyValueFactory<SiswaEntity, String>("nilai"));
        columnKelas.setCellValueFactory(new PropertyValueFactory<SiswaEntity, String>("kelas"));

    }

    public void loadData() {
        tblSiswa.getItems().clear();
        tblSiswa.getItems().addAll(dao.findAll());
    }

    public void setApplication(Main application) {
        this.application = application;
    }


    public void onSave(ActionEvent actionEvent) {
        SiswaEntity s = new SiswaEntity(txtNis.getText(), txtNama.getText(), Integer.parseInt(txtNilai.getText()), Integer.parseInt(txtKelas.getText()), txtGuru.getText());
        dao.save(s);
        loadData();
    }

    public void onUpload(ActionEvent actionEvent) throws Exception {

        SiswaUploadXls u = new SiswaUploadXls();
        u.save(txtPath.getText());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sukses");
        alert.setHeaderText("Siswa");
        alert.setContentText("Daftar Siswa berhasil di upload");

        alert.showAndWait();
        loadData();
    }

    public void doOpen(MouseEvent mouseEvent) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            txtPath.setText(file.getAbsolutePath());
            btnUpload.setDisable(false);
        }
    }

    public void onLogin(ActionEvent actionEvent) {
//        form.setVisible(true);


        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login");
        dialog.setHeaderText("Silakan Login");

// Set the icon (must be included in the project).
//        dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
//        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
//            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            if (usernamePassword.getKey().equals("agus") && usernamePassword.getValue().equals("suhardi")) {
                form.setVisible(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Data Salah");
                alert.setContentText("Maaf, Anda bukan Pengguna!");

                alert.showAndWait();
            }

        });


    }
}
