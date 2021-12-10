package main;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

	public static ItemStack smallBackpack;
	public static ItemStack largeBackpack;

	public void initialize() {

		addLargeBackpack();
		addSmallBackpack();

	}


	public void addSmallBackpack() {

		ItemStack smallBP = new ItemStack(Material.CHEST, 1);
		ItemMeta smallMeta = smallBP.getItemMeta();

		smallMeta.setDisplayName(ChatColor.RED + "Small Backpack");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("adds 27 item slots");
		smallMeta.setLore(lore);
		smallMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		smallBP.setItemMeta(smallMeta);

		NamespacedKey key = new NamespacedKey(Main.getInstance(), "smallBPRecipe");
		ShapedRecipe recipeSmall = new ShapedRecipe(key, smallBP);
		recipeSmall.shape("lll", "lcl", "lll");
		recipeSmall.setIngredient('l', Material.LEATHER);
		recipeSmall.setIngredient('c', Material.CHEST);

		Main.getInstance().getServer().addRecipe(recipeSmall);
		smallBackpack = smallBP;

	}


	public void addLargeBackpack() {

		ItemStack largeBP = new ItemStack(Material.CHEST, 1);
		ItemMeta largeMeta = largeBP.getItemMeta();

		largeMeta.setDisplayName(ChatColor.RED + "Large Backpack");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("adds 54 item slots");
		largeMeta.setLore(lore);
		largeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		largeBP.setItemMeta(largeMeta);

		NamespacedKey key = new NamespacedKey(Main.getInstance(), "largeBPRecipe");
		ShapedRecipe recipeLarge = new ShapedRecipe(key, largeBP);
		recipeLarge.shape("dld", "ece", "dld");
		recipeLarge.setIngredient('l', Material.LEATHER);
		recipeLarge.setIngredient('c', Material.ENDER_CHEST);
		recipeLarge.setIngredient('d', Material.DIAMOND);
		recipeLarge.setIngredient('e', Material.EMERALD);
		Main.getInstance().getServer().addRecipe(recipeLarge);
		largeBackpack = largeBP;

	}

}
