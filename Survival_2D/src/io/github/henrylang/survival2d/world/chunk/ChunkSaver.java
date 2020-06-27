package io.github.henrylang.survival2d.world.chunk;

import java.io.FileWriter;
import java.io.IOException;

public class ChunkSaver {
	public static void saveChunkToFile(int chunkX, int chunkY) {
		String fileName = chunkX + " " + chunkY + ".chunk";
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write("haha");
			writer.close();
			System.out.println("Wrote to new file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
