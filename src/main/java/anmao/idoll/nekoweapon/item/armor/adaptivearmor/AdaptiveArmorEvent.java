package anmao.idoll.nekoweapon.item.armor.adaptivearmor;

import anmao.idoll.nekoweapon.Config;
import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.cap.cooldown.PCDPro;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class AdaptiveArmorEvent {
    private static final String INDEX_ITEM = "AdaptiveArmorCD";
    private static final String INDEX_TIME = "AdaptiveArmorTime";
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class AAE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                if (serverPlayer.getSlot(_AM.CHEST_SLOT).get().getItem() == Weapon.ADAPTIVE_ARMOR.get()){
                    serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isData(INDEX_TIME)) {
                            serverPlayer.heal(event.getAmount());
                            event.setCanceled(true);
                        }else if (!playerCD.isData(INDEX_ITEM)){
                            if (event.getSource().getEntity() instanceof ServerPlayer player && player.getUUID() == serverPlayer.getUUID()) {
                                event.setCanceled(true);
                            } else {
                                float a = serverPlayer.getHealth() * Config.adaptive_armor_rr;
                                if (event.getAmount() > a) {
                                    event.setAmount(Math.max(a, Config.adaptive_armor_min_damage));
                                }
                            }
                        }
                    });
                }
            }
        }
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (event.getEntity() instanceof ServerPlayer player){
                if (player.getSlot(_AM.CHEST_SLOT).get().getItem() == Weapon.ADAPTIVE_ARMOR.get()) {
                    player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isData(INDEX_TIME)){
                            event.setCanceled(true);
                        }else if (!playerCD.isData(INDEX_ITEM)){
                            playerCD.setData(INDEX_ITEM,Config.adaptive_armor_cooldown);
                            playerCD.setData(INDEX_TIME,Config.adaptive_armor_span);
                            player.clearFire();
                            player.removeAllEffects();
                            player.setHealth(1.0F);
                            event.setCanceled(true);
                        }
                    });
                }
            }
        }
    }
}
