package us.hyalen.algorithm.matrix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import us.hyalen.algorithm.Application;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@SpringBootTest
public class SolutionTest {
    @TestConfiguration
    static class SolutionTestContextConfiguration {
        @Bean
        public Solution solution() {
            return new Solution();
        }
    }

    @Autowired
    private Solution solution;

    @Test
    public void numberOfPaths() {
        int maze[][] = new int[4][4];

        assertThat(solution.numberOfPaths(maze), is(equalTo(20)));
    }
}
