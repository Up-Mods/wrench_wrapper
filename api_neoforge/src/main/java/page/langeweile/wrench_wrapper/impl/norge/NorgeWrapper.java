package page.langeweile.wrench_wrapper.impl.norge;

import net.neoforged.fml.loading.FMLPaths;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.api.serializers.TomlSerializer;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import org.quiltmc.config.implementor_api.ConfigFactory;

public class NorgeWrapper {
	@SuppressWarnings("deprecation")
	private static final ConfigEnvironment CONFIG_ENVIRONMENT = new ConfigEnvironment(FMLPaths.CONFIGDIR.get(), TomlSerializer.INSTANCE, TomlSerializer.INSTANCE);

	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return ConfigFactory.create(CONFIG_ENVIRONMENT, family, id, configCreatorClass);
	}

	public static ConfigEnvironment getConfigEnvironment() {
		return NorgeWrapper.CONFIG_ENVIRONMENT;
	}
}
