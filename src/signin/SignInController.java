package signin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

// 로그인 페이지 컨트롤러 클래스
public class SignInController implements Initializable{
	Parent root;
	SignUpPageBtn supb;
	
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		supb = new SignUpPageBtn();
	}
	
	public void loginBtn() {
		// 로그인 버튼 클릭
		
	}
	public void signupPageBtn() {
		// 회원가입 버튼 클릭
		supb.setRoot(root);
		supb.signupPageBtn();
	}

}
