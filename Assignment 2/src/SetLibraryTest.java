import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**@author Neil Patrick Olaires 000964569
 * STATEMENT OF AUTHORSHIP: This code was written by me, i certify 000964569
 * that i have not given this code out onto anybody, or used any LLM's to create this
 * test class
 */

/** BUGS
 *
 * - CREATE INTERSECTION BUG
 *      1. does not add a gate for setB being null
 *      2. test case setBSizeZeroIllegal()
 *      3. Line 96, should replace with this conditional statement:
 *      (setA == null || setB == null || setA.size() == 0 || setB.size())
 *      This new code adds setB as one of the gates
 *
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
    @Timeout(5)
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
    @Timeout(5)
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
    @Timeout(5)
    public void rangeSizeForUniqueIllegal() {
        /* Assert exception */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createSet(4,10,11,true));
    }


    /**
     * 4. TEST CASE FOR WHILE LOOP FO
     */
    @Test
    @Timeout(5)
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
    @Timeout(5)
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
    @Timeout(5)
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
    @Timeout(5)
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
    @Timeout(5)
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
    @Timeout(5)
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
    @Timeout(5)
    public void nullSetsIsIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstNull = null;
        ArrayList<Integer> secondNull = null;

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createIntersection(firstNull, secondNull));

    }

    /**
     * 2. TEST CASE FOR FIRST NULL SET
     */
    @Test
    @Timeout(5)
    public void firstNullSetIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstNull = null;
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createIntersection(firstNull, secondSet));

    }

    /**
     * 3. TEST CASE FOR SECOND NULL SET
     */
    @Test
    @Timeout(5)
    public void secondNullSetIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> secondNull = null;

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createIntersection(firstSet, secondNull));

    }

    /**
     * 4. TEST CASE FOR SET A SIZE 0
     */
    @Test
    @Timeout(5)
    public void setASizeZeroIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(1,2,3));

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createIntersection(firstSet, secondSet));
    }

    /** BUG THIS IS THE BUG!!!!!!
     * 5. TEST CASE FOR SET B SIZE 0
     * should fail this test case
     */
    @Test
    public void setBSizeZeroIllegal() {
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.createIntersection(firstSet, secondSet));
    }




    /**
     * 6. TEST CASE FOR ACTUAL INTERSECTION WITH COMMONS
     * return set of size two commons which are 6 and 7
     */
    @Test
    @Timeout(5)
    public void hasIntersections() {
        /* Test Data */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(6,7,8,9,10));

        /* Expected Result */
        ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(6,7));

        /* Actual Result */
        ArrayList<Integer> actualResult = sl.createIntersection(firstSet, secondSet);

        /* Assert same size */
        Assertions.assertEquals(expectedResult.size(), actualResult.size());

        /* Assert same list  */
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    /**
     * 7. TEST CASE FOR ACTUAL INTERSECTION WITH NO COMMONS
     * return set of of size zero
     */
    @Test
    @Timeout(5)
    public void hasNoIntersections() {
        /* Test Data */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(8,9,10));

        /* Expected Result */
        ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList());

        /* Actual Result */
        ArrayList<Integer> actualResult = sl.createIntersection(firstSet, secondSet);

        /* Assert same size */
        Assertions.assertEquals(expectedResult.size(), actualResult.size());

        /* Assert same list  */
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    /**
     * 8. TEST CASE FOR ACTUAL INTERSECTION -> HAS DUPLICATES
     */
    @Test
    @Timeout(5)
    public void hasDuplicateIntersections() {
        /* Test Data */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(6,6,6,7,7,8,8,9,10));

        /* Expected Result */
        ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(6,7));

        /* Actual Result */
        ArrayList<Integer> actualResult = sl.createIntersection(firstSet, secondSet);

        /* Assert same size */
        Assertions.assertEquals(expectedResult.size(), actualResult.size());

        /* Assert same list  */
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }







/* 4. ISSUBSET METHOD */

    /**
     * 1. TEST CASE FOR BOTH NULL SETS
     */
    @Test
    @Timeout(5)
    public void nullSubSetsIsIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstNull = null;
        ArrayList<Integer> secondNull = null;

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSubSet(firstNull, secondNull));

    }

    /**
     * 2. TEST CASE FOR FIRST NULL SET
     */
    @Test
    @Timeout(5)
    public void firstNullSubSetIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstNull = null;
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSubSet(firstNull, secondSet));

    }

    /**
     * 3. TEST CASE FOR SECOND NULL SUBSET
     */
    @Test
    @Timeout(5)
    public void secondNullSubSetIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> secondNull = null;

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSubSet(firstSet, secondNull));

    }

    /**
     * 4. TEST CASE FOR SET A SIZE 0
     */
    @Test
    @Timeout(5)
    public void subsetASizeZeroIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(1,2,3));

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSubSet(firstSet, secondSet));
    }

    /**
     * 5. TEST CASE FOR SET B SIZE 0
     */
    @Test
    @Timeout(5)
    public void subsetBSizeZeroIllegal() {
        /* Test Data  */
        ArrayList<Integer> firstSet = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> secondSet = new ArrayList<Integer>(Arrays.asList(1,2,3));

        /* Assert Throw */
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sl.isSubSet(firstSet, secondSet));
    }

    /**
     * 6. TEST CASE FOR SUBEST B BIGGER THEN SET A
     * should return false since it doesn't meet definition for subset
     */
    @Test
    @Timeout(5)
    public void subsetBBiggerFalse() {
        /* Test Data  */
        ArrayList<Integer> setA = new ArrayList<Integer>(Arrays.asList(1,2));
        ArrayList<Integer> setB = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));

        /* Expected Result */
        boolean expectedResult = false;

        /* Actual Result  */
        boolean actualResult = sl.isSubSet(setA,setB);

        /* Assert for boolean return*/
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     *
     * 7. TEST CASE FOR TRUE SUBSETS
     * also an additonal test case to check what happens when setA is bigger than setB
     * should return true for the given test data
     */
    @Test
    @Timeout(5)
    public void isSubSetTrue() {
        /* Test Data  */
        ArrayList<Integer> setA = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<Integer> setB = new ArrayList<Integer>(Arrays.asList(2,3,4));

        /* Expected Result */
        boolean expectedResult = true;

        /* Actual Result  */
        boolean actualResult = sl.isSubSet(setA,setB);

        /* Assert for boolean return*/
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * 8. TEST CASE FOR FALSE SUBSETS
     * which also passes conditional for setA being bigger than setB
     */
    @Test
    @Timeout(5)
    public void isSubSetFalse() {
        /* Test Data  */
        ArrayList<Integer> setA = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<Integer> setB = new ArrayList<Integer>(Arrays.asList(7,8,9));

        /* Expected Result */
        boolean expectedResult = false;

        /* Actual Result  */
        boolean actualResult = sl.isSubSet(setA,setB);

        /* Assert for boolean return*/
        Assertions.assertEquals(expectedResult, actualResult);
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