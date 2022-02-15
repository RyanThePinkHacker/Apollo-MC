package com.ryangar46.apollo.entity;

import com.ryangar46.apollo.Apollo;
import com.ryangar46.apollo.client.renderer.entity.model.ShuttleModel;
import com.ryangar46.apollo.client.renderer.entity.ShuttleRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityManager {
    public static final EntityModelLayer SHUTTLE_LAYER = new EntityModelLayer(new Identifier(Apollo.MOD_ID, "shuttle"), "main");
    public static final EntityType<ShuttleEntity> SHUTTLE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Apollo.MOD_ID, "shuttle"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ShuttleEntity::new).dimensions(EntityDimensions.fixed(1.75f, 2.5f)).build()
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(SHUTTLE, ShuttleEntity.createMobAttributes());
    }

    public static void registerClient() {
        EntityRendererRegistry.register(SHUTTLE, (context) -> {
            return new ShuttleRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(SHUTTLE_LAYER, ShuttleModel::getTexturedModelData);
    }
}