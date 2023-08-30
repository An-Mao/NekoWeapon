package anmao.idoll.nekoweapon.am;

import anmao.idoll.nekoweapon.cap.cooldown.PCDPro;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

public class _AM {
    public static double getAdddamage(Collection<AttributeModifier> attlist) {
        double dadd = 0;
        double dbase = 0;
        double dtotal = 1;
        for (AttributeModifier al : attlist) {
            if(al.getOperation() == AttributeModifier.Operation.ADDITION){
                dadd += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE) {
                dbase += al.getAmount();
            } else if (al.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
                dtotal *= 1.0D + al.getAmount();
            }
        }
        return (dadd + dadd * dbase) * dtotal;
    }
    public static int getRandomNumber(int min ,int max){
        return RandomSource.createNewThreadLocalInstance().nextInt(min,max);
        //Random random = new Random();
        //return random.nextInt(max) % (max - min + 1) + min;
    }
    public static void setPlayerCD(ServerPlayer player,int itemIndex,int cooldown){
        player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
            playerCD.setCD(itemIndex,cooldown);
        });
    }
    public static boolean isPlayerCD(ServerPlayer player,int itemIndex){
        AtomicBoolean isCD = new AtomicBoolean(false);
        player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
            isCD.set(playerCD.isCD(itemIndex));
        });
        return isCD.get();
    }
    public static void setPlayerItemTime(ServerPlayer player,int itemIndex,int cooldown){
        player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
            playerCD.setTime(itemIndex,cooldown);
        });
    }
    public static boolean isPlayerItemTime(ServerPlayer player,int itemIndex){
        AtomicBoolean isCD = new AtomicBoolean(false);
        player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
            isCD.set(playerCD.isCD(itemIndex));
        });
        return isCD.get();
    }
}
