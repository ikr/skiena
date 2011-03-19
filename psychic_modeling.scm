(define (factorial n)
    (if (< n 2)
        1
        (* n (factorial (- n 1)))))
        
(define (combination-count n k)
    (/
        (factorial n)
        (*
            (factorial k)
            (factorial (- n k)))))
            
(combination-count 44 6)

(combination-count 15 4)
