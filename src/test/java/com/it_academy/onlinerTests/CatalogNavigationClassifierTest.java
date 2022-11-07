package com.it_academy.onlinerTests;

import com.it_academy.onliner.framework.DriverManager;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHeader;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.it_academy.onlinerTests.TestUtilAssertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogNavigationClassifierTest extends BaseTest {

    private OnlinerHeader header;
    private CatalogPage catalogPage;

    @BeforeClass
    public void webDriverInit() {
        header = new OnlinerHeader();
        catalogPage = new CatalogPage();
        DriverManager.getDriver().get("https://www.onliner.by/");
    }

    @Test
    public void TestValidateCatalogNavigationTitles() {
        List<String> expectedCatalogElements = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника",
                "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");
        List<String> catalogElements =
                header.clickOnCatalogNavigationLink()
                        .getListOfWebElementsFromCatalogPanel()
                        .stream()
                        .map(el -> el.getText())
                        .skip(1)
                        .collect(Collectors.toList());

        assertThat(catalogElements)
                .as("the list of elements is empty")
                .isNotEmpty()
                .as("the list of elements does not match:")
                .containsExactlyElementsOf(expectedCatalogElements);
    }

    @Test
    public void testValidateCorrectElementsInCategoryComputersAndNetworks() {
        List<String> expectedElementsFromCategory = Arrays.asList("Ноутбуки,компьютеры, мониторы", "Комплектующие",
                "Хранение данных", "Сетевое оборудование");
        List<String> computersAndNetworksElements =
                header.clickOnCatalogNavigationLink()
                        .clickOnCatalogClassifierLink("Компьютеры и")
                        .collectElementsFromCategory()
                        .stream()
                        .map(el -> el.getText())
                        .collect(Collectors.toList());

        assertThat(computersAndNetworksElements)
                .as("the list of elements is empty")
                .isNotEmpty()
                .as("the list of elements does not match:")
                .containsAnyElementsOf(expectedElementsFromCategory);
    }

    @Test
    public void testValidateProductsInCategory() {
        List<List<String>> products =
                header.clickOnCatalogNavigationLink()
                        .clickOnCatalogClassifierLink("Компьютеры и")
                        .clickOnCategory(" Комплектующие ")
                        .collectProductsFromCategory()
                        .stream()
                        .map(el -> el.findElements(By.tagName("span"))
                                .stream()
                                .map(x -> x.getText())
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList());
        System.out.println(products);
        SoftAssertions softly = new SoftAssertions();
        assertThatGoodsNamesExist(products, softly);
        assertThatGoodsExist(products, softly);
        assertThatPriseExist(products, softly);
        softly.assertAll();
    }

}
