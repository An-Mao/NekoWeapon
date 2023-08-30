package anmao.idoll.nekoweapon.item.armor.naturalarmor;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.cap.cooldown.PCDPro;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NaturalArmorEvent {
    private static final String KEY_CD = "NaturalArmorCD";
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static   class  NAE{
        @SubscribeEvent
        public static void onEquipmentChange (LivingEquipmentChangeEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                if (event.getSlot() == EquipmentSlot.CHEST){
                    ItemStack item = event.getFrom();
                    if (item.getItem() == Weapon.NATURAL_ARMOR.get()) {
                        serverPlayer.getAttribute(Attributes.MAX_HEALTH)
                                .setBaseValue(serverPlayer.getMaxHealth() - 10);
                    }
                    item = event.getTo();
                    if (item.getItem() == Weapon.NATURAL_ARMOR.get()) {
                        serverPlayer.getAttribute(Attributes.MAX_HEALTH)
                                .setBaseValue(serverPlayer.getMaxHealth() + 10);
                    }
                    if (serverPlayer.getHealth() > serverPlayer.getMaxHealth()) {
                        serverPlayer.setHealth(serverPlayer.getMaxHealth());
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onServerTick (TickEvent.PlayerTickEvent event){
            if (event.player instanceof ServerPlayer serverPlayer){
                if (event.phase == TickEvent.Phase.END) {
                    if (serverPlayer.getSlot(_AM.CHEST_SLOT).get().getItem() == Weapon.NATURAL_ARMOR.get()) {
                        serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                            if (!playerCD.isData(KEY_CD)){
                                playerCD.setData(KEY_CD,60);
                                serverPlayer.heal(serverPlayer.getMaxHealth() * 0.1f);
                            }
                        });
                    }
                }
            }
        }
    }
}
