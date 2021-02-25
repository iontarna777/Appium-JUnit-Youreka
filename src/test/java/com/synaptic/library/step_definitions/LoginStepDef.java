package com.synaptic.library.step_definitions;
import com.synaptic.library.pages.android.HomeAndroidPage;

import com.synaptic.library.pages.android.LoginAndroidPage;
import com.synaptic.library.pages.basePages.LoginBasePage;
import com.synaptic.library.pages.iOS.LoginPageiOS;
import com.synaptic.library.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginStepDef {

    LoginAndroidPage loginPage = new LoginAndroidPage();
    HomeAndroidPage homeAndroidPage = new HomeAndroidPage();






    @Given("I am logged in prodtest")
    public void i_am_logged_in_prodtest() {


        loginPage.login();

    }

    @When("I click on hamburger menu")
    public void i_click_on_hamburger_menu() {
      homeAndroidPage.hamburgerMenu.click();
    }


    @Then("Version has to be {string}")
    public void version_has_to_be(String string) {
        String actualVersion = loginPage.version.getText();
        assertEquals(string,actualVersion);
    }


    @Then("Menu should contain next options:")
    public void menu_should_contain_next_options(List<String> menuOptions) {
        assertTrue(menuOptions.contains(loginPage.dataManagementButton.getText()) &
                menuOptions.contains(loginPage.searchButton.getText()) &
                menuOptions.contains(loginPage.logoutButton.getText()));


    }




}
