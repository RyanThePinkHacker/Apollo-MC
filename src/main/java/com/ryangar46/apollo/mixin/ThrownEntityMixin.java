package com.ryangar46.apollo.mixin;

import com.ryangar46.apollo.entity.GravityManager;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ThrownEntity.class)
public abstract class ThrownEntityMixin {
    @Inject(
            method = "getGravity()F",
            at = @At("RETURN"),
            cancellable = true
    )
    private void getGravity(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(cir.getReturnValue() * (float)GravityManager.getGravityMultiplier(((ThrownEntity)(Object)this).world));
    }
}
