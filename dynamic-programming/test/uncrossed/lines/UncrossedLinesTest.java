package uncrossed.lines;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class UncrossedLinesTest {

    @ParameterizedTest
    @MethodSource("provideNums1AndNums2AndExpectedUncrossedLines")
    void maxUncrossedLines(int [] nums1, int [] nums2, int result) {
        UncrossedLines uncrossedLines = new UncrossedLines();
        int uncrossedLinesNumber = uncrossedLines.maxUncrossedLines(nums1, nums2);
        Assertions.assertEquals(result, uncrossedLinesNumber);
    }

    private static Stream<Arguments> provideNums1AndNums2AndExpectedUncrossedLines() {
        return Stream.of(
                Arguments.of(new int []{1, 2, 3}, new int[]{}, 0),
                Arguments.of(new int []{}, new int[]{1, 2, 3}, 0),
                Arguments.of(new int []{999}, new int[]{999}, 1),
                Arguments.of(new int []{999}, new int[]{1111}, 0),
                Arguments.of(new int []{1,4,2}, new int[]{1,2,4}, 2),
                Arguments.of(new int []{2,5,1,2,5}, new int[]{10,5,2,1,5,2}, 3),
                Arguments.of(new int []{1,3,7,1,7,5}, new int[]{1,9,2,5,1}, 2)
        );
    }
}