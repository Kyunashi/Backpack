package utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private File file;
	private YamlConfiguration config;

	public Config() {

		File dir = new File("./plugins/Backpack/");

		if (!dir.exists()) {

			dir.mkdirs();

		}

		this.file = new File(dir, "config.yml");

		if (!file.exists()) {

			try {

				file.createNewFile();

			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

		config = YamlConfiguration.loadConfiguration(file);

	}


	public File getFile() {

		return file;

	}


	public YamlConfiguration getConfig() {

		return config;

	}


	public void save() {

		try {

			config.save(file);

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
