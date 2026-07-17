package com.perritamod.entity;

import com.perritamod.PerritaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.DeferredSpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredHolder;
import net.minecraftforge.registries.DeferredRegister;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PerritaMod.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, PerritaMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<PerritaEntity>> PERRITA =
            ENTITY_TYPES.register("perrita",
                    () -> EntityType.Builder.of(PerritaEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 0.85F)
                            .clientTrackingRange(10)
                            .build("perrita"));

    // Huevo de generación para poder invocarla con /summon o desde el inventario creativo
    public static final DeferredHolder<Item, Item> PERRITA_SPAWN_EGG =
            ITEMS.register("perrita_spawn_egg",
                    () -> new DeferredSpawnEggItem(PERRITA::get, 0xC7A76C, 0x1B1B1B,
                            new Item.Properties()));
}
