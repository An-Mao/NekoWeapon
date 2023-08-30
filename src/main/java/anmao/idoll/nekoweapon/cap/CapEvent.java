package anmao.idoll.nekoweapon.cap;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.cap.cooldown.PCDPro;
import anmao.idoll.nekoweapon.cap.cooldown.PlayerCooldown;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

public class CapEvent {
    @Mod.EventBusSubscriber(modid = NekoWeapon.MODID)
    public static class CE{

        @SubscribeEvent
        public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
        {
            event.register(PlayerCooldown.class);
        }
        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event)
        {
            if (event.getObject() instanceof Player)
            {
                if (!event.getObject().getCapability(PCDPro.P_I_CD).isPresent())
                {
                    event.addCapability(new ResourceLocation(NekoWeapon.MODID,"properties"),new PCDPro());
                }
            }
        }
        @SubscribeEvent
        public static void onPlayerCloned(PlayerEvent.Clone event)
        {
            if (event.getEntity() instanceof ServerPlayer player) {
                //if (event.isWasDeath()) {}
                event.getOriginal().reviveCaps();
                event.getEntity().getCapability(PCDPro.P_I_CD).ifPresent(newDat -> {
                    event.getOriginal().getCapability(PCDPro.P_I_CD).ifPresent(newDat::copyFrom);
                });

            }
        }
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event)
        {
            if (event.side == LogicalSide.SERVER) {
                if (event.player instanceof ServerPlayer serverPlayer) {
                    if (event.phase == TickEvent.Phase.END) {
                        serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(PlayerCooldown::subCD);
                    }
                }
            }
        }
    }
}
