package committee.nova.irva.common.util;

import committee.nova.irva.common.Irva;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class TextUtils {
    public static TranslatableComponent prefixWith(String name, KeyType type) {
        return new TranslatableComponent(type.getPrefix() + name + type.getSuffix());
    }

    public static ResourceLocation prefixRl(String id) {
        return new ResourceLocation(prefixColon(id));
    }

    public static String prefixColon(String id) {
        return Irva.MODID + ":" + id;
    }
}
