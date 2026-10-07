package me.figgnus.slimefunaddon;


import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import java.util.ArrayList;
import java.util.List;


public class BreweryMenu extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        // item that represents group
        ItemStack breweryGroupItem = new CustomItemStack(Material.POTION, "&eDistilling", "", "&aExplore the world of distilling...");
        ItemMeta meta = breweryGroupItem.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        breweryGroupItem.setItemMeta(meta);

        // Give your Category a unique id.
        NamespacedKey breweryGroupId = new NamespacedKey(this, "brewery_category");
        // creates group
        ItemGroup breweryGroup = new ItemGroup(breweryGroupId, breweryGroupItem);

        //item stacks (needed for creating item)
        SlimefunItemStack cauldron_stack = new SlimefunItemStack("BREWERY", Material.CAULDRON, "&eDistilling");
        SlimefunItemStack skotska_whisky_stack = new SlimefunItemStack("SKOTSKA_WHISKY", Material.POTION, "&eScotch whisky");
        configureMeta(skotska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack irska_whisky_stack = new SlimefunItemStack("IRSKA_WHISKY", Material.POTION, "&eIrish whiskey");
        configureMeta(irska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack bourbon_stack = new SlimefunItemStack("BOURBON", Material.POTION, "&eBourbon");
        configureMeta(bourbon_stack, createNewColor(186,125,84));
        SlimefunItemStack psenicne_pivo_stack = new SlimefunItemStack("PSENICNE_PIVO", Material.POTION, "&eMalt beer");
        configureMeta(psenicne_pivo_stack, createNewColor(255,184,77));
        SlimefunItemStack pivo_stack = new SlimefunItemStack("PIVO", Material.POTION, "&eBeer");
        configureMeta(pivo_stack, createNewColor(255,211,51));
        SlimefunItemStack tmavy_lezak_stack = new SlimefunItemStack("TMAVY_LEZAK", Material.POTION, "&eDark beer");
        configureMeta(tmavy_lezak_stack, createNewColor(101,0,19));
        SlimefunItemStack cervene_vino_stack = new SlimefunItemStack("CERVENE_VINO", Material.POTION, "&eRed wine");
        configureMeta(cervene_vino_stack, Color.RED);
        SlimefunItemStack bile_vino_stack = new SlimefunItemStack("BILE_VINO", Material.POTION, "&eWhite wine");
        configureMeta(bile_vino_stack, Color.YELLOW);
        SlimefunItemStack medovina_stack = new SlimefunItemStack("MEDOVINA", Material.POTION, "&eMead");
        configureMeta(medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecna_medovina_stack = new SlimefunItemStack("JABLECNA_MEDOVINA", Material.POTION, "&eApple mead");
        configureMeta(jablecna_medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecny_most_stack = new SlimefunItemStack("JABLECNY_MOST", Material.POTION, "&eApple juice");
        configureMeta(jablecny_most_stack, createNewColor(248,104,32));
        SlimefunItemStack jablecny_liker_stack = new SlimefunItemStack("JABLECNY_LIKER", Material.POTION, "&eApple liqueur");
        configureMeta(jablecny_liker_stack, Color.RED);
        SlimefunItemStack rum_stack = new SlimefunItemStack("RUM", Material.POTION, "&eRum");
        configureMeta(rum_stack, Color.MAROON);
        SlimefunItemStack vodka_stack = new SlimefunItemStack("VODKA", Material.POTION, "&eVodka");
        configureMeta(vodka_stack, Color.WHITE);
        SlimefunItemStack houbova_vodka_stack = new SlimefunItemStack("HOUBOVA_VODKA", Material.POTION, "&eMushroom vodka");
        configureMeta(houbova_vodka_stack, createNewColor(255,153,153));
        SlimefunItemStack gin_stack = new SlimefunItemStack("GIN", Material.POTION, "&eGin");
        configureMeta(gin_stack, createNewColor(153,221,255));
        SlimefunItemStack tequila_stack = new SlimefunItemStack("TEQUILA2", Material.POTION, "&eTequila");
        configureMeta(tequila_stack, createNewColor(245,240,126));
        SlimefunItemStack absinth_stack = new SlimefunItemStack("ABSINTH", Material.POTION, "&eAbsinthe");
        configureMeta(absinth_stack, Color.GREEN);
        SlimefunItemStack zeleny_absinth_stack = new SlimefunItemStack("ZELENY_ABSINTH", Material.POTION, "&eGreen absinthe");
        configureMeta(zeleny_absinth_stack, Color.LIME);
        SlimefunItemStack bramborova_polevka_stack = new SlimefunItemStack("BRAMBOROVA_POLEVKA", Material.POTION, "&ePotato soup");
        configureMeta(bramborova_polevka_stack, Color.ORANGE);
        SlimefunItemStack kava_stack = new SlimefunItemStack("KAVA", Material.POTION, "&eCoffee");
        configureMeta(kava_stack, Color.BLACK);
        SlimefunItemStack vajecnak_stack = new SlimefunItemStack("VAJECNAK", Material.POTION, "&eEgg liqueur");
        configureMeta(vajecnak_stack, createNewColor(255,230,128));

        //recipe for items
        ItemStack[] item = {null, null, null, null, null, null, null, null, null};

        ItemStack[] cauldron_recipe = {null, null, null, null, createMultiblockRecipe(Material.CAULDRON, "Fill it with water"), null, createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "The fire must be surrounded by stairs"), createMultiblockRecipe(Material.FLINT_AND_STEEL, "Requires fire or another heat source"), createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "The fire must be surrounded by stairs")};
        ItemStack[] skotska_whisky_recipe = {createRecipeItem("Wheat", 9, Material.WHEAT), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, null, createBarrel("Oak barrel", 10), createClock(4), createBrewingStand(2)};
        ItemStack[] irska_whisky_recipe = {createRecipeItem("Wheat", 8, Material.WHEAT), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, null, createBarrel("Oak barrel", 3), createClock(4), createBrewingStand(3)};
        ItemStack[] bourbon_recipe = {createRecipeItem("Wheat", 4, Material.WHEAT), createRecipeItem("BM_MAIZ", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&eCorn", 5), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, createBarrel("Oak barrel", 3), createClock(4), createBrewingStand(2)};
        ItemStack[] psenicne_pivo_recipe = {createRecipeItem("Wheat", 3, Material.WHEAT), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, null, createBarrel("Birch barrel", 2), createClock(8), null};
        ItemStack[] pivo_recipe = {createRecipeItem("Wheat", 6, Material.WHEAT), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, null, createBarrel("Any barrel", 3), createClock(8), null};
        ItemStack[] tmavy_lezak_recipe = {createRecipeItem("Wheat", 12, Material.WHEAT), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, null, createBarrel("Dark oak barrel", 8), createClock(8), null};
        ItemStack[] cervene_vino_recipe = {createRecipeItem("Sweet berries", 9, Material.SWEET_BERRIES), null, null, null, null, null, createBarrel("Any barrel", 20), createClock(5), null};
        ItemStack[] bile_vino_recipe = {createRecipeItem("Glow berries", 9, Material.GLOW_BERRIES), null, null, null, null, null, createBarrel("Any barrel", 20), createClock(5), null};
        ItemStack[] medovina_recipe = {createRecipeItem("Honey bottle", 4, Material.HONEY_BOTTLE), createRecipeItem("Sugar", 2, Material.SUGAR), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, createBarrel("Oak barrel", 4), createClock(3), null};
        ItemStack[] jablecna_medovina_recipe = {createRecipeItem("Honey bottle", 6, Material.HONEY_BOTTLE), createRecipeItem("Apple", 2, Material.APPLE), createRecipeItem("BM_LEVADURA", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, createBarrel("Oak barrel", 4), createClock(4), null};
        ItemStack[] jablecny_most_recipe = {createRecipeItem("Apple", 14, Material.APPLE), null, null, null, null, null, createBarrel("Any barrel", 3), createClock(7), null};
        ItemStack[] jablecny_liker_recipe = {createRecipeItem("Apple", 12, Material.APPLE), createRecipeItem("Sugar", 3, Material.SUGAR), null, null, null, null, createBarrel("Acacia barrel", 6), createClock(16), createBrewingStand(3)};
        ItemStack[] rum_recipe = {createRecipeItem("BM_MAIZ", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&eCorn", 18), null, null, null, null, null, createBarrel("Oak barrel", 14), createClock(6), createBrewingStand(2)};
        ItemStack[] vodka_recipe = {createRecipeItem("Potato", 16, Material.POTATO), null, null, null, null, null, null, createClock(15), createBrewingStand(3)};
        ItemStack[] houbova_vodka_recipe = {createRecipeItem("Potato", 14, Material.POTATO), createRecipeItem("Red mushroom", 3, Material.RED_MUSHROOM), createRecipeItem("Brown mushroom", 3, Material.BROWN_MUSHROOM), null, null, null, null, createClock(18), createBrewingStand(5)};
        ItemStack[] gin_recipe = {createRecipeItem("Wheat", 9, Material.WHEAT), createRecipeItem("Orchid", 6, Material.BLUE_ORCHID), createRecipeItem("Apple", 1, Material.APPLE), null, null, null, null, createClock(6), createBrewingStand(2)};
        ItemStack[] tequila_recipe = {createRecipeItem("Cactus", 8, Material.CACTUS), null, null, null, null, null, createBarrel("Birch barrel", 12), createClock(15), createBrewingStand(2)};
        ItemStack[] absinth_recipe = {createRecipeItem("Grass", 15, Material.SHORT_GRASS), null, null, null, null, null, null, createClock(3), createBrewingStand(6)};
        ItemStack[] zeleny_absinth_recipe = {createRecipeItem("Grass", 17, Material.SHORT_GRASS), createRecipeItem("Poisonous potato", 2, Material.POISONOUS_POTATO), null, null, null, null, null, createClock(5), createBrewingStand(6)};
        ItemStack[] bramborova_polevka_recipe = {createRecipeItem("Potato", 5, Material.POTATO), createRecipeItem("Grass", 3, Material.SHORT_GRASS), null, null, null, null, null, createClock(3), null};
        ItemStack[] kava_recipe = {createRecipeItem("Cocoa beans", 12, Material.COCOA_BEANS), createRecipeItem("Milk bucket", 2, Material.MILK_BUCKET), null, null, null, null, null, createClock(2), null};
        ItemStack[] vajecnak_recipe = {createRecipeItem("Egg", 5, Material.EGG), createRecipeItem("Sugar", 2, Material.SUGAR), createRecipeItem("Milk bucket", 1, Material.MILK_BUCKET), null, null, null, createBarrel("Any barrel", 3), createClock(2), null};
    
        //recipe type - adds icon of cauldron
        RecipeType MENU_BOTTLE = new RecipeType(breweryGroupId, breweryGroupItem);

        //creates items
        SlimefunItem cauldron = new SlimefunItem(breweryGroup, cauldron_stack, RecipeType.MULTIBLOCK, cauldron_recipe);
        SlimefunItem skotska_whisky = new SlimefunItem(breweryGroup, skotska_whisky_stack, MENU_BOTTLE, skotska_whisky_recipe);
        SlimefunItem irska_whisky = new SlimefunItem(breweryGroup, irska_whisky_stack, MENU_BOTTLE, irska_whisky_recipe);
        SlimefunItem bourbon = new SlimefunItem(breweryGroup, bourbon_stack, MENU_BOTTLE, bourbon_recipe);
        SlimefunItem psenicne_pivo = new SlimefunItem(breweryGroup, psenicne_pivo_stack, MENU_BOTTLE, psenicne_pivo_recipe);
        SlimefunItem pivo = new SlimefunItem(breweryGroup, pivo_stack, MENU_BOTTLE, pivo_recipe);
        SlimefunItem tmavy_lezak = new SlimefunItem(breweryGroup, tmavy_lezak_stack, MENU_BOTTLE, tmavy_lezak_recipe);
        SlimefunItem cervene_vino = new SlimefunItem(breweryGroup, cervene_vino_stack, MENU_BOTTLE, cervene_vino_recipe);
        SlimefunItem bile_vino = new SlimefunItem(breweryGroup, bile_vino_stack, MENU_BOTTLE, bile_vino_recipe);
        SlimefunItem medovina = new SlimefunItem(breweryGroup, medovina_stack, MENU_BOTTLE, medovina_recipe);
        SlimefunItem jablecna_medovina = new SlimefunItem(breweryGroup, jablecna_medovina_stack, MENU_BOTTLE, jablecna_medovina_recipe);
        SlimefunItem jablecny_most = new SlimefunItem(breweryGroup, jablecny_most_stack, MENU_BOTTLE, jablecny_most_recipe);
        SlimefunItem jablecny_liker = new SlimefunItem(breweryGroup, jablecny_liker_stack, MENU_BOTTLE, jablecny_liker_recipe);
        SlimefunItem rum = new SlimefunItem(breweryGroup, rum_stack, MENU_BOTTLE, rum_recipe);
        SlimefunItem vodka = new SlimefunItem(breweryGroup, vodka_stack, MENU_BOTTLE, vodka_recipe);
        SlimefunItem houbova_vodka = new SlimefunItem(breweryGroup, houbova_vodka_stack, MENU_BOTTLE, houbova_vodka_recipe);
        SlimefunItem gin = new SlimefunItem(breweryGroup, gin_stack, MENU_BOTTLE, gin_recipe);
        SlimefunItem tequila = new SlimefunItem(breweryGroup, tequila_stack, MENU_BOTTLE, tequila_recipe);
        SlimefunItem absinth = new SlimefunItem(breweryGroup, absinth_stack, MENU_BOTTLE, absinth_recipe);
        SlimefunItem zeleny_absinth = new SlimefunItem(breweryGroup, zeleny_absinth_stack, MENU_BOTTLE, zeleny_absinth_recipe);
        SlimefunItem bramborova_polevka = new SlimefunItem(breweryGroup, bramborova_polevka_stack, MENU_BOTTLE, bramborova_polevka_recipe);
        SlimefunItem kava = new SlimefunItem(breweryGroup, kava_stack, MENU_BOTTLE, kava_recipe);
        SlimefunItem vajecnak = new SlimefunItem(breweryGroup, vajecnak_stack, MENU_BOTTLE, vajecnak_recipe);

        //register items
        cauldron.register(this);
        skotska_whisky.register(this);
        irska_whisky.register(this);
        bourbon.register(this);
        psenicne_pivo.register(this);
        pivo.register(this);
        tmavy_lezak.register(this);
        cervene_vino.register(this);
        bile_vino.register(this);
        medovina.register(this);
        jablecna_medovina.register(this);
        jablecny_most.register(this);
        jablecny_liker.register(this);
        rum.register(this);
        vodka.register(this);
        houbova_vodka.register(this);
        gin.register(this);
        tequila.register(this);
        absinth.register(this);
        zeleny_absinth.register(this);
        bramborova_polevka.register(this);
        kava.register(this);
        vajecnak.register(this);

    }

    private Color createNewColor(int a, int b, int c){
        return Color.fromRGB(a, b, c);
    }

    private void configureMeta(SlimefunItemStack item, Color color) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        assert meta != null;
        meta.setColor(color);
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        item.setItemMeta(meta);
    }

    private ItemStack createRecipeItem(String name, int amount, Material material){
        ItemStack item = new CustomItemStack(material, "&e" + name);
        item.setAmount(amount);
        return item;
    }
    private SlimefunItemStack createRecipeItem(String id, String name, String textrue, int amount){
        SlimefunItemStack item = new SlimefunItemStack(id, name, textrue);
        item.setAmount(amount);
        return item;
    }


    private ItemStack createClock(int i) {
        List<String > lore = new ArrayList<>();
        lore.add(i + " minutes");
        ItemStack clock = new CustomItemStack(Material.CLOCK, "&aBrewing time");
        ItemMeta meta = clock.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        clock.setItemMeta(meta);
        return clock;
    }

    private ItemStack createBrewingStand(int i) {
        List<String> lore = new ArrayList<>();
        lore.add(i + " times");
        ItemStack brewingStand = new CustomItemStack(Material.BREWING_STAND, "&aDistillations");
        ItemMeta meta = brewingStand.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        brewingStand.setItemMeta(meta);
        return brewingStand;
    }

    private ItemStack createBarrel(String s, int i) {
        List<String> lore = new ArrayList<>();
        lore.add("Barrel: " + s);
        lore.add("Time: " + i + " years");
        ItemStack barrel = new CustomItemStack(Material.BARREL, "&aBarrel type");
        ItemMeta meta = barrel.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        barrel.setItemMeta(meta);
        return barrel;
    }
    private ItemStack createMultiblockRecipe(Material material, String lore_input){
        ItemStack item = new CustomItemStack(material);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(lore_input);
        assert meta != null;
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }
    //        PotionMeta swMeta = (PotionMeta) skotska_whisky_stack.getItemMeta();
    //        swMeta.setColor(Color.LIME);
    //        swMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
    //        skotska_whisky_stack.setItemMeta(swMeta);

    // corn "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1"

}
