package anmao.idoll.nekoweapon.item;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.item.sword.judgment.SwordOfJudgment;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Weapon {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NekoWeapon.MODID);

    public static RegistryObject<Item> SWORD_OF_JUDGMENT = ITEMS.register("sword_of_judgment",()->new SwordOfJudgment(ItemTiers.SWORD_OF_JUDGMENT,1,1,new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
