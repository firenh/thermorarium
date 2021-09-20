package fireopal.thermorarium;

import fireopal.thermorarium.biomes.ThermorariumBiomes;
import fireopal.thermorarium.features.ThermorariumConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Thermorarium implements ModInitializer {
	public static final String MODID = "thermorarium";

	@Override
	public void onInitialize() {
		ThermorariumConfiguredFeatures.init();
		ThermorariumBiomes.init();
	}

	public static Identifier id(String id) {
		return new Identifier(MODID, id);
	}
}
