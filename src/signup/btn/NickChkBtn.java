package signup.btn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.AlertClass;
import common.DBClass;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// 회원가입 페이지에서 닉네임 체크버튼 클릭 이벤트 클래스
public class NickChkBtn {
	Parent root;
	DBClass db = new DBClass();
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void nickChkBtn() {
		TextField signupNick = (TextField)root.lookup("#signupNick");
		Label nickChkLabel = (Label)root.lookup("#nickChkLabel");

		if(signupNick.getText() == "") {
			AlertClass.alertErr("닉네임을 입력하세요.");
		}else {
			try {
				String sql = "select nickname from member";
				PreparedStatement ps = db.conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(true) {
					if(rs.next()) {
						if(rs.getString("nickname").equals(signupNick.getText())) {
							nickChkLabel.setText("중복된 닉네임입니다");
							break;
						}
					}else {
						nickChkLabel.setText("사용 가능한 닉네임입니다");
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
