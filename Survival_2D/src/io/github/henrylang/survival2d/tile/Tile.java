package io.github.henrylang.survival2d.tile;

public class Tile implements Cloneable {
	int id;
	boolean solid, air;
	String name;
	
	public Tile(int id, boolean solid, boolean air, String name) {
		this.id = id; // Interally stored for texture UV!
		this.solid = solid;
		this.air = air;
		this.name = name;
	}
}
