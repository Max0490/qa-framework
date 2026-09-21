package com.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

public class InventoryPage {

    private final SelenideElement shoppingCartBadge = $x("//span[@class='shopping_cart_badge']");

    private final SelenideElement shoppingCartLink = $x("//a[@class='shopping_cart_link']");

    private final ElementsCollection addToCartButtons = $$x("//button[contains(@data-test,'add-to-cart')]");

    private final SelenideElement pageTitle = $x("//span[@class='title']");

    public String getPageTitle() {
        return pageTitle.getText();
    }


    public int getCartItemCount() {
        try {
            return Integer.parseInt(shoppingCartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }


    public InventoryPage addFirstItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.first().click();
        }
        return this;
    }


    public InventoryPage addItemToCartByIndex(int index) {
        if (addToCartButtons.size() > index) {
            addToCartButtons.get(index).click();
        }
        return this;
    }


    public CartPage openCart() {
        shoppingCartLink.click();
        return new CartPage();
    }
}