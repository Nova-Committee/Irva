package committee.nova.irva.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Irva.MODID)
public class Irva {
    public static final String MODID = "irva";

    public Irva() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
