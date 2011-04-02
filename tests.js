var Skiena = {};

Skiena.runTests = function () {
    module("Foundation");
    
    test("Explore QTest asserts with objects", function () {
        deepEqual({a: 1, b: 2}, {a: 1, b: 2});
        
        notDeepEqual(
            {a: 1, foo: function () {}},
            {a: 1, foo: function () {}}
        );
        
        var A = function (attr) {
            this.attr = attr;
            
            this.foo = function () {
                this.attr++;
            };
        };
        
        deepEqual(new A(1), new A(1));
        
        notDeepEqual(new A(1), new A(2));
    });
    
    module("TSP: nearest neighbor heuristic");
    
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
        strictEqual(5, point(0, 0).distanceTo(point(3, 4)));
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
        deepEqual(
            nearestNeighbourTour(circle()),
            [
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
            ]
        );
    });
    
    module("Quicksort");
    
    var unsortedArray = function () {
        return [51, 61, 50, 47, 56, 58, 42, 55, 43, 42,
            50, 57, 48, 64, 53, 55, 59, 46, 45, 49, 62, 44, 54, 64, 63, 52, 50, 60];
    };
    
    var sortedArray = function () {
        var result = unsortedArray();
        result.sort();
        return result;
    };
    
    test("Reality check for the test data", function () {
        strictEqual(sortedArray()[0], 42);
        strictEqual(sortedArray()[unsortedArray().length - 1], 64);
    });
    
    test("Reality check for passing arrays into functions", function () {
        var foo = function (a) {
            a[0] = "foo";
        };
        
        var anArray = [0, 0, 0];
        foo(anArray);
        
        strictEqual(anArray[0], "foo");
    });
    
    test("The quicksort itself", function () {
        deepEqual(quicksort(unsortedArray(), 0, unsortedArray().length - 1), sortedArray());
    });
};