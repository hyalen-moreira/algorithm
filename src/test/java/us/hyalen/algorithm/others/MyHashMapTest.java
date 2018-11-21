package us.hyalen.algorithm.others;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import us.hyalen.algorithm.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MyHashMapTest extends BaseTest {
    @TestConfiguration
    static class SolutionTestContextConfiguration {
        @Bean
        public MyHashMap solution() {
            return new MyHashMap();
        }
    }

    @Autowired
    private MyHashMap map;

    @Test
    public void put() {
        map.put(0, "Hyalen");
        map.put(1, "Moreira");
        map.put(2, "Caldeira");

        assertThat(map.get(1), is(equalTo("Moreira")));
    }

    @Test
    public void get() {
        map.put(1, "Gontijo");
        assertThat(map.get(1), is(equalTo("Gontijo")));
    }

    @Test
    public void containsKey() {
        assertThat(map.get(2), is(equalTo("Caldeira")));
    }
}