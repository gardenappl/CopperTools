package com.goldenapple.coppertools.init;

import com.goldenapple.coppertools.handler.GeneralConfigHandler;
import com.goldenapple.coppertools.util.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import pneumaticCraft.api.item.ItemSupplier;

public class Recipes {
    public static void init(){
        if (GeneralConfigHandler.loadSaber){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.woodSaber),
                " i ",
                " i ",
                " s ", 'i', "logWood", 's', "stickWood"));
        }

        GameRegistry.addRecipe(new ItemStack(ModItems.obsidianRod),
                "o  ",
                "o  ",
                "   ", 'o', Blocks.obsidian);

        //useObsidian is false temporairly. I've got some eevil plans for config files >:D
        RegisterOreToolRecipes("copper", "ingotCopper", false);
        RegisterOreToolRecipes("platinum", "ingotPlatinum", false);
        RegisterToolRecipes("compressed", new ItemStack(ItemSupplier.getItem("ingotIronCompressed")), false);
    }

    //For tools that use the Ore Dictionary
    public static void RegisterOreToolRecipes(String matName, String material, boolean useObsidian){
        //Register pickaxe
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_pickaxe")),
                "iii",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        //Register sword
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sword")),
                " i ",
                " i ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        //You get the deal
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                "ii ",
                "is ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                " ii",
                " si",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                " ii",
                " si",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_shovel")),
                " i ",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                " ii",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii ",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        //Now the armor
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_helmet")),
                "iii",
                "i i",
                "   ", 'i', material));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_chestplate")),
                "i i",
                "iii",
                "iii", 'i', material));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_leggings")),
                "iii",
                "i i",
                "i i", 'i', material));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_boots")),
                "   ",
                "i i",
                "i i", 'i', material));
    }

    //And again, but this time for specific ItemStacks as materials
    public static void RegisterToolRecipes(String matName, ItemStack material, boolean useObsidian){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_pickaxe")),
                "iii",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));



        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_sword")),
                " i ",
                " i ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));



        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                "ii ",
                "is ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                " ii",
                " si",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_axe")),
                " ii",
                " si",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_shovel")),
                " i ",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                " ii",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_hoe")),
                "ii ",
                " s ",
                " s ", 'i', material, 's', useObsidian ? "rodObsidian" : "stickWood"));


        //Now the armor
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_helmet")),
                "iii",
                "i i",
                "   ", 'i', material));


        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_chestplate")),
                "i i",
                "iii",
                "iii", 'i', material));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_leggings")),
                "iii",
                "i i",
                "i i", 'i', material));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry.findItem(Reference.MOD_ID, matName + "_boots")),
                "   ",
                "i i",
                "i i", 'i', material));
    }
}
