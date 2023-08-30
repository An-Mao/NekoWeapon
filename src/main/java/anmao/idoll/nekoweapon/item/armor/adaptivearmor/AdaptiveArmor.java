package anmao.idoll.nekoweapon.item.armor.adaptivearmor;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdaptiveArmor extends ArmorItem {
    public AdaptiveArmor() {
        //ArmorMaterial pMaterial
        super(ArmorMaterials.NETHERITE, Type.CHESTPLATE, new Properties());
    }

    @Override
    public int getEnchantmentValue() {
        return super.getEnchantmentValue() + 99;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.adaptive_armor.tooltip0"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.adaptive_armor.tooltip1"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.adaptive_armor.tooltip2"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
