package anmao.idoll.nekoweapon.item.sword.moye;

import anmao.idoll.nekoweapon.Config;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MoYe extends SwordItem {
    public MoYe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pAttacker.level().isClientSide) {
            if (pAttacker.getOffhandItem().getItem() == Weapon.GAN_JIANG.get()) {
                if (_AM.getRandomNumber(1, 100) <= Config.gangjiang_moye_sp) {
                    pTarget.kill();
                }
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.mo_ye.tooltip0"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
