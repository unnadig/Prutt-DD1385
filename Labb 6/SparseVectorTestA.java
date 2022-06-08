import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class SparseVectorTestA {
    @Test
    public void testEmptyArray() {
        ComparableElemVec<Integer> vec = new ComparableElemVec<>();
        assertEquals(0, vec.size());
        assertEquals(-1, vec.minIndex());
        assertEquals(-1, vec.maxIndex());
        assertNull(vec.get(3));
        Object[] emptyArray = {};
        ArrayList<Integer> emptyArrayList = new ArrayList<Integer>();
        assertArrayEquals(emptyArray, vec.toArray());
        assertEquals(emptyArrayList, vec.sortedValues());
    }

    @Test
    public void testSpecifiedAdd() {
        ComparableElemVec<Integer> vec = new ComparableElemVec<>();
        vec.add(3,5);
        assertEquals(1, vec.size());
        vec.add(3,4);
        assertEquals(1, vec.size());
        vec.add(2,1);
        assertEquals(2, vec.size());
        vec.add(3,4);
        assertEquals(2, vec.size());
        vec.add(3,5);
        assertEquals(2, vec.size());
        assertEquals(2, vec.minIndex());
        assertEquals(3, vec.maxIndex());
    }
    
    @Test
    public void testUnspecifiedAdd() {
        ComparableElemVec<Integer> vec = new ComparableElemVec<>();
        vec.add(5);
        assertEquals(1, vec.size());
        assertTrue(vec.get(0) == 5);
        vec.add(4);
        assertEquals(2, vec.size());
        assertTrue(vec.get(1) == 4);
        assertNull(vec.get(2));
        
    }
    
    @Test
    public void testRemove() {
        ComparableElemVec<Integer> vec = new ComparableElemVec<>();
        vec.add(5);
        vec.add(4);
        vec.add(5);
        vec.removeElem(5);
        assertNull(vec.get(0));
        vec.removeAt(2);
        assertEquals(1, vec.size());
        assertTrue(vec.get(1) == 4);
    }
}