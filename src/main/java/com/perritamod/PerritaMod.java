package com.perritamod;

import com.perritamod.entity.ModEntities;
import com.perritamod.entity.PerritaEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(PerritaMod.MOD_ID)
public class PerritaMod {

    public static final String MOD_ID = "perritamod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public PerritaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registrar la entidad y el item (huevo de generación)
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModEntities.ITEMS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerAttributes);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Perrita Mod cargado correctamente!");
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        // Reutilizamos los mismos atributos base que el lobo vanilla
        event.put(ModEntities.PERRITA.get(), Wolf.createAttributes().build());
    }
}
