package blck.techdimension;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(TechDimensionMod.MODID)
@Mod.EventBusSubscriber(modid = TechDimensionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TechDimensionMod {
    public static final String MODID = "techdimension";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public TechDimensionMod() {
        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Register commands
        Command.register(event.getServer().getCommands().getDispatcher());
    }
}
