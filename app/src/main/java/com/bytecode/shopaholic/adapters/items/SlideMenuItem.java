package com.bytecode.shopaholic.adapters.items;

/**
 * Created by tuman on 8/5/2015.
 */
public class SlideMenuItem extends Item {
    private String slideItem;
    private int icons;

    public SlideMenuItem() {
    }

    public SlideMenuItem(String slideItem, int icons) {
        this.slideItem = slideItem;
        this.icons = icons;

    }

    public String getSlideItem() {
        return slideItem;
    }

    public void setSlideItem(String slideItem) {
        this.slideItem = slideItem;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }

    @Override
    public String toString() {
        return "SlideMenuItem{" +
                "slideItem='" + slideItem + '\'' +
                ", icons=" + icons +
                '}';
    }
}
