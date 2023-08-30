package anmao.idoll.nekoweapon.item.armor.warlord;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Warlord extends ArmorItem {
    public Warlord() {
        super(ArmorMaterials.NETHERITE, Type.CHESTPLATE, new Properties());
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.warlord_armor.tooltip0"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.warlord_armor.tooltip1"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.warlord_armor.tooltip2"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
