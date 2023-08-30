package anmao.idoll.nekoweapon.effect.yanling;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.effect.Effects;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class YanLingEvent {
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class YLE{
        @SubscribeEvent
        public static void onAttack(LivingAttackEvent event){
            if (event.getEntity().level().isClientSide){
                return;
            }
            if (event.getEntity().hasEffect(Effects.YAN_LING.get())){
                event.setCanceled(true);
            }
        }
    }
}
