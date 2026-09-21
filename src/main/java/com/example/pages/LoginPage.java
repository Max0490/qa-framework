package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement usernameInput = $x("//input[@id='user-name']");
    private final SelenideElement passwordInput = $x("//input[@data-test='password']");
    private final SelenideElement loginBtn = $x("//input[@data-test='login-button']");
    private final SelenideElement errorMessage = $x("//h3[@data-test='error']");

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
        loginBtn.click();
        return new InventoryPage();
    }

    public LoginPage clickLoginFailure() {
        loginBtn.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public InventoryPage loginAs(String username, String password) {
        return openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginSuccess();
    }
}
