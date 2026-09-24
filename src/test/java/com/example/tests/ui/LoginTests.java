package com.example.tests.ui;

import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends BaseUiTest{

    @Test
    @DisplayName("Positive.Логин в систему")
    void loginTest() {
        InventoryPage inventoryPage = new LoginPage().loginAs("standard_user", "secret_sauce");

        assertThat(inventoryPage.getPageTitle())
                .as("Заголовок страницы после логина")
                .isEqualTo("Products");

    }

}
