package main;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;

import utils.Base64;

public class SmallBackpack extends Backpack {

	public SmallBackpack(UUID uuid) {

		this.uuid = uuid;
		inventory = Bukkit.createInventory(null, 27, "SmallBackpack");

	}


	public SmallBackpack(UUID uuid, String base64) throws IOException {

		this.uuid = uuid;
		this.inventory = Bukkit.createInventory(null, 27, "SmallBackpack");
		this.inventory.setContents(Base64.itemStackArrayFromBase64(base64));

	}

}
