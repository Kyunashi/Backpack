package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import utils.Config;

public class BackpackManager {

	private final Map<UUID, Backpack> smallBackpacks;
	private final Map<UUID, Backpack> largeBackpacks;

	public BackpackManager() {

		this.largeBackpacks = new HashMap<>();
		this.smallBackpacks = new HashMap<>();
		load();

	}


	public Backpack getSmallBackpack(UUID uuid) {

		if (smallBackpacks.containsKey(uuid)) {

			return smallBackpacks.get(uuid);

		}

		Backpack backpack = new SmallBackpack(uuid);
		smallBackpacks.put(uuid, backpack);

		return backpack;

	}


	public Backpack getLargeBackpack(UUID uuid) {

		if (largeBackpacks.containsKey(uuid)) {

			return largeBackpacks.get(uuid);

		}

		Backpack backpack = new LargeBackpack(uuid);
		largeBackpacks.put(uuid, backpack);

		return backpack;

	}


	public void setSmallBackpack(UUID uuid, Backpack backpack) {

		smallBackpacks.put(uuid, backpack);

	}


	public void setLargeBackpack(UUID uuid, Backpack backpack) {

		largeBackpacks.put(uuid, backpack);

	}


	private void saveSmall() {

		Config config = Main.getInstance().getConfiguration();

		List<String> uuids = new ArrayList<>();

		for (UUID uuid : smallBackpacks.keySet()) {

			uuids.add(uuid.toString());

		}

		config.getConfig().set("smallbackpacks", uuids);
		smallBackpacks.forEach((uuid, backpack) -> {

			config.getConfig().set("smallbackpack." + uuid.toString(), backpack.toBase64());

		});

	}


	private void saveLarge() {

		Config config = Main.getInstance().getConfiguration();

		List<String> uuids = new ArrayList<>();

		for (UUID uuid : largeBackpacks.keySet()) {

			uuids.add(uuid.toString());

		}

		config.getConfig().set("largebackpacks", uuids);
		largeBackpacks.forEach((uuid, backpack) -> {

			config.getConfig().set("largebackpack." + uuid.toString(), backpack.toBase64());

		});

	}


	public void save() {

		saveLarge();
		saveSmall();

	}


	public void load() {

		loadLarge();
		loadSmall();

	}


	private void loadSmall() {

		Config config = Main.getInstance().getConfiguration();

		List<String> uuids = config.getConfig().getStringList("smallbackpacks");

		uuids.forEach((s) -> {

			UUID uuid = UUID.fromString(s);

			String base64 = config.getConfig().getString("smallbackpack." + s);

			try {

				smallBackpacks.put(uuid, new SmallBackpack(uuid, base64));

			} catch (IllegalArgumentException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		});

	}


	private void loadLarge() {

		Config config = Main.getInstance().getConfiguration();

		List<String> uuids = config.getConfig().getStringList("largebackpacks");

		uuids.forEach((s) -> {

			UUID uuid = UUID.fromString(s);

			String base64 = config.getConfig().getString("largebackpack." + s);

			try {

				largeBackpacks.put(uuid, new LargeBackpack(uuid, base64));

			} catch (IllegalArgumentException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		});

	}

}
