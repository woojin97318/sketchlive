package signin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import login.Login;
import login.LoginImpl;

// 로그인 페이지 컨트롤러 클래스
public class SignInController implements Initializable{
	Parent root;
	SignUpPageBtn supb;
	Login lg;
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		supb = new SignUpPageBtn();
		lg = new LoginImpl();
	}
	
	public void loginBtn() {
		// 로그인 버튼 클릭
		lg.loginProc(root);
		
	}
	public void signupPageBtn() {
		// 회원가입 버튼 클릭
		supb.setRoot(root);
		supb.signupPageBtn();
	}

}
