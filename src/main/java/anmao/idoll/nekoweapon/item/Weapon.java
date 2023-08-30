package anmao.idoll.nekoweapon.item;

import anmao.idoll.nekoweapon.NekoWeapon;
import anmao.idoll.nekoweapon.item.armor.adaptivearmor.AdaptiveArmor;
import anmao.idoll.nekoweapon.item.armor.naturalarmor.NaturalArmor;
import anmao.idoll.nekoweapon.item.armor.redlotus.RedLotus;
import anmao.idoll.nekoweapon.item.armor.stance.Stance;
import anmao.idoll.nekoweapon.item.armor.warlord.Warlord;
import anmao.idoll.nekoweapon.item.sword.angel.AngelSword;
import anmao.idoll.nekoweapon.item.sword.cross.Cross;
import anmao.idoll.nekoweapon.item.sword.deathsickle.DeathSickle;
import anmao.idoll.nekoweapon.item.sword.ganjiang.GanJiang;
import anmao.idoll.nekoweapon.item.sword.judgment.SwordOfJudgment;
import anmao.idoll.nekoweapon.item.sword.mahoganysword.MahoganySword;
import anmao.idoll.nekoweapon.item.sword.moye.MoYe;
import anmao.idoll.nekoweapon.item.sword.zenstick.ZenStick;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Weapon {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NekoWeapon.MODID);

    public static RegistryObject<Item> SWORD_OF_JUDGMENT = ITEMS.register("sword_of_judgment",()->new SwordOfJudgment(ItemTiers.SWORD,10,1,new Item.Properties()));
    public static RegistryObject<Item> ANGEL_SWORD = ITEMS.register("angel_sword",()->new AngelSword(ItemTiers.SWORD,6,2,new Item.Properties()));
    public static RegistryObject<Item> GAN_JIANG = ITEMS.register("gan_jiang",()->new GanJiang(ItemTiers.SWORD,5,2,new Item.Properties()));
    public static RegistryObject<Item> MO_YE = ITEMS.register("mo_ye",()->new MoYe(ItemTiers.SWORD,5,2,new Item.Properties()));
    public static RegistryObject<Item> DEATH_SICKLE = ITEMS.register("death_sickle",()->new DeathSickle(ItemTiers.SWORD,5,2,new Item.Properties()));

    public static RegistryObject<Item> CROSS = ITEMS.register("cross",()->new Cross(ItemTiers.SWORD,5,2,new Item.Properties()));
    public static RegistryObject<Item> ZEN_STICK = ITEMS.register("zen_stick",()->new ZenStick(ItemTiers.SWORD,0,0,new Item.Properties()));

    public static RegistryObject<Item> MAHOGANY_SWORD = ITEMS.register("mahogany_sword",()->new MahoganySword(ItemTiers.SWORD,8,0,new Item.Properties()));
    public static RegistryObject<Item> YELLOW_FU = ITEMS.register("yellow_fu",()->new Item(new Item.Properties()));


    public static RegistryObject<Item> ADAPTIVE_ARMOR = ITEMS.register("adaptive_armor", AdaptiveArmor::new);
    public static RegistryObject<Item> NATURAL_ARMOR = ITEMS.register("natural_armor", NaturalArmor::new);
    public static RegistryObject<Item> RED_LOTUS_ARMOR = ITEMS.register("red_lotus_armor", RedLotus::new);
    public static RegistryObject<Item> STANCE_ARMOR = ITEMS.register("stance_armor", Stance::new);
    public static RegistryObject<Item> WARLORD_ARMOR = ITEMS.register("warlord_armor", Warlord::new);



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
