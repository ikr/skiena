var point = function (x, y) {
    var square = function (x) {
        return x * x;
    };
    
    return {
        "x": x,
        "y": y,

        distanceTo: function (otherPoint) {
            return Math.sqrt(square(this.x - otherPoint.x) + square(this.y - otherPoint.y));
        }
    };
};

var copyArray = function (a) {
    var ret = [];
    
    for (var i = 0; i < a.length; i++) {
        ret[i] = a[i];
    }
    
    return ret;
};

var arrayWithout = function (a, index) {
    return a.filter(function (e, eIndex) {
        return (eIndex !== index);
    });
};

var findNearestPointIndex = function (points, toPoint) {
    var d, result;
    
    for (var i = 0; i < points.length; i++) {
        if ((d === undefined) || (d > points[i].distanceTo(toPoint))) {
            d = points[i].distanceTo(toPoint);
            result = i;
        }
    }
    
    return result;
};

var nearestNeighbourTour = function (points) {
    var pool = copyArray(points);
    var result = [pool.shift()];
    
    while (pool.length > 0) {
        var nextPoolIndex = findNearestPointIndex(pool, result[result.length - 1]);
        result.push(pool[nextPoolIndex]);
        pool = arrayWithout(pool, nextPoolIndex);
    }
    
    return result;
};

var closestPairTour = function (points) {
    
};