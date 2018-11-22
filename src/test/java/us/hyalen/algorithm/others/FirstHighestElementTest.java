package us.hyalen.algorithm.others;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import us.hyalen.algorithm.BaseTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class FirstHighestElementTest extends BaseTest {
    private List<Product> products;
    private Product prd1;
    private Product prd2;
    private Product prd3;
    private Product prd4;
    private Product prd5;
    private Product prd6;
    private Product prd7;
    private Product prd8;

    @TestConfiguration
    static class SolutionTestContextConfiguration {
        @Bean
        public FirstHighestElement getFirstHighestElement() {
            return new FirstHighestElement();
        }
    }

    @Autowired
    private FirstHighestElement highestElement;

    @Before
    public void createAndInitializeList() {
        products = new LinkedList<>();

        prd1 = new Product("ONE", 1);
        prd2 = new Product("TWO", 2);
        prd3 = new Product("ONE AGAIN", 1);
        prd4 = new Product("TWO AGAIN", 2);
        prd5 = new Product("THREE", 3);
        prd6 = new Product("FOUR", 4);
        prd7 = new Product("FIVE", 5);
        prd8 = new Product("ONE MORE ONE", 1);

        products = Arrays.asList(prd1, prd2, prd3, prd4, prd5, prd6, prd7, prd8);
    }

    @Test
    @DisplayName("Should contain FIVE and FOUR")
    public void firstHighestElement() {
        List<Product> list = highestElement.highest(products, 2);

        assertThat(list, hasSize(2));
        assertThat(list.size(), is(2));
        assertThat(list, containsInAnyOrder(prd6, prd7));
    }
}