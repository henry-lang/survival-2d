package io.github.henrylang.survival2d;

import io.github.henrylang.survival2d.tile.TileTypes;
import io.github.henrylang.survival2d.world.World;
import processing.core.PApplet;

public class Window extends PApplet {
	World world;
	
	public static void main(String[] args) {
		PApplet.main(Window.class.getName());
	}
	
	public void setup() {
		world = new World(this);
		TileTypes.generateTypes();
		frameRate(60);
	}
	
	public void settings() {
		size(800, 800);
	}
	
	public void draw() {
		background(245);
		world.update();
		fill(0);
		text(frameRate, width / 2, height / 2);
	}
	
	public int randInt(int min, int max) {
		return (int) this.random(min, max);
	}
}
