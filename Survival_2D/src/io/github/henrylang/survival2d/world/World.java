package io.github.henrylang.survival2d.world;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.github.henrylang.survival2d.chunk.Chunk;
import io.github.henrylang.survival2d.player.Player;
import processing.core.PApplet;

public class World {
	public static final int BLOCK_SIZE = 10;

	public static final int CHUNK_LENGTH = 16;
	public static final int RENDER_DISTANCE = 10;
	public static final int WORLD_CHUNK_HEIGHT = 15;
	
	PApplet app;
	public List<Chunk> loadedChunks;
	public Player player;
	
	public World(PApplet app) {
		this.app = app;
		loadedChunks = new CopyOnWriteArrayList<Chunk>();
		player = new Player();
	}
	
	public void update() {
		int playerChunkX = (int) (player.pos.x / CHUNK_LENGTH);
		int playerChunkY = (int) (player.pos.y / CHUNK_LENGTH);
		
		checkUnloadChunks(playerChunkX, playerChunkY);
		checkLoadChunks(playerChunkX, playerChunkY);
		
		System.out.println(loadedChunks.size());
		
		for(Chunk chunk : loadedChunks) {
			app.strokeWeight(5);
			app.stroke(0);
			app.point(chunk.x * 10, chunk.y * 10 + 40);
		}
		
		player.pos.x++;
	}
	
	public void checkUnloadChunks(int playerChunkX, int playerChunkY) {
		int chunkView = (RENDER_DISTANCE - 1) / 2;
		
		for(Chunk chunk : loadedChunks) {
			if(chunk.x > playerChunkX + chunkView || chunk.x < playerChunkX - chunkView) {
				//TODO: Save chunk! 
				loadedChunks.remove(chunk);
			}
		}
	}
	
	public void checkLoadChunks(int playerChunkX, int playerChunkY) {
		int chunkView = (RENDER_DISTANCE - 1) / 2;
		
		for(int x = playerChunkX - chunkView; x <= playerChunkX + chunkView; x++) {
			for(int y = 0; y < WORLD_CHUNK_HEIGHT; y++) {
				if(!loadedChunks.contains(new Chunk(x, y))) {
					//TODO: Load chunk!
					loadedChunks.add(new Chunk(x, y));
				}
			}
		}
	}
}
