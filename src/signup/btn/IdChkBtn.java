package signup.btn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.AlertClass;
import common.DBClass;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IdChkBtn {
	Parent root;
	DBClass db = new DBClass();

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void idChkBtn() {
		TextField signupId = (TextField)root.lookup("#signupId");
		Label idChkLabel = (Label)root.lookup("#idChkLabel");

		if(signupId.getText() == "") {
			AlertClass.alertErr("아이디를 입력하세요.");
		}else {
			try {
				String sql = "select id from member";
				PreparedStatement ps = db.conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(true) {
					if(rs.next()) {
						if(rs.getString("id").equals(signupId.getText())) {
							idChkLabel.setText("중복된 아이디입니다");
							break;
						}
					}else {
						idChkLabel.setText("사용 가능한 아이디입니다");
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
