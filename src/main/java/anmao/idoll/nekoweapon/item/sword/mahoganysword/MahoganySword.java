package anmao.idoll.nekoweapon.item.sword.mahoganysword;

import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MahoganySword extends SwordItem {
    public MahoganySword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pAttacker.level().isClientSide){
            ItemStack offitem = pAttacker.getOffhandItem();
            if (pTarget instanceof Zombie) {
                if (offitem.getItem() == Weapon.YELLOW_FU.get()) {
                    offitem.setCount(offitem.getCount() - 1);
                    pTarget.hurt(pAttacker.damageSources().fellOutOfWorld(),9);
                }
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.mahogany_sword.tooltip0"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
