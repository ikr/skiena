var square = function (x) {
    return x * x;
};

var point = function (x, y) {
    return {
        "x": x,
        "y": y,

        distanceTo: function (otherPoint) {
            return Math.sqrt(square(x - otherPoint.x) + square(y - otherPoint.y));
        }
    };
};

var firstPoint = function (namedPoints) {
    return Iterator(namedPoints).next()[0];
};

var nearestNeighbourTour = function (namedPoints) {
    
};

print(
    nearestNeighbourTour(
        {
            a: point(300, 0),
            b: point(400, 100),
            c: point(400, 200),
            d: point(300, 300),
            e: point(200, 300),
            f: point(100, 100),
        }
    )
);