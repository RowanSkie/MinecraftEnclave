package net.mineclave.fabric;

import net.fabricmc.api.ModInitializer;
import net.mineclave.fabric.registry.EnclaveInit;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnclaveMain implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "mineclave";
	public static final String MOD_NAME = "MinecraftEnclave";

	@Override
	public void onInitialize() {
		log(Level.INFO,"Mod initialized.");
		EnclaveInit.init();
	}

	public static void log(Level level, String message){
		LOGGER.log(level, "["+MOD_NAME+"] " + message);
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID,path);
	}
}
