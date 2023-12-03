package maxhyper.dtenvironmental;

import com.ferreusveritas.dynamictrees.api.cells.CellKit;
import com.ferreusveritas.dynamictrees.api.worldgen.BiomePropertySelectors;
import com.ferreusveritas.dynamictrees.api.worldgen.FeatureCanceller;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class DTEnvironmentalRegistries {

//    public static FruitBlock MULBERRY_FRUIT = new FruitBlock(){
//        @Override
//        protected int fruitDropCount(BlockState state, World world, BlockPos pos) {
//            return 1 + world.getRandom().nextInt(2);
//        }
//    }
//            .setShape(0, ShapeUtils.createFruitShape(1,1,0, 16))
//            .setShape(1, ShapeUtils.createFruitShape(2,3,0, 20))
//            .setShape(2, ShapeUtils.createFruitShape(3.3f,6,1, 20))
//            .setShape(3, ShapeUtils.createFruitShape(3.3f,6,2, 20))
//            .setCanBoneMeal(DTConfigs.CAN_BONE_MEAL_APPLE::get);

    public static void setup() {
//        RegistryHandler.addBlock(new ResourceLocation(DynamicTreesAtmospheric.MOD_ID, "mulberry_fruit"), MULBERRY_FRUIT);
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
//        Item fruitItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("upgrade_aquatic","mulberry"));
//        MULBERRY_FRUIT.setDroppedItem(new ItemStack(fruitItem));
//        final Species treeSpecies = Species.REGISTRY.get(new ResourceLocation(DynamicTreesAtmospheric.MOD_ID, "mulberry"));
//        if (treeSpecies.isValid())
//            MULBERRY_FRUIT.setSpecies(treeSpecies);
    }

    @SubscribeEvent
    public static void onCellKitRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<CellKit> event) {
//        DTUpgradeAquaticCellKits.register(event.getRegistry());

    }
    public static final FeatureCanceller FRUIT_TREES_CANCELLER = new FeatureCanceller(new ResourceLocation(DynamicTreesEnvironmental.MOD_ID, "entree")) {
        @Override
        public boolean shouldCancel(ConfiguredFeature<?, ?> configuredFeature, BiomePropertySelectors.FeatureCancellations featureCancellations) {
            // Note it not in ForgeRegistries.FEATURES
            final ResourceLocation featureName = WorldGenRegistries.CONFIGURED_FEATURE.getKey(configuredFeature);
            if (featureName == null) {
                return false;
            }
            DynamicTreesEnvironmental.LOGGER.debug(((WorldGenRegistries.CONFIGURED_FEATURE.getKey(configuredFeature) + "").startsWith("atmospheric:yucca_tree")) + "" + featureName);
            return featureCancellations.shouldCancelNamespace(featureName.getNamespace())
                    && ((WorldGenRegistries.CONFIGURED_FEATURE.getKey(configuredFeature) + "").startsWith("environmental:birch"));
        }

    };

    @SubscribeEvent
    public static void onFeatureCancellerRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<FeatureCanceller> event) {
        event.getRegistry().registerAll(FRUIT_TREES_CANCELLER);
    }
}
