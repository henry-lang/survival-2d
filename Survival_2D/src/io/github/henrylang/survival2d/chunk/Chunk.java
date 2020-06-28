package io.github.henrylang.survival2d.chunk;

import io.github.henrylang.survival2d.tile.Tile;
import io.github.henrylang.survival2d.tile.TileTypes;
import io.github.henrylang.survival2d.world.World;
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
		
		for(int tx = 0; tx < World.CHUNK_LENGTH; tx++) {
			for(int ty = 0; ty < World.CHUNK_LENGTH; ty++) {
				tiles[tx][ty] = (Tile) TileTypes.types.get(0).clone();
				System.out.println(tiles[tx][ty]);
			}
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
