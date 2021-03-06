package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    final String expected = "OMGHAI!\n"+
            "-------- day 0 --------\n"+
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 10, 20\n"+
            "Aged Brie, 2, 0\n"+
            "Elixir of the Mongoose, 5, 7\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n"+
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n"+
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n"+
            "Conjured Mana Cake, 3, 6\n"+
            "\n"+
            "-------- day 1 --------\n"+
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 9, 19\n"+
            "Aged Brie, 1, 1\n"+
            "Elixir of the Mongoose, 4, 6\n"+
            "Sulfuras, Hand of Ragnaros, 0, 80\n"+
            "Sulfuras, Hand of Ragnaros, -1, 80\n"+
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n"+
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n"+
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n"+
            "Conjured Mana Cake, 2, 4\n" +
            "\n";

    @Test
    public void gildedRose() throws Exception{
        StringBuilder builder = new StringBuilder("OMGHAI!\n");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;

        for (int i = 0; i < days; i++) {
            builder.append("-------- day ").append(i).append(" --------\n");
            builder.append("name, sellIn, quality\n");
            for (Item item : items) {
                builder.append(item).append("\n");
            }
            builder.append("\n");
            app.updateQuality();
        }

        String actual = builder.toString();
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
