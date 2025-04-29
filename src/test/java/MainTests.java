import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    @Test
    public void testGetMaxNumber(){

        int [] arr = {2,3,1,2,4,6,8,9,9,0};

        assertEquals(9,Main.findMax(arr));
    }

    @Test
    public void testGetMaxNumberWhenMaxIs0(){
        int [] arr = {0,0,0,0,0,0,0,0,0,0};

        assertEquals(0,Main.findMax(arr));
    }

    @Test
    public void testGetMaxNumberWhenEmpty(){
        int [] arr = {};

        assertEquals(0,Main.findMax(arr));
    }


    @Test
    public void testReverseArray(){
        int [] arr = {1,2,3,4,5,6,7,8,9,1};

        int [] expectedArr = {1,9,8,7,6,5,4,3,2,1};

        assertArrayEquals(expectedArr,Main.reverseArr(arr));
    }

    @Test
    public void testReverseArrayWhenTwoElements(){
        int [] arr = {1,1};

        int [] expectedArr = {1,1};

        assertArrayEquals(expectedArr,Main.reverseArr(arr));
    }

    @Test
    public void testReverseArrayWhenOneElement(){
        int [] arr = {1};

        int [] expectedArr = {1};

        assertArrayEquals(expectedArr,Main.reverseArr(arr));
    }

    @Test
    public void testReverseArrayWhenZeroElement(){
        int [] arr = {};

        int [] expectedArr = {};

        assertArrayEquals(expectedArr,Main.reverseArr(arr));
    }

    @Test
    public void testFindFirstDuplicate(){
        int [] arr = {2, 5, 1, 2, 3, 5, 1};
        int expectedInteger = 2;

        int actualArr = Main.findFirstDuplicate(arr);
        int actualArrV2 = Main.findFirstDuplicateV2(arr);

        assertEquals(expectedInteger,actualArr);
        assertEquals(expectedInteger,actualArrV2);
    }

    @Test
    public void testFindFirstDuplicateWhenNoDuplicates(){
        int [] arr = {1, 2, 3, 4, 5};
        int expectedInteger = -1;

        int actualArr = Main.findFirstDuplicate(arr);
        int actualArrV2 = Main.findFirstDuplicateV2(arr);

        assertEquals(expectedInteger,actualArr);
        assertEquals(expectedInteger,actualArrV2);
    }

    @Test
    public void testFindFirstDuplicateWhenEmpty(){
        int [] arr = {};
        int expectedInteger = -1;

        int actualArr = Main.findFirstDuplicate(arr);
        int actualArrV2 = Main.findFirstDuplicateV2(arr);

        assertEquals(expectedInteger,actualArr);
        assertEquals(expectedInteger,actualArrV2);
    }

    @Test
    public void testFindFirstDuplicateWhenInOrderDuplicates(){
        int [] arr = { 1,1,2,2,3,4,4,5};
        int expectedInteger = 1;

        int actualArr = Main.findFirstDuplicate(arr);
        int actualArrV2 = Main.findFirstDuplicateV2(arr);

        assertEquals(expectedInteger,actualArr);
        assertEquals(expectedInteger,actualArrV2);
    }

}
