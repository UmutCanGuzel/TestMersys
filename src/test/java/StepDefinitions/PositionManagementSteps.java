package StepDefinitions;

import PageObjectModels.DialogContent;
import PageObjectModels.LeftNav;
import Utilities.BaseDriver;
import Utilities.Events;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.formula.functions.IDStarAlgorithm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PositionManagementSteps {
    DialogContent dc = new DialogContent();

    LeftNav ln = new LeftNav();

    @And("Click on the element in the LeftNav")
    public void clickOnTheElementInTheLeftNav(DataTable links) {
        List<String> strlinkList = links.asList(String.class);

        for (int i = 0; i < strlinkList.size(); i++) {
            WebElement linkWebElement = ln.getWebElement(strlinkList.get(i));
            Events.click(linkWebElement);
        }
    }

    @And("Click on the element in the DialogContent")
    public void clickOnTheElementInTheDialogContent(DataTable buttons) {
        List<String> strButtonsList = buttons.asList(String.class);

        for (int i = 0; i < strButtonsList.size(); i++) {
            WebElement buttonWebElement = dc.getWebElement(strButtonsList.get(i));
            Events.click(buttonWebElement);
        }
    }

    @And("User sends the keys into the DialogBox")
    public void userSendsTheKeysIntoTheDialogBox(DataTable data) {
        List<List<String>> items = data.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element = dc.getWebElement(items.get(i).get(0));
            Events.sendKeys(element, items.get(i).get(1));
        }
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() throws InterruptedException {
        Events.verifyContainsText(dc.successMsg, "success");
        Thread.sleep(1000);
    }

    @And("Click on the edit button in the DialogContent")
    public void clickOnTheEditButtonInTheDialogContent() throws InterruptedException {
        Thread.sleep(1500);
        Events.click(dc.editBtn);
    }

    @And("Click on the element in the DialogContent for deleting")
    public void clickOnTheElementInTheDialogContentForDeleting(DataTable dt) {
        List<String> list = dt.asList();

        for (int i = 0; i <list.size() ; i++) {
            WebElement element = dc.getWebElement(list.get(i));
            Events.click(element);
        }
    }
}

