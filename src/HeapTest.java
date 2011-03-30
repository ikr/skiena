import junit.framework.TestCase;

public class HeapTest extends TestCase {
    public void testParentIndexOfZeroReturnsAnInvalidValue() {
        assertEquals(-1, Heap.parentIndex(0));
    }

    public void testParentIndexOfOneIsZero() {
        assertEquals(0, Heap.parentIndex(1));
    }

    public void testParentIndexOfTwoIsZero() {
        assertEquals(0, Heap.parentIndex(2));
    }
    
    public void testParentIndexOfThreeIsOne() {
        assertEquals(1, Heap.parentIndex(3));
    }
    
    public void testParentIndexOfSixIsTwo() {
        assertEquals(1, Heap.parentIndex(3));
    }
        
    public void testParentIndexOfEightIsThree() {
        assertEquals(3, Heap.parentIndex(8));
    }

//--------------------------------------------------------------------------------------------------

    public void testFirstChildIndexOfZeroIsOne() {
        assertEquals(1, Heap.firstChildIndex(0));
    }
    
    public void testFirstChildIndexOfOneIsThree() {
        assertEquals(3, Heap.firstChildIndex(1));
    }
    
    public void testFirstChildIndexOfTwoIsFive() {
        assertEquals(5, Heap.firstChildIndex(2));
    }
    
    public void testFirstChildIndexOfTheeIsSeven() {
        assertEquals(7, Heap.firstChildIndex(3));
    }
    
//--------------------------------------------------------------------------------------------------
    public void testJavaArrayInitialization() {
        int[] a = new int[3];
        assertEquals(0, a[0]);
        assertEquals(0, a[2]);
    }
    
    public void testToArrayReturnsAnEmptyArrayForAnUninitializedHeap() {
        assertArraysEqual(new int[0], h().toArray());
    }
    
    public void testInsertsFirstElement() {
        Heap h = h();
        h.insert(42);
        
        int[] expected = {42};
        
        assertArraysEqual(expected, h.toArray());
    }
    
    public void testInsertsMonotonicSecondElement() {
        Heap h = h();
        h.insert(1492);
        h.insert(2001);
        
        int[] expected = {1492, 2001};
        
        assertArraysEqual(expected, h.toArray());
    }
    
    public void testInsertsNonMonotonicSecondElement() {
        Heap h = h();
        h.insert(2001);
        h.insert(1492);
        
        int[] expected = {1492, 2001};
        
        assertArraysEqual(expected, h.toArray());
    }
    
//--------------------------------------------------------------------------------------------------
    
    private void assertArraysEqual(int[] expected, int[] actual) {
        assertEquals("Must have same length", expected.length, actual.length);
        
        for (int i  = 0; i < expected.length; ++i) {
            assertEquals("Values at index " + Integer.toString(i), expected[i], actual[i]);
        }
    }
    
    private static Heap h() {
        return new Heap();
    }
}
