package com.perritamod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.level.Level;

/**
 * Perrita: se comporta EXACTAMENTE igual que el Lobo vanilla de Minecraft
 * (se puede alimentar con carne, se doma con probabilidad aleatoria,
 * se puede poner correa, etiqueta de nombre, sentar/pararse, atacar
 * a mobs hostiles cuando está domesticada, teleportarse al dueño, etc.)
 * porque extiende directamente la clase Wolf.
 *
 * Solo se le da su propio EntityType para que tenga un modelo/textura
 * independiente y no reemplace al lobo original.
 */
public class PerritaEntity extends Wolf {

    public PerritaEntity(EntityType<? extends Wolf> entityType, Level level) {
        super(entityType, level);
    }

    // Si en el futuro quieres que NO herede exactamente el mismo modelo 3D
    // del lobo (por ejemplo si le diseñas una malla distinta en Blockbench),
    // solo tendrías que sobreescribir aquí el método del modelo/renderer.
    // Toda la lógica de domesticar/alimentar/atacar/sentarse ya viene gratis
    // de la clase Wolf, así que no hace falta tocar nada más.
}
