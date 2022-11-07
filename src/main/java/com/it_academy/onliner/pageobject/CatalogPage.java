package com.it_academy.onliner.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class CatalogPage extends BasePage {
    public static final String ALL_CATALOG_NAVIGATION_CLASSIFIER_LINK =
            "//span[@class='catalog-navigation-classifier__item-title']/child::*";
    public static final String CATALOG_NAVIGATION_LIST_COMPUTERS_AND_NETS = "//div[@data-id = '2']//div[@class =" +
            " 'catalog-navigation-list__aside-item']/div[normalize-space(text())]";

    public static final String CATALOG_NAVIGATION_CLASSIFIER_LINK_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier__item')]//*[contains(text(), '%s')]";
    // "*[contains(@class, 'catalog-navigation-classifier__item')]//*[contains(text(),
    // '%s' and contains(text(), '%s'))]"; - так не кликает
    //"//li[.//span[contains(text(), '%s')]]";

    public static final String CATALOG_NAVIGATION_LIST_PATTERN =
            // "//div[@class='catalog-navigation-list__aside catalog-navigation-list__aside_active'][.//div[text() = '%s']]";
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    public static final String LIST_OF_PRODUCTS_FROM_CATEGORY =
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                    "//span[@class='catalog-navigation-list__dropdown-data']";

    public List<WebElement> getListOfWebElementsFromCatalogPanel() {
        List<WebElement> catalogNavigation = waitForElementsVisible(By.xpath(format
                (ALL_CATALOG_NAVIGATION_CLASSIFIER_LINK)));
        return catalogNavigation;
    }

    public CatalogPage clickOnCatalogClassifierLink(String link) { //(String link, String link1)
        waitForElementVisible(By.xpath(format(CATALOG_NAVIGATION_CLASSIFIER_LINK_PATTERN, link)))
                .click();
        return this;
    }

    public List<WebElement> collectElementsFromCategory() {
        List<WebElement> computersAndNetsFromCatalog = waitForElementsVisible(By.xpath(format
                (CATALOG_NAVIGATION_LIST_COMPUTERS_AND_NETS)));
        return computersAndNetsFromCatalog;
    }

    public CatalogPage clickOnCategory(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_NAVIGATION_LIST_PATTERN, link)))
                .click();
        return this;
    }

    public List<WebElement> collectProductsFromCategory() {
        List<WebElement> productsFromWeb = waitForElementsVisible(By.xpath(format
                (LIST_OF_PRODUCTS_FROM_CATEGORY)));
        return productsFromWeb;
    }
}
