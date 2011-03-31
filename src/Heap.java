/**
 * An integer min-heap. See http://en.wikipedia.org/wiki/Binary_heap 
 */
public class Heap {
    private int[] queue = new int[10000];
    private int queueLength = 0;
    
    public void insert(int x) {
        queue[queueLength] = x;
        ++queueLength;
        bubbleUp(queueLength - 1);
    }
    
    public int extractMin() {
        if (queueLength <= 0) return -1;
        --queueLength;
        
        int result = queue[0];
        
        queue[0] = queue[queueLength];
        bubbleDown(0);
        
        return result;
    }
    
//--------------------------------------------------------------------------------------------------    
    
    int[] toArray() {
        int[] result = new int[queueLength];
        
        for (int i = 0; i < queueLength; ++i) {
            result[i] = queue[i];
        }
        
        return result;
    }
    
    private void bubbleUp(int index) {
        if (-1 == HeapQueueSupport.parentIndex(index)) return;
        
        if (queue[index] < queue[HeapQueueSupport.parentIndex(index)]) {
            swap(index, HeapQueueSupport.parentIndex(index));
            bubbleUp(HeapQueueSupport.parentIndex(index));
        }
    }
    
    private void bubbleDown(int index) {
        if (index == queueLength - 1) return;
        
        int indexOfMin = indexOfMinElement(
            index,
            HeapQueueSupport.firstChildIndex(index),
            HeapQueueSupport.firstChildIndex(index) + 1
        );
        
        if (indexOfMin != index) {
            swap(index, indexOfMin);
            bubbleDown(indexOfMin);
        }
    }
    
    private int indexOfMinElement(int indexA, int indexB, int indexC) {
        if (indexB >= queueLength) return indexA;
        if (indexC >= queueLength) return indexOfMinElement(indexA, indexB);
        
        int minValue = Math.min(queue[indexA], Math.min(queue[indexB], queue[indexC]));
                        
        if (minValue == queue[indexA]) return indexA;
        else if (minValue == queue[indexB]) return indexB;
        else return indexC;
    }
    
    private int indexOfMinElement(int indexA, int indexB) {
        int minValue = Math.min(queue[indexA], queue[indexB]);
                        
        if (minValue == queue[indexA]) return indexA;
        else return indexB;
    }
    
    private void swap(int indexA, int indexB) {
        int originalA = queue[indexA];
        queue[indexA] = queue[indexB];
        queue[indexB] = originalA;
    }
}
