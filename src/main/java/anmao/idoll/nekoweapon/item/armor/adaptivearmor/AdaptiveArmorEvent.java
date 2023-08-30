package anmao.idoll.nekoweapon.item.armor.adaptivearmor;

import anmao.idoll.nekoweapon.Config;
import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.cap.cooldown.PCDPro;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class AdaptiveArmorEvent {
    private static final int INDEX_ITEM = 0;
    private static final int INDEX_TIME = 0;
    private static final int CHEST_SLOT = 102;
    private static final String AA_KEY = "invincible";
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class AAE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack chestitemstack = serverPlayer.getSlot(CHEST_SLOT).get();
                if (chestitemstack.getItem() == Weapon.ADAPTIVE_ARMOR.get()){

                    if (isInvincibleTime(serverPlayer,chestitemstack)){
                        serverPlayer.heal(event.getAmount());
                        event.setCanceled(true);
                    }

                    if (!_AM.isPlayerCD(serverPlayer,INDEX_ITEM)) {
                        System.out.println("no cooldown");
                        if (event.getSource().getEntity() instanceof ServerPlayer player && player.getUUID() == serverPlayer.getUUID()) {
                            event.setCanceled(true);
                        } else {
                            float a = serverPlayer.getHealth() * Config.adaptive_armor_rr;
                            if (event.getAmount() > a) {
                                event.setAmount(Math.max(a, Config.adaptive_armor_min_damage));
                            }
                        }
                        return;
                    }
                    System.out.println("1 is cooldown");
                }
            }
        }
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (event.getEntity() instanceof ServerPlayer player){
                ItemStack chestitemstack = player.getSlot(CHEST_SLOT).get();
                Item chestitem = chestitemstack.getItem();
                if (chestitem == Weapon.ADAPTIVE_ARMOR.get()) {
                    player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isTime(INDEX_TIME)){
                            event.setCanceled(true);
                        }else if (playerCD.isCD(INDEX_ITEM)){
                            playerCD.setCD(INDEX_ITEM,Config.adaptive_armor_cooldown);
                            playerCD.setTime(INDEX_TIME,Config.adaptive_armor_span);

                            player.clearFire();
                            player.removeAllEffects();
                            player.setHealth(1.0F);
                            event.setCanceled(true);
                        }
                    });
                    /*
                    if (isInvincibleTime(player, chestitemstack)) {
                        event.setCanceled(true);
                    }else if (!_AM.isPlayerCD(player,ITEM_INDEX)) {
                        System.out.println("Set True");
                        _AM.setPlayerCD(player,ITEM_INDEX,Config.adaptive_armor_cooldown);
                        chestitemstack.getTag().putInt(AA_KEY, player.tickCount);

                        player.clearFire();
                        player.removeAllEffects();
                        player.setHealth(1.0F);
                        event.setCanceled(true);
                    }

                     */
                }
            }
        }
        private static boolean isInvincibleTime(ServerPlayer player,ItemStack itemStack){
            if (itemStack.getTag() == null) {
                return false;
            }
            int startTick = itemStack.getTag().getInt(AA_KEY);
            if (startTick == -1){
                return false;
            }
            System.out.println("player:"+player.tickCount+"read:"+startTick);
            if (
                    player.tickCount < startTick + Config.adaptive_armor_span
                    &&
                    player.tickCount > startTick
            ) {
                return true;
            }
            itemStack.getTag().putInt(AA_KEY,-1);
            return false;
        }


    }
}
