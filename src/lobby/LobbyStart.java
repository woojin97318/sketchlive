package lobby;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import signup.SignUpController;

//로비 페이지 불러오기
public class LobbyStart {
	
	public void lobbyStart() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader =
					new FXMLLoader(getClass().getResource("lobbyView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			LobbyController ctl = loader.getController();
			ctl.setRoot(root);

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
