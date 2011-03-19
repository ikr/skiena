(define (factorial n)
    (if (< n 2)
        1
        (* n (factorial (- n 1)))))
        
(define (combination n k)
    (/
        (factorial n)
        (*
            (factorial k)
            (factorial (- n k)))))
            
(combination 44 6)
