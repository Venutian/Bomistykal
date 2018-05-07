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


        Image anotherIcon = new Image("logo.png");

<<<<<<< HEAD

        //Image anotherIcon = new Image("lnu.png");


       // Image anotherIcon = new Image("logo.png");



=======
>>>>>>> 351f6c3a14a1e4d36c25f8c533c4a4c2eb45659c
        primaryStage.getIcons().add(anotherIcon);

        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
