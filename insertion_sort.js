var swap = function (items, indexA, indexB) {
    var originalIndexAValue = items[indexA];
    items[indexA] = items[indexB];
    items[indexB] = originalIndexAValue;
};

var sort = function (items) {
    var i, j, n = items.length;
    
    for (i = 1; i < n; i++) {
        j = i;
        
        while ((j > 0) && (items[j - 1] > items[j])) {
            swap(items, j - 1, j);
            j--;
        }
    }
};

var items = "INSERTIONSORT".split('');
sort(items);
print(items);