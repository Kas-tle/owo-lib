package io.wispforest.owo.itemgroup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.function.BiConsumer;

/**
 * Used for storing a tab index for use with a {@link OwoItemGroup}
 * inside the vanilla {@link Item.Settings}
 */
public interface OwoItemSettingsExtensions {

    /**
     * @return The index of the tab the target item should reside in
     */
    int getTabIndex();

    /**
     * Sets the tab index the target item should reside in
     *
     * @param tab The 0-indexed tab id
     * @return this
     */
    Item.Settings setTab(int tab);

    BiConsumer<Item, DefaultedList<ItemStack>> getStackGenerator();

    void setStackGenerator(BiConsumer<Item, DefaultedList<ItemStack>> appender);

}
