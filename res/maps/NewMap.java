package maps;

import java.util.Random;

public class NewMap {
	
	static Random r = new Random(5);
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (i == 0 || j == 0 || i == 49 || j == 49) {
					System.out.print(1 + " ");
				}else {
					System.out.print(0 + " ");
				}
			}
			System.out.println("");
		}
	}
}
