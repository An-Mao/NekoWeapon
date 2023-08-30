package anmao.idoll.nekoweapon.item.armor.warlord;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class WarlordEvent {
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class WE {
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){

                ItemStack item =  serverPlayer.getSlot(EquipmentSlot.CHEST.getIndex()).get();
                if (item.getItem() == Weapon.WARLORD_ARMOR.get()) {
                    if (!serverPlayer.getCooldowns().isOnCooldown(item.getItem())) {
                        serverPlayer.getCooldowns().addCooldown(item.getItem(),2000);
                        if (serverPlayer.getHealth() == serverPlayer.getMaxHealth()) {
                            serverPlayer.setHealth(3.0f);
                            event.setCanceled(true);
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(EquipmentSlot.CHEST.getIndex()).get();
                if (item.getItem() == Weapon.WARLORD_ARMOR.get()){
                    float sp = 2.0F  - serverPlayer.getHealth() / serverPlayer.getMaxHealth();
                    event.setAmount(event.getAmount() * Math.min(sp,1.75f));
                }
            }
            if (event.getEntity() instanceof ServerPlayer Player) {
                ItemStack oitem =  Player.getSlot(EquipmentSlot.CHEST.getIndex()).get();
                if (oitem.getItem() == Weapon.WARLORD_ARMOR.get()){
                    event.setAmount(event.getAmount() * 1.3F);
                }
            }
        }
    }
}
