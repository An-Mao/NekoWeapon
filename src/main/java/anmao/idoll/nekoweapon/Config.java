package anmao.idoll.nekoweapon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.checkerframework.checker.units.qual.A;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = NekoWeapon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue GANJIANG_MOYE_SP = BUILDER
            .comment("GanJiang/MoYe Spike Probability")
            .defineInRange("ganjiang_moye_sp", 5, 0, 100);
    private static final ForgeConfigSpec.IntValue VILLAGE_ADD_DAMAGE = BUILDER
            .comment("Village Additional damage")
            .defineInRange("village_add_damage", 99, 0, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.DoubleValue ADAPTIVE_ARMOR_RR = BUILDER
            .comment("adaptive armor reduction ratio")
            .defineInRange("adaptive_armor_rr", 0.35, 0, 1.0);

    private static final ForgeConfigSpec.IntValue ADAPTIVE_ARMOR_SPAN = BUILDER
            .comment("adaptive armor span (s*10)")
            .defineInRange("adaptive_armor_span", 600, 0, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue ADAPTIVE_ARMOR_COOLDOWN = BUILDER
            .comment("adaptive armor cooldown (tick)")
            .defineInRange("adaptive_armor_cooldown", 3000, 0, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue ADAPTIVE_ARMOR_MIN_DAMAGE = BUILDER
            .comment("adaptive armor min damage")
            .defineInRange("adaptive_armor_min_damage", 3, 0, Integer.MAX_VALUE);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int gangjiang_moye_sp;
    public static int village_add_damage;

    public static float adaptive_armor_rr;
    public static int adaptive_armor_span;
    public static int adaptive_armor_cooldown;
    public static int adaptive_armor_min_damage;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        gangjiang_moye_sp = GANJIANG_MOYE_SP.get();
        village_add_damage = VILLAGE_ADD_DAMAGE.get();
        adaptive_armor_rr = ADAPTIVE_ARMOR_RR.get().floatValue();
        adaptive_armor_span = ADAPTIVE_ARMOR_SPAN.get();
        adaptive_armor_cooldown = ADAPTIVE_ARMOR_COOLDOWN.get();
        adaptive_armor_min_damage = ADAPTIVE_ARMOR_MIN_DAMAGE.get();
    }
}
