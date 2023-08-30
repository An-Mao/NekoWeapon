package anmao.idoll.nekoweapon.item.armor.redlotus;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedLotus extends ArmorItem {
    public RedLotus() {
        super(ArmorMaterials.NETHERITE, Type.CHESTPLATE, new Properties());
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.red_lotus_armor.tooltip0"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.red_lotus_armor.tooltip1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
