package com.it_academy.onlinerTests;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilAssertions {

    public static void assertThatPriseExist(List<List<String>> products) {
        for (List<String> product : products) {
            for (int i = 2; i < product.size(); i++) {
                if (i == 3) {
                    assertThat(product.get(i))
                            .containsPattern("(от (\\d))|(\\d р.)");
                }
            }
        }
    }

    public static void assertThatGoodsExist(List<List<String>> products) {
        for (List<String> product : products) {
            for (int i = 2; i < product.size(); i++) {
                if (i == 3) {
                    assertThat(product.get(i))
                            .containsPattern("(\\d товар)");
                }
            }
        }
    }

    public static void assertThatGoodsNamesExist(List<List<String>> products) {
        for (List<String> product : products) {
            for (int i = 2; i < product.size(); i++) {
                if (i == 2) {
                    assertThat(product.get(i))
                            .as("Product have no correct name")
                            .containsPattern("[(а-я)(A-Я)(\\w)]");
                }
            }
        }
    }
}
