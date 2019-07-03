package com.sqlite.hibernate;

import com.sqlite.hibernate.controller.SiswaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Agus Suhardi on 4/16/2017.
 */
public class Main extends Application {


    private Stage primariStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primariStage = primaryStage;
        showSiswa();
    }


    public Initializable getController(String fxml) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);


            primariStage.setScene(scene);
            primariStage.show();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showSiswa() {
        SiswaController controller = (SiswaController) getController("/view/Siswa.fxml");
        controller.setApplication(this);
    }

}
