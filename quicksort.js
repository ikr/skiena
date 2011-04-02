var quicksort = function lambda(buffer, firstIndex, lastIndex) {
    if (firstIndex >= lastIndex) {
        return;
    }
    
    var swap = function (buffer, indexA, indexB) {
        var oldA = buffer[indexA];
        buffer[indexA] = buffer[indexB];
        buffer[indexB] = oldA;
    };
    
    var partition = function (buffer, firstIndex, lastIndex) {
        var pivotIndex = lastIndex;
        var firstNotSmallerValueIndex = firstIndex;
        var i;
        
        for (i = firstIndex; i < lastIndex; ++i) {
            if (buffer[i] < buffer[pivotIndex]) {
                swap(buffer, i, firstNotSmallerValueIndex);
                ++firstNotSmallerValueIndex;
            }
        }
        
        swap(buffer, firstNotSmallerValueIndex, pivotIndex);
        return firstNotSmallerValueIndex;
    };
    
    var pivotIndex = partition(buffer, firstIndex, lastIndex);
    lambda(buffer, firstIndex, pivotIndex - 1);
    lambda(buffer, pivotIndex + 1, lastIndex);
    
    return buffer;
};