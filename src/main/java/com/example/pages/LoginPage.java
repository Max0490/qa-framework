package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement usernameInput = $x("//input[@id='user-name']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement loginButton   = $x("//input[@value='Login']");
    private final SelenideElement errorMessage  = $x("//h3[@data-test='error']");

    public LoginPage openPage() {
        open("/");
        return this;
    }

    public LoginPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public InventoryPage clickLoginSuccess() {
        loginButton.click();
        return new InventoryPage();
    }

    public LoginPage clickLoginFailure() {
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public InventoryPage loginAs(String username, String password) {
        return open()
                .setUsername(username)
                .setPassword(password)
                .clickLoginSuccess();
    }
}
