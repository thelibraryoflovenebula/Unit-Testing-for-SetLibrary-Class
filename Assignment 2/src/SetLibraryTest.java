import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SetLibraryTest {
    //for using methods
    SetLibrary sl = new SetLibrary();


/* 1. CREATESET METHOD*/
    /**
     * 1. TEST CASE FOR NEGATIVE SIZE
     * should throw illegal argument exception
     *
     * size param only matters, nothing else does
     */
    @Test
    public void negativeSizeIsIllegal() {
        /* Assert exception */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createSet(-1,2,10,true));
    }

    /**
     * 2. TEST CASE FOR BIGGER MINIMUM
     * should throw illegal argument exception
     *
     * first three params matter, size then range
     */
    @Test
    public void biggerMinThanMaxIsIllegal() {
        /* Assert exception */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createSet(2,10,2,true));
    }

    /**
     * 3. TEST CASE FOR UNIQUE ELEMENTS
     * should throw illegal exception
     *
     * when size is larger than range, unique numbers cant coexist
     */
    @Test
    public void rangeSizeForUniqueIllegal() {
        /* Assert exception */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createSet(4,10,11,true));
    }


    /**
     * 4. TEST CASE FOR WHILE LOOP FO
     */
    @Test
    public void rangeSizeNotUnique() {
        /* Test data */
        // size = 10, min, max, not unique

        /* Expected result */
        int expectedResult = 10;

        /* Actual result */
        int actualResult = sl.createSet(10,-5,5,false).size();

        /* Assertion*/
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * 5. TEST CASE FOR FORLOOP WITH isUNIQUE
     *
     */
    @Test
    public void rangeSizeIsUnique() {
        /* Test data */
        // size = 10, min, max, not unique

        /* Expected result */
        int expectedResult = 10;

        /* Actual result */
        int actualResult = sl.createSet(10,-5,5,true).size();

        /* Assertion*/
        Assertions.assertEquals(expectedResult, actualResult);
    }










/* 2. ISSETUNIQUE METHOD */
    /**
     * 1. TEST CASE FOR NULL SET
     */
    @Test
    public void nullSetIllegal() {
        /* Test Data */

        /* Expected Result*/

        /* Actual Result*/
    }




}
/* Assertions.assertEquals(expected, actual)
 *      ->ONE USES THE MOST
 *
 * Assertions.assertIterableEquals(expect, actual)
 *      ->CHECKS IF LISTS ACTUALLY THE SAME
 *
 * Assertions.assertThrows()
 *      ->CHECKS FOR EXPECTED EXCEPTION THROWN
 *
 */