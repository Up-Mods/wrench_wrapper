package page.langeweile.wrench_wrapper.api;

import net.fabricmc.loader.api.FabricLoader;
import org.jspecify.annotations.NonNull;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import page.langeweile.wrench_wrapper.impl.fabric.FabricWrapper;
import page.langeweile.wrench_wrapper.impl.quilt.QuiltWrapper;

public class WrenchWrapper {
	@NonNull
	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		if (FabricLoader.getInstance().isModLoaded("quilt_loader")) {
			return QuiltWrapper.create(family, id, configCreatorClass);
		} else {
			return FabricWrapper.create(family, id, configCreatorClass);
		}
	}

	public static ConfigEnvironment getConfigEnvironment() {
		if (FabricLoader.getInstance().isModLoaded("quilt_loader")) {
			return QuiltWrapper.getConfigEnvironment();
		} else {
			return FabricWrapper.getConfigEnvironment();
		}
	}
}
