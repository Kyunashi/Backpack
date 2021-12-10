package main;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;

import utils.Base64;

public class LargeBackpack extends Backpack {

	public LargeBackpack(UUID uuid) {

		this.uuid = uuid;
		inventory = Bukkit.createInventory(null, 54, "LargeBackpack");

	}


	public LargeBackpack(UUID uuid, String base64) throws IOException {

		this.uuid = uuid;
		this.inventory = Bukkit.createInventory(null, 54, "LargeBackpack");
		this.inventory.setContents(Base64.itemStackArrayFromBase64(base64));

	}

}
