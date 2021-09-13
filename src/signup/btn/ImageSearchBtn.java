package signup.btn;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

// 회원가입 페이지에서 사진 불러오기 버튼 클래스
public class ImageSearchBtn {
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void imageSearchBtn() {
		ImageView imgView = (ImageView)root.lookup("#profileView");

		System.out.println("이미지 찾기 클릭");
		//사진 선택 창
		FileChooser fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("C:/"));//default 디렉토리 지정
		//선택한 파일 정보 추출
		//확장자 제한
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg","*.gif","*.png");
		ExtensionFilter txtType = new ExtensionFilter("text file", "*.txt", "*.doc");
		fc.getExtensionFilters().addAll(imgType,txtType);

		File selectedFile = fc.showOpenDialog(null); //창을띄우는데 어느 위치에 띄울건지 인자를 받고 선택한 파일의 경로값을 반환함.

		System.out.println(selectedFile);//선택한 경로 출력


		//파일을 InputStream으로 읽어옴
		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bis = new BufferedInputStream(fis);

			Image img = new Image(bis);

			imgView.setImage(img);

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
