package anmao.idoll.nekoweapon.item.sword.zenstick;

import anmao.idoll.nekoweapon.effect.Effects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZenStick extends SwordItem {
    private static final MobEffectInstance YanLing = new MobEffectInstance(Effects.YAN_LING.get(),1,200);
    public ZenStick(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pAttacker.level().isClientSide){
            if (pTarget.getMobType() == MobType.UNDEAD){
                int i = 1;
                for (;i < 18 ;i++){
                    String tag = "chaodulv"+i;
                    if (!pTarget.getTags().contains(tag)){
                        pTarget.addTag(tag);
                        break;
                    }
                }
                System.out.println("i"+i);
                if (i == 17){
                    pTarget.kill();
                }
            }else {
                pTarget.addEffect(YanLing);
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.zen_stick.tooltip0"));
        pTooltipComponents.add(Component.translatable("tooltip.nekoweapon.zen_stick.tooltip1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
