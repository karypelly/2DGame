package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Britt;
import object.OBJ_Key;

public class UI {

	Graphics2D g2;
	GamePanel gp;
	Font arial_40, arial_80B;
	BufferedImage keyImage;
	BufferedImage brittImage;
	
	public boolean messageOn = false;
	public String message = "";
	
	int messageCounter = 0;
	int dialogCounter = 0;
	
	public boolean gameFinished = false;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		OBJ_Key key = new OBJ_Key();
		keyImage = key.image;
		OBJ_Britt britt = new OBJ_Britt();
		brittImage = britt.image;
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		if (gameFinished == true) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			String text;
			int textLength;
			int x;
			int y;
			text = "You found the treasure!";
			textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize*3);
			
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			text = "Congratulations!";
			textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*2);
			
			g2.drawString(text, x, y);
			gp.gameThread = null;
			
			
		}else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasKey, 74, 65);
			
			if (messageOn = true) {
				
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
				messageCounter++;
				
				if (messageCounter > 120) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}
		
		if (gp.dialogState == true) {
			
			dialogCounter++;
			if (dialogCounter < 350) {
				dialogCounter++;
				drawDialogScrren();
				gp.gameState = gp.pauseState;
				
				
			}
			if (dialogCounter >= 350) {
				gp.dialogState = false;
				dialogCounter = 0;
				gp.gameState = gp.playState;
			}
			
			
		}
		if (gp.gameState == gp.pauseState) {
			drawPauseScreen();
			
			
		}
		
	}
	public void drawPauseScreen() {
		String text = "";
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		int y = gp.screenHeight/2;
		g2.drawString(text, x, y + 50);
		g2.drawImage(brittImage, gp.maxScreenCol /2  + 225, gp.maxScreenRow / 2* gp.tileSize - 10, 300, 300, null);
	}
	
	
	public void drawDialogScrren() {
		String text = "BOOM BOOM";
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		int y = gp.screenHeight/2;
		g2.drawString(text, x, y);
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		Color c = new Color(0, 0, 0);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
	}
	
	
}
