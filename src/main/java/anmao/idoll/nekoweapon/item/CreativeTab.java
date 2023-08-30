package anmao.idoll.nekoweapon.item;

import anmao.idoll.nekoweapon.NekoWeapon;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NekoWeapon.MODID);

    public static RegistryObject<CreativeModeTab> NEKO_WEAPON = CREATIVE_TAB.register("neko_weapon_tab",()-> CreativeModeTab.builder()
            .icon(()->new ItemStack(Weapon.YELLOW_FU.get()))
            .title(Component.translatable("creativetab.neko_weapon_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(Weapon.SWORD_OF_JUDGMENT.get());
                pOutput.accept(Weapon.ANGEL_SWORD.get());
                pOutput.accept(Weapon.GAN_JIANG.get());
                pOutput.accept(Weapon.MO_YE.get());
                pOutput.accept(Weapon.DEATH_SICKLE.get());
                pOutput.accept(Weapon.CROSS.get());
                pOutput.accept(Weapon.ZEN_STICK.get());
                pOutput.accept(Weapon.MAHOGANY_SWORD.get());
                pOutput.accept(Weapon.YELLOW_FU.get());

                pOutput.accept(Weapon.ADAPTIVE_ARMOR.get());
                pOutput.accept(Weapon.NATURAL_ARMOR.get());
                pOutput.accept(Weapon.RED_LOTUS_ARMOR.get());
                pOutput.accept(Weapon.STANCE_ARMOR.get());
                pOutput.accept(Weapon.WARLORD_ARMOR.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_TAB.register(eventBus);
    }
}
