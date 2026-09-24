package com.example.tests.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseUiTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

    }
}
