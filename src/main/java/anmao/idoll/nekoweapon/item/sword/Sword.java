package anmao.idoll.nekoweapon.item.sword;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class Sword extends SwordItem {
    public static final Properties itempro = new Properties();
    public Sword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

}
