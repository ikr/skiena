import junit.framework.TestCase;

public class HeapTest extends TestCase {
    public void testJavaArrayInitialization() {
        int[] a = new int[3];
        assertEquals(0, a[0]);
        assertEquals(0, a[2]);
    }
    
    public void testToArrayReturnsAnEmptyArrayForAnUninitializedHeap() {
        assertArraysEqual(new int[0], h().toArray());
    }
    
    private void assertArraysEqual(int[] a, int[] b) {
        assertEquals("Must have same length", a.length, b.length);
        
        for (int i  = 0; i < a.length; ++i) {
            assertEquals("Same values at index " + Integer.toString(i) + "expected", a[i], b[i]);
        }
    }
    
    private static Heap h() {
        return new Heap();
    }
}
