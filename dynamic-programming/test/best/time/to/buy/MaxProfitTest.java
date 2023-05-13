package best.time.to.buy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxProfitTest {
    @ParameterizedTest
    @MethodSource("provideMatrixAndExpectedResult")
    void testUniquePathsRecursive_returnsCorrectNumberOfPathsForGivenGridSize(int[] grid, int expectedMinSum) {
        var maxProfit = new MaxProfit();
        Assertions.assertEquals(maxProfit.maxProfit(grid), expectedMinSum);
    }



    private static Stream<Arguments> provideMatrixAndExpectedResult() {
        return Stream.of(
                Arguments.of(new int []{7,1,5,3,6,4}, 5),
                Arguments.of(new int []{7,6,4,3,1}, 0),
                Arguments.of(new int []{7,3,44,3,2,3}, 41),
                Arguments.of(new int []{7,1,5,2,2,1}, 4));
    }
}