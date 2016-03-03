;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; p61 연습문제 1.19
(defn even? [n]
  (= (rem n 2) 0))

(even? 2)

(defn square [x]
  (* x x))

(defn fib-iter [a b p q count]
  (cond (= count 0) b
        (even? count) (fib-iter a
                                b
                                (+ (square p) (square q))
                                (+ (* 2 p q) (square q))
                                (/ count 2))
        :else (fib-iter (+ (* b q) (* a q) (* a p))
                        (+ (* b p) (* a q))
                        p
                        q
                        (- count 1))))

(fib-iter 1 0 0 1 0)
(fib-iter 1 0 0 1 1)
(fib-iter 1 0 0 1 2)
(fib-iter 1 0 0 1 3)

(fib-iter 2 1 1 1 0)
(fib-iter 1 0 0 1 2)

(defn fib [n]
  (fib-iter 1 0 0 1 n))

(= (fib 0) 0)
(= (fib 1) 1)
(= (fib 2) 1)
(= (fib 3) 2)
(= (fib 4) 3)
(= (fib 5) 5)
(= (fib 6) 8)
(= (fib 7) 13)
