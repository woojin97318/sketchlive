package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import signin.SignInController;

public class MainClass extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader =
				new FXMLLoader(getClass().getResource("../signin/signInView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		SignInController ctl = loader.getController();
		ctl.setRoot(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
