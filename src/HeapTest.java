import junit.framework.TestCase;

public class HeapTest extends TestCase {
    public void testParentIndexOfZeroReturnsAnInvalidValue() {
        assertEquals(-1, HeapQueueSupport.parentIndex(0));
    }

    public void testParentIndexOfOneIsZero() {
        assertEquals(0, HeapQueueSupport.parentIndex(1));
    }

    public void testParentIndexOfTwoIsZero() {
        assertEquals(0, HeapQueueSupport.parentIndex(2));
    }
    
    public void testParentIndexOfThreeIsOne() {
        assertEquals(1, HeapQueueSupport.parentIndex(3));
    }
    
    public void testParentIndexOfSixIsTwo() {
        assertEquals(1, HeapQueueSupport.parentIndex(3));
    }
        
    public void testParentIndexOfEightIsThree() {
        assertEquals(3, HeapQueueSupport.parentIndex(8));
    }

//--------------------------------------------------------------------------------------------------

    public void testFirstChildIndexOfZeroIsOne() {
        assertEquals(1, HeapQueueSupport.firstChildIndex(0));
    }
    
    public void testFirstChildIndexOfOneIsThree() {
        assertEquals(3, HeapQueueSupport.firstChildIndex(1));
    }
    
    public void testFirstChildIndexOfTwoIsFive() {
        assertEquals(5, HeapQueueSupport.firstChildIndex(2));
    }
    
    public void testFirstChildIndexOfTheeIsSeven() {
        assertEquals(7, HeapQueueSupport.firstChildIndex(3));
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
    
//--------------------------------------------------------------------------------------------------
    
    public void testInsertsFirstElement() {
        int[] expected = {42};
        assertArraysEqual(expected, h42().toArray());
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
    
    public void testInsertsThreeElements() {
        Heap h = h();
        h.insert(2);
        h.insert(1);
        h.insert(2);
        
        int[] expected = {1, 2, 2};
        
        assertArraysEqual(expected, h.toArray());
    }
    
//--------------------------------------------------------------------------------------------------
    
    public void testExtractMinReturnsMinusOneWhenTheHeapIsEmpty() {
        assertEquals(-1, h().extractMin());
    }
    
    public void testExtractMinReturnsTheOnlyElementInTheHeap() {
        assertEquals(42, h42().extractMin());
    }

    public void testExtractMinRemovesTheOnlyElementFromTheHeap() {
        Heap h = h42();
        h.extractMin();
        assertArraysEqual(new int[0], h.toArray());
    }
    
    public void testExtractMinShiftsTheQueueUp() {
        Heap h = h42();
        h.insert(43);
        h.insert(43);
        h.extractMin();
        
        int[] expected = {43, 43};
        assertArraysEqual(expected, h.toArray());
    }
    
    public void testExtractMinWorksCorrectlyForARandomHeap() {
        Heap h = h();
        h.insert(1963);
        h.insert(1945);
        h.insert(1804);
        h.insert(1865);
        h.insert(1492);
        h.insert(1776);
        h.insert(1941);
        h.insert(2001);
        h.insert(1783);
        h.insert(1918);
        
        int expected[] = {1492, 1776, 1783, 1804, 1865, 1918, 1941, 1945, 1963, 2001};
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], h.extractMin());
        }
        
        assertArraysEqual(new int[0], h.toArray());
    }
    
//--------------------------------------------------------------------------------------------------
    
    private void assertArraysEqual(int[] expected, int[] actual) {
        assertEquals("Must have same length", expected.length, actual.length);
        
        for (int i  = 0; i < expected.length; ++i) {
            assertEquals("Values at index " + Integer.toString(i), expected[i], actual[i]);
        }
    }
    
    private static Heap h42() {
        Heap h = h();
        h.insert(42);
        return h;
    }
    
    private static Heap h() {
        return new Heap();
    }
}
