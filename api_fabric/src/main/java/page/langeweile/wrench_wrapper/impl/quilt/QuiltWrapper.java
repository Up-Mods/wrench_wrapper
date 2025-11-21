package page.langeweile.wrench_wrapper.impl.quilt;

import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import org.quiltmc.loader.api.config.v2.QuiltConfig;
import org.quiltmc.loader.impl.config.QuiltConfigImpl;

public class QuiltWrapper {
	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return QuiltConfig.create(family, id, configCreatorClass, builder -> builder.format("json5"));
	}

	public static ConfigEnvironment getConfigEnvironment() {
		return QuiltConfigImpl.getConfigEnvironment();
	}
}
