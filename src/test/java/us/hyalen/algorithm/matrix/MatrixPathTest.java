package us.hyalen.algorithm.matrix;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import us.hyalen.algorithm.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatrixPathTest extends BaseTest {
    @TestConfiguration
    static class SolutionTestContextConfiguration {
        @Bean
        public MatrixPath getMatrixPath() {
            return new MatrixPath();
        }
    }

    @Autowired
    private MatrixPath matrixPath;

    @Test
    public void numberOfPaths() {
        int maze[][] = new int[4][4];

        assertThat(matrixPath.numberOfPaths(maze), is(equalTo(20)));
    }

    @Test
    public void numberOfPathsSpaceOptimization() {
        int maze[][] = new int[4][4];

        assertThat(matrixPath.numberOfPathsSpaceOptimization(maze), is(equalTo(20)));
    }
}
