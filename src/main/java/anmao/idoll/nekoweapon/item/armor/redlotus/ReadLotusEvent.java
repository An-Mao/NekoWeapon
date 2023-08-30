package anmao.idoll.nekoweapon.item.armor.redlotus;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.am._AM;
import anmao.idoll.nekoweapon.effect.Effects;
import anmao.idoll.nekoweapon.item.Weapon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ReadLotusEvent {
    private static final MobEffectInstance EvilCreature = new MobEffectInstance(Effects.EVIL_CREATURE.get(),1,20);
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class RLE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                if (serverPlayer.getSlot(_AM.CHEST_SLOT).get().getItem() == Weapon.RED_LOTUS_ARMOR.get()){
                    if (event.getSource().getEntity() instanceof LivingEntity livingEntity){
                        livingEntity.hurt(serverPlayer.damageSources().fellOutOfWorld(),event.getAmount()* 0.5f);
                        livingEntity.addEffect(EvilCreature);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onDamage(LivingDamageEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item = serverPlayer.getSlot(_AM.CHEST_SLOT).get();
                if (item.getItem() == Weapon.RED_LOTUS_ARMOR.get()){
                    if (event.getSource().getEntity() instanceof LivingEntity livingEntity){
                        if (livingEntity.hasEffect(Effects.EVIL_CREATURE.get())){
                            item.setDamageValue(Math.min(item.getDamageValue()+1,item.getMaxDamage()));
                        }
                    }
                }
            }
        }
    }
}
