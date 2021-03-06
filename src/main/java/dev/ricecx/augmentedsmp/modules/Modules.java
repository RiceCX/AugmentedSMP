package dev.ricecx.augmentedsmp.modules;

import dev.ricecx.augmentedsmp.core.module.AbstractModule;
import dev.ricecx.augmentedsmp.modules.ambientparticles.AmbientParticleModule;
import dev.ricecx.augmentedsmp.modules.bedhealing.BedHealingModule;
import dev.ricecx.augmentedsmp.modules.biometitles.BiomeTitleModule;
import dev.ricecx.augmentedsmp.modules.customcrafts.CustomCraftsModule;
import dev.ricecx.augmentedsmp.modules.toolmaintenance.ToolMaintenanceModule;
import dev.ricecx.augmentedsmp.modules.experiencemultiplier.XPMultiplierModule;
import dev.ricecx.augmentedsmp.modules.foodbuff.FoodBuffModule;
import dev.ricecx.augmentedsmp.modules.inventorydeath.InventoryDeathModule;
import dev.ricecx.augmentedsmp.modules.joinevents.JoinEventsModule;
import dev.ricecx.augmentedsmp.modules.leveling.LevelingModule;
import dev.ricecx.augmentedsmp.modules.supplydrops.SupplyDropModule;
import dev.ricecx.augmentedsmp.modules.timeskip.TimeSkipModule;

public enum Modules {
    LEVELING(new LevelingModule()),
    INVENTORY_DEATH(new InventoryDeathModule()),
    BED_HEALING(new BedHealingModule()),
    FOOD_BUFF(new FoodBuffModule()),
    XP_MULTIPLIER(new XPMultiplierModule()),
    CUSTOM_CRAFTS(new CustomCraftsModule()),
    SUPPLY_DROPS(new SupplyDropModule()),
    JOIN_EVENTS(new JoinEventsModule()),
    TIME_SKIP(new TimeSkipModule()),
    BIOME_TITLES(new BiomeTitleModule()),
    TOOL_MAINTENANCE(new ToolMaintenanceModule()),
    AMBIENT_PARTICLES(new AmbientParticleModule())
    ;

    private static final Modules[] CACHE = values();

    private final AbstractModule module;

    Modules(AbstractModule module) {
        this.module = module;
    }

    public static void loadModules() {
        for (Modules module : CACHE) {
            module.getModule().poke();
        }
    }


    public static <T extends AbstractModule> T getModule(Class<T> clazz) {
        T module = null;
        for (Modules moduleEnum : CACHE) {
            if(clazz.isInstance(moduleEnum.getModule())) {
                module = clazz.cast(moduleEnum.getModule());
                break;
            }
        }

        return module;
    }

    public AbstractModule getModule() {
        return module;
    }
}
