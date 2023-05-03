package unique.paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UniquePathSolutionTest {

    @ParameterizedTest
    @CsvSource({
            "2, 3, 3",
            "1, 10, 1",
            "3, 7, 28",
            "22, 33, 317986441828055",
            "50, 70, 7629941407664013434"
    })
    void testUniquePaths_returnsCorrectNumberOfPathsForGivenGridSize(int m, int n, long expectedPaths) {
        UniquePathSolution uniquePathSolution = new UniquePathSolution();
        long result = uniquePathSolution.uniquePaths(m,n);
        Assertions.assertEquals(expectedPaths, result);
    }
}