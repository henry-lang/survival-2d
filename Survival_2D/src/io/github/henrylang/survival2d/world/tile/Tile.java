package io.github.henrylang.survival2d.world.tile;

public class Tile {
	int id;
	boolean solid, air;
	String name;
	
	public Tile(int id, boolean solid, boolean air, String name) {
		this.id = id;
		this.solid = solid;
		this.air = air;
		this.name = name;
	}
}
