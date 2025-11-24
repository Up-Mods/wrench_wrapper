package page.langeweile.wrench_wrapper.api;

import org.jspecify.annotations.NonNull;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import page.langeweile.wrench_wrapper.impl.forge.NorgeWrapper;

public class WrenchWrapper {
	@NonNull
	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return NorgeWrapper.create(family, id, configCreatorClass);
	}

	@NonNull
	public static ConfigEnvironment getConfigEnvironment() {
		return NorgeWrapper.getConfigEnvironment();
	}
}
