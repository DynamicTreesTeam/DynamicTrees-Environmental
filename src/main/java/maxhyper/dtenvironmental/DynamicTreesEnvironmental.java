package maxhyper.dtenvironmental;

import com.ferreusveritas.dynamictrees.api.GatherDataHelper;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import com.ferreusveritas.dynamictrees.blocks.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.blocks.rootyblocks.SoilProperties;
import com.ferreusveritas.dynamictrees.trees.Family;
import com.ferreusveritas.dynamictrees.trees.Species;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DynamicTreesEnvironmental.MOD_ID)
public class DynamicTreesEnvironmental
{
    public static final String MOD_ID = "dtenvironmental";

    public DynamicTreesEnvironmental() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::gatherData);

        MinecraftForge.EVENT_BUS.register(this);

        RegistryHandler.setup(MOD_ID);

        DTEnvironmentalRegistries.setup();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
//    if (DTConfigs.WORLD_GEN.get()){
//        //UAConfig.COMMON.riverTreeGeneration.set(false);
//
//        //Temporal very crude way of disabling banana plant features.
//        clearConfiguredFeature(UAFeatures.Configured.RIVER_TREE);
//    }
    }

//    //disgusting code, do not look or risk retinal damage.
//    @SuppressWarnings("unchecked")
//    private void clearConfiguredFeature (ConfiguredFeature<?,?> configuredFeature){
//        Feature<NoFeatureConfig> nullFeature = new Feature<NoFeatureConfig>(NoFeatureConfig.CODEC){
//            @Override public boolean place(@Nonnull ISeedReader p_241855_1_, @Nonnull ChunkGenerator p_241855_2_, @Nonnull Random p_241855_3_, @Nonnull BlockPos p_241855_4_, @Nonnull  NoFeatureConfig p_241855_5_) { return false; }
//        };
//        ConfiguredFeature<NoFeatureConfig,Feature<NoFeatureConfig>> castedConfigured = (ConfiguredFeature<NoFeatureConfig,Feature<NoFeatureConfig>>)configuredFeature;
//        castedConfigured.feature = nullFeature;
//        castedConfigured.config = NoFeatureConfig.INSTANCE;
//    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    public void gatherData(final GatherDataEvent event) {
        GatherDataHelper.gatherAllData(
                MOD_ID,
                event,
                SoilProperties.REGISTRY,
                Family.REGISTRY,
                Species.REGISTRY,
                LeavesProperties.REGISTRY
        );;
    }

}
