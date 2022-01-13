package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Britt extends SuperObject {
	public OBJ_Britt() {
		name = "Britt";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/britt.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
