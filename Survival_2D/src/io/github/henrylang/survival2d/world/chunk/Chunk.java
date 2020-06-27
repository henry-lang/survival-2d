package io.github.henrylang.survival2d.world.chunk;

import io.github.henrylang.survival2d.world.World;
import io.github.henrylang.survival2d.world.tile.Tile;
import processing.core.PApplet;
import processing.core.PShape;

public class Chunk {
	public int x, y;
	public boolean needsRebuild;
	Tile[][] tiles;
	PShape mesh;
	
	public Chunk(int x, int y) {
		this.x = x;
		this.y = y;
		this.tiles = new Tile[World.CHUNK_LENGTH][World.CHUNK_LENGTH];
		this.needsRebuild = true;
		
		for(int i = 0; i < World.CHUNK_LENGTH; i++) {
			 
		}
	}
	
	public void buildMesh() {
		
	}
	
	public boolean equals(Object object) {
		if(!(object instanceof Chunk)) {
			return false;
		}
		
		Chunk chunk = (Chunk) object;
		return x == chunk.x && y == chunk.y;
	}
}
