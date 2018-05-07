package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        primaryStage.setScene(new Scene(root));
<<<<<<< HEAD
        Image anotherIcon = new Image("logo.png");
=======

        Image anotherIcon = new Image("lnu.png");
>>>>>>> 3ded19147178d05e1bcf51ea78ff3058b3cbf414
        primaryStage.getIcons().add(anotherIcon);

        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
