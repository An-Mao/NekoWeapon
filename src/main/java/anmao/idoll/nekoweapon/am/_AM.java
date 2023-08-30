package anmao.idoll.nekoweapon.am;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.Collection;

public class _AM {
    public static final int CHEST_SLOT = 102;
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
}
