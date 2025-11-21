package page.langeweile.wrench_wrapper.impl.quilt;

import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.api.serializers.Json5Serializer;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import org.quiltmc.config.implementor_api.ConfigFactory;
import org.quiltmc.loader.api.QuiltLoader;

public class QuiltWrapper {
	private static final ConfigEnvironment CONFIG_ENVIRONMENT = new ConfigEnvironment(QuiltLoader.getConfigDir(), Json5Serializer.INSTANCE, Json5Serializer.INSTANCE);

	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return ConfigFactory.create(CONFIG_ENVIRONMENT, family, id, configCreatorClass);
	}

	public static ConfigEnvironment getConfigEnvironment() {
		return CONFIG_ENVIRONMENT;
	}
}
