package anmao.idoll.nekoweapon.item.armor.stance;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Stance extends ArmorItem {
    public Stance() {
        super(ArmorMaterials.NETHERITE, Type.CHESTPLATE, new Properties());
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.stance_armor.tooltip0"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.stance_armor.tooltip1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
