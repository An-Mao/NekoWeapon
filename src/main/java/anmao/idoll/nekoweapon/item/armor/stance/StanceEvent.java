package anmao.idoll.nekoweapon.item.armor.stance;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class StanceEvent {
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class SE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(_AM.CHEST_SLOT).get();
                if (item.getItem() == Weapon.STANCE_ARMOR.get()){
                    if (event.getSource().getEntity() != null) {
                        double dis = serverPlayer.getEyePosition().distanceTo(event.getSource().getEntity().getEyePosition());
                        if (dis > getPlayerAtkRange(serverPlayer)){
                            event.setAmount(event.getAmount() * 0.8F);
                        }else {
                            event.setAmount(event.getAmount() * 1.7F);
                        }
                    }
                }
            }
        }
        public static double getPlayerAtkRange(ServerPlayer serverPlayer){
            Attribute atkAtt = ForgeMod.ENTITY_REACH.get();
            double atkRange = serverPlayer.getAttributeBaseValue(atkAtt);
            atkRange += serverPlayer.getAttributeValue(atkAtt);

            return atkRange;
        }
    }
}
