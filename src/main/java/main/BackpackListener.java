package main;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BackpackListener implements Listener {

	@EventHandler
	public void openBackpackViaInteraction(PlayerInteractEvent event) {

		Action action = event.getAction();

		if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {

			if (event.getItem() != null) {

				ItemStack item = event.getItem();
				Player player = (Player) event.getPlayer();

				if (item.getItemMeta().equals(ItemManager.largeBackpack.getItemMeta())) {

					Backpack backpack = Main.getInstance().getBpManager().getLargeBackpack(player.getUniqueId());
					player.openInventory(backpack.getInventory());

				} else if (item.getItemMeta().equals(ItemManager.smallBackpack.getItemMeta())) {

					Backpack backpack = Main.getInstance().getBpManager().getSmallBackpack(player.getUniqueId());
					player.openInventory(backpack.getInventory());

				}

			}

		}

	}


	@EventHandler
	public void openBackpackViaInventoryClick(InventoryClickEvent event) {
		if(event == null) {
			return;
		}
		if (event.isRightClick()) {

			ItemStack currentItem = event.getCurrentItem();
			Player player = (Player) event.getWhoClicked();

			if (currentItem.getItemMeta().equals(ItemManager.largeBackpack.getItemMeta())) {

				Backpack backpack = Main.getInstance().getBpManager().getLargeBackpack(player.getUniqueId());
				event.setCancelled(true);
				player.openInventory(backpack.getInventory());

			} else if (currentItem.getItemMeta().equals(ItemManager.smallBackpack.getItemMeta())) {

				Backpack backpack = Main.getInstance().getBpManager().getSmallBackpack(player.getUniqueId());
				event.setCancelled(true);
				player.openInventory(backpack.getInventory());

			}

		}

	}

}