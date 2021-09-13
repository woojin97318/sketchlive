package signup;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import signup.btn.IdChkBtn;
import signup.btn.ImageSearchBtn;
import signup.btn.NickChkBtn;
import signup.btn.PwChkBtn;
import signup.btn.SignUpBtn;

// 회원가입 페이지 컨트롤러 클래스
public class SignUpController implements Initializable{
	Parent root;
	ImageSearchBtn isb;
	IdChkBtn icb;
	PwChkBtn pcb;
	NickChkBtn ncb;
	SignUpBtn sub;
	@FXML ImageView profileView;
	public void setRoot(Parent root) {
		this.root = root;
		isb = new ImageSearchBtn();
		icb = new IdChkBtn();
		pcb = new PwChkBtn();
		ncb = new NickChkBtn();
		sub = new SignUpBtn();
		addComboBox();
		defaultProfile();
	}
	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge != null) {
			cmbAge.getItems().addAll("10대", "20대", "30대", "40대", "50대 이상");
		}
	}
	public void defaultProfile() {
		System.out.println("FXML Load Complete");

		String url = "main/image/defaultProfile.png";
		Image img = new Image(url);
		profileView.setFitHeight(85);
		profileView.setFitWidth(85);
		profileView.setImage(img);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void imageSearchBtn() {
		isb.setRoot(root);
		isb.imageSearchBtn();
	}
	public void idChkBtn() {
		icb.setRoot(root);
		icb.idChkBtn();
	}
	public void pwChkBtn() {
		pcb.setRoot(root);
		pcb.pwChkBtn();
	}
	public void nickChkBtn() {
		ncb.setRoot(root);
		ncb.nickChkBtn();
	}
	public void signupBtn() {
		sub.setRoot(root);
		sub.signupBtn();
	}

}
