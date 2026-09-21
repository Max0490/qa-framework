package com.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

public class CartPage {
    private final ElementsCollection cartItems = $$x("//div[@class='cart_item']");
    private final SelenideElement pageTitle = $x("//span[@class='title']");
    private final SelenideElement checkoutButton = $x("//button[@id='checkout']");
    private final SelenideElement continueShoppingButton = $x("//button[@id='continue-shopping']");

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public boolean isItemInCart(String itemName) {
        return cartItems.stream()
                .anyMatch(item -> item.getText().contains(itemName));
    }

    public String getAllCartItemsText() {
        return cartItems.texts().toString();
    }

    public InventoryPage continueShopping() {
        continueShoppingButton.click();
        return new InventoryPage();
    }
}
