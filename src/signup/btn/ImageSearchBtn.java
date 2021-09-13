package signup.btn;

import javafx.scene.Parent;

// 회원가입 페이지에서 사진 불러오기 버튼 클래스
public class ImageSearchBtn {
	Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void imageSearchBtn() {
		System.out.println("이미지 찾기 클릭");
	}
}
