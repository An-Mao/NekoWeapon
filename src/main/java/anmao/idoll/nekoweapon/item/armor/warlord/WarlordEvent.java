package anmao.idoll.nekoweapon.item.armor.warlord;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.cap.cooldown.PCDPro;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class WarlordEvent {

    private static final String KEY_CD = "WarlordArmorCD";
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class WE {
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(_AM.CHEST_SLOT).get();
                if (item.getItem() == Weapon.WARLORD_ARMOR.get()) {
                    serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (!playerCD.isData(KEY_CD)){
                            System.out.println("health:"+serverPlayer.getHealth());
                            if (serverPlayer.getHealth() == serverPlayer.getMaxHealth()) {
                                playerCD.setData(KEY_CD,2000);
                                serverPlayer.setHealth(3.0f);
                                event.setCanceled(true);
                            }
                        }
                    });
                }
            }
        }
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(_AM.CHEST_SLOT).get();
                if (item.getItem() == Weapon.WARLORD_ARMOR.get()){
                    float sp = 2.0F  - serverPlayer.getHealth() / serverPlayer.getMaxHealth();
                    event.setAmount(event.getAmount() * Math.min(sp,1.75f));
                }
            }
            if (event.getEntity() instanceof ServerPlayer Player) {
                ItemStack oitem =  Player.getSlot(_AM.CHEST_SLOT).get();
                if (oitem.getItem() == Weapon.WARLORD_ARMOR.get()){
                    event.setAmount(event.getAmount() * 1.3F);
                }
            }
        }
    }
}
