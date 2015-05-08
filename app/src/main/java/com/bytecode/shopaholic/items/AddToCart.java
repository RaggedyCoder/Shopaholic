package com.bytecode.shopaholic.items;

/**
 * Created by ultimate on 5/8/2015.
 */
public class AddToCart {
    Scart cart;
    Scart product;
    String quantity;

    public AddToCart(Scart cart, Scart product, String quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Scart getCart() {
        return cart;
    }

    public void setCart(Scart cart) {
        this.cart = cart;
    }

    public Scart getProduct() {
        return product;
    }

    public void setProduct(Scart product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddToCart{" +
                "cart=" + cart +
                ", product=" + product +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
