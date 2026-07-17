package com.perritamod.client;

import com.perritamod.PerritaMod;
import com.perritamod.entity.ModEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PerritaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = net.minecraftforge.api.distmarker.Dist.CLIENT)
public class ModClientEvents {

    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.PERRITA.get(), PerritaRenderer::new);
    }

    // Renderer propio: usa el mismo esqueleto 3D del lobo (WolfModel) pero
    // apuntando a NUESTRA textura personalizada en vez de la del lobo vanilla.
    public static class PerritaRenderer extends WolfRenderer {

        private static final ResourceLocation TEXTURE =
                ResourceLocation.fromNamespaceAndPath(PerritaMod.MOD_ID, "textures/entity/perrita/perrita.png");

        public PerritaRenderer(EntityRendererProvider.Context context) {
            super(context);
        }

        @Override
        public ResourceLocation getTextureLocation(net.minecraft.world.entity.animal.wolf.Wolf entity) {
            // Ignoramos el sistema de "variantes" del lobo vanilla y usamos
            // siempre nuestra propia textura para la Perrita.
            return TEXTURE;
        }
    }
}
