package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.NPC_OldMan;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import tile.TileManager;

public class AssetSetter {

	GamePanel gp;
	TileManager tm;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		this.tm = new TileManager(gp);
	
	}
	
	public List<Integer> locationRandom() {
		Random r = new Random();

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 49; i++) {
			for (int j = 0; j < 49; j++) {
			
				if (tm.mapTileNum[i][j] != 1) {
					if ((i <= 10 || i >= 30) && (j <= 10 || j >= 30)) {
						List<Integer> l = new ArrayList<>();
						l.add(i);
						l.add(j);
						list.add(l);
					}
			
				}
			}
		}
		return list.get(r.nextInt(list.size()));
	}
	

	
	public void setObject() {
	
		
		
		gp.obj[0] = new OBJ_Chest();
		gp.obj[0].worldX = 22 * gp.tileSize;
		gp.obj[0].worldY = 22 * gp.tileSize;
		
	
		
		for (int i = 1; i < 30; i ++) {
			gp.obj[i] = new OBJ_Key();
			List<Integer> rand = locationRandom();
			
			gp.obj[i].worldX = rand.get(0) * gp.tileSize;
			gp.obj[i].worldY = rand.get(1) * gp.tileSize;
		}
	}
	
	public void setNPC() {
		
		for (int i = 0; i < 100; i ++) {
			gp.npc[i] = new NPC_OldMan(gp);
			List<Integer> k = locationRandom();
			gp.npc[i].worldX = k.get(0) * gp.tileSize;
			gp.npc[i].worldY = k.get(1) * gp.tileSize;
		}	
	
	}
}
