import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**@author Neil Patrick Olaires 000964569
 * STATEMENT OF AUTHORSHIP: This code was written by me, i certify 000964569
 * that i have not given this code out onto anybody, or used any LLM's to create this
 * test class
 *
 */
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










/* 2. ISSETUNIQUE METHOD input ArrayList<Integer> */
    /**
     * 1. TEST CASE FOR NULL SET AND ZERO SET
     */
    @Test
    public void nullSetIllegal() {
        /* Test Data */
        ArrayList<Integer> nullSet = null;
        ArrayList<Integer> zeroSet = new ArrayList<Integer>();

        /* Assert for null */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSetUnique(nullSet));

        /* Assert for size 0*/
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSetUnique(zeroSet));
    }


    /**
     * 2. TEST CASE FOR SET HAVING MORE THAN 0
     *
     */
    @Test
    public void sizeCheck() {
        /* Test Data */
        //1,2,3,4,5 -> length size of 5

        /* Expected Result */
        int expectedResult = 5;

        /* Actual result */
        ArrayList<Integer> five = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        int actualResult = five.size();

        /* Assert size */
        Assertions.assertEquals(expectedResult, actualResult);
    }


    /**
     * 3. TEST CASE FOR UNIQUE SETS -> test for true
     * this means the set is unique, method should return true
     */
    @Test
    public void isUniqueTest() {
        /* Test Data */
        //1,2,3,4,5

        /* Expected Result */
        boolean expectedResult = true; //SHOULD BE TRUE BECAUSE LIST IS UNIQUE

        /* Actual result */
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        boolean actualResult = sl.isSetUnique(list);

        /* Assert size */
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * 4. TEST CASE FOR NON UNIQUE SET -> test for false
     * this means the set is not unique, or has duplicates
     * should return false
     */
    @Test
    public void isNotUniqueTest() {
        /* Test Data */
        //1,2,3,4,5,5,8,8

        /* Expected Result */
        boolean expectedResult = false; //SHOULD BE FALSE BECAUSE OF DUPLICATES 5 AND 8

        /* Actual result */
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,5,8,8));
        boolean actualResult = sl.isSetUnique(list);

        /* Assert size */
        Assertions.assertEquals(expectedResult, actualResult);
    }





/* 3. CREATE INTERSECTION METHOD */
    /**
     * 1. TEST CASE FOR BOTH NULL SETS

     */
    @Test
    public void nullSetsIsIllegal() {
    }

    /**
     * 2. TEST CASE FOR FIRST NULL SET
     */
    @Test
    public void firstNullSetIllegal() {

    }

    /**
     * 3. TEST CASE FOR SECOND NULL SET
     */
    @Test
    public void secondNullSetIllegal() {

    }

    /**
     * 4. TEST CASE FOR ARRAY SIZE F 0
     */
    @Test
    public void setSizeZeroIllegal() {

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
 * SYNTAX FOR ILLEGAL ARGUMENT
 * Assertions.assertThrows(IllegalArgumentException.class, ()-> GradeMode.calculateGradeMode(list));
 */