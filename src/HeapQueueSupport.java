public class HeapQueueSupport {
    public static int parentIndex(int index) {
        return (index > 0)? ((index - 1) / 2) : -1;
    }

    public static int firstChildIndex(int index) {
        return index * 2 + 1;
    }
}
