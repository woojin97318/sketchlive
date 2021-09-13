package login;

import common.AlertClass;
import common.Exit;
import common.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lobby.LobbyStart;

public class LoginImpl implements Login{
	LoginFunc fc = new LoginFunc();
	LobbyStart ls = new LobbyStart();
	Exit exit = new Exit();
	@Override
	public void loginProc(Parent root) {
		TextField signinId = (TextField)root.lookup("#signinId");
		PasswordField signinPw = (PasswordField)root.lookup("#signinPw");
		MemberDTO dto = fc.LoginProc(signinId.getText());
		String msg = null;
		
		//로그인창에서 발생할 수 있는 오류들
		if(signinId.getText() == "") {
			msg = "아이디를 입력하세요";
		}else if(signinPw.getText() == ""){
			msg = "비밀번호를 입력하세요";
		}else if(dto != null) {
			if(dto.getPw().equals(signinPw.getText())) {
				msg = "로그인 성공";
				//로그인 성공시 로비로 이동(새창 띄움)
				ls.lobbyStart();
				exit.setRoot(root);
				exit.windowClose();
			}else {
				msg = "비밀번호가 틀립니다";
			}
		}else{
			msg = "아이디가 존재하지 않습니다";
		}
		AlertClass.alertInfo(msg);
	}

}
