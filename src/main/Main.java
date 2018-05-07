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


        //Image anotherIcon = new Image("lnu.png");

<<<<<<< HEAD
       // Image anotherIcon = new Image("logo.png");

=======
>>>>>>> cd68a2b971dd63fe522f5d0f0ab4ad47e13b7e9a

        primaryStage.getIcons().add(anotherIcon);

        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
