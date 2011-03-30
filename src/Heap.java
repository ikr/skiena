/**
 * An integer min-heap. See http://en.wikipedia.org/wiki/Binary_heap 
 */
public class Heap {
    private int[] queue = new int[10000];
    private int queueLength = 0;
    
    public int[] toArray() {
        int[] result = new int[queueLength];
        
        for (int i = 0; i < queueLength; ++i) {
            result[i] = queue[i];
        }
        
        return result;
    }

    public static int parentIndex(int index) {
        return (index > 0)? ((index - 1) / 2) : -1;
    }

    public static int firstChildIndex(int index) {
        return index * 2 + 1;
    }

    public void insert(int x) {
        queue[queueLength] = x;
        ++queueLength;
        bubbleUp(queueLength - 1);
    }
    
//--------------------------------------------------------------------------------------------------    
    
    private void bubbleUp(int index) {
        if (-1 == parentIndex(index)) return;
        
        if (queue[index] < queue[parentIndex(index)]) {
            swap(index, parentIndex(index));
            bubbleUp(parentIndex(index));
        }
    }
    
    private void swap(int indexA, int indexB) {
        int originalA = queue[indexA];
        queue[indexA] = queue[indexB];
        queue[indexB] = originalA;
    }
}
