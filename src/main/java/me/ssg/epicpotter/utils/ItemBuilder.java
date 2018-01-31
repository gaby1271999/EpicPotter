package me.ssg.epicpotter.utils;

import me.ssg.epicpotter.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(String name) {
        item = new ItemStack(Material.getMaterial(name));
    }

    public ItemBuilder(String name, int amount) {
        item = new ItemStack(Material.getMaterial(name), amount);
    }

    public ItemBuilder(String name, int amount, short damage) {
        item = new ItemStack(Material.getMaterial(name), amount, damage);
    }

    public ItemBuilder(String name, int amount, short damage, byte data) {
        item = new ItemStack(Material.getMaterial(name), amount, damage, data);
    }

    public void addDisplayName(String name) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(Main.messageManager.toColor(name));

        item.setItemMeta(itemMeta);
    }


    public void addLore(String... lore) {
        ItemMeta itemMeta = item.getItemMeta();

        List<String> coloredLore = new ArrayList<String>();
        for (String line : lore) {
            coloredLore.add(Main.messageManager.toColor(line));
        }

        itemMeta.setLore(coloredLore);

        item.setItemMeta(itemMeta);
    }
}
