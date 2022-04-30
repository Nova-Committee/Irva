package committee.nova.irva.common.playerData.capabilities.properties;

import committee.nova.irva.common.playerData.capabilities.properties.api.IBelief;
import committee.nova.irva.common.util.KeyType;
import committee.nova.irva.common.util.TextUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

import static committee.nova.irva.common.util.StringReference.NBT_BELIEF;

public enum Belief implements IBelief {
    NONE(0, "none"),
    MANI(1, "mani"),
    LULWY(2, "lulwy"),
    ITZPALT(3, "itzpalt"),
    KUMIROMI(4, "kumiromi"),
    OPATOS(5, "opatos"),
    EHEKATL(6, "ehekatl"),
    JURE(7, "jure"),
    EYTH(8, "eyth");

    private final int id;
    private final Component name;
    private final Component attribute;

    Belief(int id, String name) {
        this.id = id;
        this.name = TextUtils.prefixWith(name, KeyType.BELIEF_NAME);
        this.attribute = TextUtils.prefixWith(name, KeyType.BELIEF_ATTRIBUTE);
    }

    public static Belief deserialize(CompoundTag tag) {
        final int idGot = tag.getInt(NBT_BELIEF);
        for (final Belief b : Belief.values()) {
            if (b.id == idGot) return b;
        }
        return Belief.NONE;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Component getName() {
        return name;
    }

    @Override
    public Component getAttribute() {
        return attribute;
    }

    @Override
    public void serialize(CompoundTag tag) {
        tag.putInt(NBT_BELIEF, id);
    }
}
