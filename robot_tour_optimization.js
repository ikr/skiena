var point = function (x, y) {
    var square = function (x) {
        return x * x;
    };
    
    return {
        "x": x,
        "y": y,

        distanceTo: function (otherPoint) {
            return Math.sqrt(square(x - otherPoint.x) + square(y - otherPoint.y));
        }
    };
};

var nearestNeighbourTour = function (points) {
    
};

var circle = function () {
    return [
        point(0, 5),
        point(5, 0),
        point(0, -5),
        point(-5, 0),
        point(-5, 0),
        point(3, 4),
        point(4, 3),
        point(4, -3),
        point(3, -4),
        point(-3, -4),
        point(-4, -3),
        point(-4, 3),
        point(-3, 4)
    ];
};

print(nearestNeighbourTour(circle()));