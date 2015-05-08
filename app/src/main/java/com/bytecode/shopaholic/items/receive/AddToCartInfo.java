package com.bytecode.shopaholic.items.receive;

import com.bytecode.shopaholic.items.Scart;

/**
 * Created by ultimate on 5/8/2015.
 */
public class AddToCartInfo {

    Scart cart;
    Scart product;
    String quantity;

    public AddToCartInfo(Scart cart, Scart product, String quantity) {
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
        return "AddToCartInfo{" +
                "cart=" + cart +
                ", product=" + product +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
