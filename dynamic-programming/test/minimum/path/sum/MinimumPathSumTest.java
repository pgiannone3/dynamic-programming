package minimum.path.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumPathSumTest {

    @ParameterizedTest
    @MethodSource("provideGridAndExpectedMinSum")
    void testUniquePathsIterative_returnsCorrectNumberOfPathsForGivenGridSize(int [][] grid, int expectedMinSum) {
        MinimumPathSumIterative minimumPathSum = new MinimumPathSumIterative();
        int result = minimumPathSum.minPathSum(grid);
        Assertions.assertEquals(expectedMinSum, result);
    }

    @ParameterizedTest
    @MethodSource("provideGridAndExpectedMinSum")
    void testUniquePathsRecursive_returnsCorrectNumberOfPathsForGivenGridSize(int [][] grid, int expectedMinSum) {
        MinimumPathSumRecursive minimumPathSum = new MinimumPathSumRecursive();
        int result = minimumPathSum.minPathSum(grid);
        Assertions.assertEquals(expectedMinSum, result);
    }


    private static Stream<Arguments> provideGridAndExpectedMinSum() {
        return Stream.of(
                Arguments.of(new int [][] {{1,2},{1,1}}, 3)
        );
    }
}