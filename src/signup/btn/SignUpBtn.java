package signup.btn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.AlertClass;
import common.DBClass;
import common.Exit;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpBtn {
	Parent root;
	DBClass db = new DBClass();

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void signupBtn() {
		TextField signupId = (TextField)root.lookup("#signupId");
		PasswordField signupPw = (PasswordField)root.lookup("#signupPw");
		PasswordField signupPwChk = (PasswordField)root.lookup("#signupPwChk");
		TextField signupNick = (TextField)root.lookup("#signupNick");
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		RadioButton rdoWoman = (RadioButton)root.lookup("#rdoWoman");
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		Label idChkLabel = (Label)root.lookup("#idChkLabel");
		Label pwChkLabel = (Label)root.lookup("#pwChkLabel");
		Label nickChkLabel = (Label)root.lookup("#nickChkLabel");

		int idResult = 0, nickResult = 0;
		// 아이디 중복 유무
		try {
			String sql = "select id from member";
			PreparedStatement ps = db.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(true) {
				if(rs.next()) {
					if(rs.getString("id").equals(signupId.getText())) {
						idResult = 1;
						break;
					}
				}else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 닉네임 중복유무
		try {
			String sql = "select nickname from member";
			PreparedStatement ps = db.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(true) {
				if(rs.next()) {
					if(rs.getString("nickname").equals(signupNick.getText())) {
						nickResult = 1;
						break;
					}
				}else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(signupId.getText().isEmpty()) {
			AlertClass.alertErr("아이디를 입력해주세요");
			signupId.requestFocus();
		}else if(signupPw.getText().isEmpty()) {
			AlertClass.alertErr("비밀번호를 입력해주세요");
			signupPw.requestFocus();
		}else if(signupPwChk.getText().isEmpty()) {
			AlertClass.alertErr("비밀번호 확인을 입력해주세요");
			signupPwChk.requestFocus();
		}else if(!signupPw.getText().equals(signupPwChk.getText())) {
			AlertClass.alertErr("비밀번호가 서로 다릅니다");
			pwChkLabel.setText("비밀번호가 서로 다릅니다");
			signupPwChk.requestFocus();
		}else if(signupNick.getText().isEmpty()) {
			AlertClass.alertErr("닉네임을 입력해주세요");
			signupNick.requestFocus();
		}else if(cmbAge.getValue() == null) {
			AlertClass.alertErr("나이를 선택해주세요");
			cmbAge.requestFocus();
		}else if(idResult == 1){
			AlertClass.alertErr("중복된 아이디입니다");
			idChkLabel.setText("중복된 아이디입니다");
			signupId.requestFocus();
		}else if(nickResult == 1){
			AlertClass.alertErr("중복된 닉네임입니다");
			nickChkLabel.setText("중복된 닉네임입니다");
			signupNick.requestFocus();
		}else {
			try {
				String sql = "insert into member values(?, ?, ?, ?, ?)";
				PreparedStatement ps = db.conn.prepareStatement(sql);
				ps.setString(1, signupId.getText());
				ps.setString(2, signupPw.getText());
				ps.setString(3, signupNick.getText());
				if(rdoMan.isSelected())
					ps.setString(4, "남성");
				else
					ps.setString(4, "여성");
				ps.setString(5, cmbAge.getValue().toString());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			AlertClass.alertInfo("회원이 되신것을 환영합니다.");
			Exit exit = new Exit();
			exit.setRoot(root);
			exit.windowClose();
		}

	}
}

