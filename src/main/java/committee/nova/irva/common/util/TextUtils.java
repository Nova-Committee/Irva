package committee.nova.irva.common.util;

import net.minecraft.network.chat.TranslatableComponent;

public class TextUtils {
    public static TranslatableComponent prefixWith(String name, KeyType type) {
        return new TranslatableComponent(type.getPrefix() + name + type.getSuffix());
    }
}
