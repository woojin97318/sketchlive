package signup.btn;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class PwChkBtn {
	Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void pwChkBtn() {
		PasswordField signupPw = (PasswordField)root.lookup("#signupPw");
		PasswordField signupPwChk = (PasswordField)root.lookup("#signupPwChk");
		Label pwChkLabel = (Label)root.lookup("#pwChkLabel");
		
		if(signupPw.getText().equals(signupPwChk.getText())) {
			pwChkLabel.setText("비밀번호가 일치합니다");
		}else {
			pwChkLabel.setText("비밀번호가 서로 다릅니다");
		}
	}
}
