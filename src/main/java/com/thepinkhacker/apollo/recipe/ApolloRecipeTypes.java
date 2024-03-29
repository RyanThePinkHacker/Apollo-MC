package com.thepinkhacker.apollo.recipe;

import com.thepinkhacker.apollo.Apollo;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ApolloRecipeTypes {
    public static final RecipeType<ShuttleWorkbenchRecipe> SHUTTLE_WORKBENCH_RECIPE_TYPE = registerType("shuttle_workbench");
    public static final RecipeSerializer<ShuttleWorkbenchShapedRecipe> SHUTTLE_WORKBENCH_SHAPED_SERIALIZER = registerSerializer("shuttle_workbench_shaped", new ShuttleWorkbenchShapedRecipe.Serializer());
    public static final RecipeSerializer<ShuttleWorkbenchShapelessRecipe> SHUTTLE_WORKBENCH_SHAPELESS_SERIALIZER = registerSerializer("shuttle_workbench_shapeless", new ShuttleWorkbenchShapelessRecipe.Serializer());

    // Java is weird and won't init the variables unless this runs
    // Otherwise it would try to init after the registry is frozen
    public static void register() {}

    private static <T extends Recipe<?>> RecipeType<T> registerType(String id) {
        return Registry.register(Registries.RECIPE_TYPE, Apollo.getIdentifier(id), new RecipeType<T>(){
            @Override
            public String toString() {
                return id;
            }
        });
    }

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Apollo.getIdentifier(id), serializer);
    }
}
