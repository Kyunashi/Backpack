package main;

import java.util.UUID;

import org.bukkit.inventory.Inventory;

import utils.Base64;

public abstract class Backpack {

	protected  UUID uuid;

	protected Inventory inventory;



	public UUID getUuid() {

		return uuid;

	}


	public Inventory getInventory() {

		return inventory;

	}


	public String toBase64() {

		return Base64.itemStackArrayToBase64(inventory.getContents());

	}

}
