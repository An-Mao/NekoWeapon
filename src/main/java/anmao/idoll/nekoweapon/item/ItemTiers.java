package anmao.idoll.nekoweapon.item;

import anmao.idoll.nekoweapon.NekoWeapon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ItemTiers {
    public static final Tier SWORD_OF_JUDGMENT = TierSortingRegistry.registerTier(
            new ForgeTier(9,9999,9,9,99, Tags.Blocks.NEEDS_NETHERITE_TOOL, ()->Ingredient.EMPTY),
            new ResourceLocation(NekoWeapon.MODID,"sowrd_of_judgment"), List.of(Tiers.NETHERITE),List.of()
    );
}
