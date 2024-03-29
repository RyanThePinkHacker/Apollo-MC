package com.thepinkhacker.apollo.client.render.entity;

import com.thepinkhacker.apollo.entity.ApolloEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public abstract class ApolloEntityRenderers {
    public static void register() {
        EntityRendererRegistry.register(ApolloEntityTypes.METEORITE, MeteoriteEntityRenderer::new);
        EntityRendererRegistry.register(ApolloEntityTypes.SHUTTLE, ShuttleEntityRenderer::new);
    }
}
