package signin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import signup.SignUpController;

// 페이지 전환(로그인 페이지 -> 회원가입 버튼 클릭 -> 회원가입 페이지) 클래스
public class SignUpPageBtn {
	Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void signupPageBtn() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader =
					new FXMLLoader(getClass().getResource("../signup/signUpView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			SignUpController ctl = loader.getController();
			ctl.setRoot(root);

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
