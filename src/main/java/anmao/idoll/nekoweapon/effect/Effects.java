package anmao.idoll.nekoweapon.effect;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.effect.evilcreature.EvilCreature;
import anmao.idoll.nekoweapon.effect.yanling.YanLing;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Effects {
    public static DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NekoWeapon.MODID);
    public static RegistryObject<MobEffect> YAN_LING = EFFECTS.register("yan_ling", YanLing::new);
    public static RegistryObject<MobEffect> EVIL_CREATURE = EFFECTS.register("evil_creature", EvilCreature::new);

    public static void register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }
}
