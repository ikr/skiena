var Skiena = {};

Skiena.runTests = function () {
    module("TSP");
    
    var circle = function () {
        return [
            point(0, 5),
            point(5, 0),
            point(0, -5),
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
    
    test("Points distance", function () {
        
    });
    
    test("Copying an array", function () {
        var arr = ["a", "b", "c"];
                
        deepEqual(copyArray(arr), arr);
    });
    
    test("arrayWithout", function () {
        deepEqual(["a", "c"], arrayWithout(["a", "b", "c"], 1));
    });
    
    test("findNearestPointIndex for one-element array", function () {
        strictEqual(findNearestPointIndex([point(0, 0)], point(100, 0)), 0);
    });
    
    test("findNearestPointIndex", function () {
        strictEqual(findNearestPointIndex(circle(), point(100, 0)), 1);
    });
    
    test("Nearest neighbor heuristic", function () {
        var expected = [
            point(0, 5),
            point(3, 4),
            point(4, 3),
            point(5, 0),
            point(4, -3),
            point(3, -4),
            point(0, -5),
            point(-3, -4),
            point(-4, -3),
            point(-5, 0),
            point(-4, 3),
            point(-3, 4)
        ];
        
        var actual = nearestNeighbourTour(circle());
        
        deepEqual(point(1, 2), point(1, 2));
        
        deepEqual(actual, expected);
    });
};