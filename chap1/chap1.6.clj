(defn square[x] (* x x))

(square 3)

(defn sum-of-squares[x y] (+ (square x) (square y)))

(sum-of-squares 3 5)

(defn f[a] (sum-of-squares (+ a 1) (* a 2)))

(f 5)

(defn abs[n]
  (cond
    (< n 0) (* -1 n)
    (> n 0) n
    :else 0
  )
)

(defn abs[n]
  (cond
    (< n 0) (* -1 n)
    :else n
  )
)

(defn abs[n]
  (if (< n 0) (* -1 n) n)
)

(defn between_5_and_10[n]
  (and (>= n 5) (<= n 10))
)

;; 연습문제 1.1
10
;; 10

(+ 5 3 4)
;; 12

(- 9 1)
;;8

(+ (* 2 4) (- 4 6))
;; 6

(def a 3)
;; nothing, a == 3

(def b (+ a 1))
;; nothing, b == 4

(+ a b (* a b))
;; 19

(if (and (> b a) (< b (* a b)))
  b
  a
)
;; b == 4

(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25
)
;; 16

(+ 2 (if (> b a) b a))
;; 6

(* (cond (> a b) a
         (< a b) b
         :else -1
   )
  (+ a 1)
)
;; 16

;; 연습문제 1.2
(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5))))) (* 3 (- 6 2) (- 2 7)))

;; 연습문제 1.3
(defn sum-of-squares[n1 n2]
  (+ (* n1 n1) (* n2 n2))
)

(defn calculate-max-num[n1 n2 n3]
  (if (>= n1 n2)
    (if (>= n2 n3)
      (sum-of-squares n1 n2)
      (sum-of-squares n1 n3)
    )
    (if (< n2 n3)
      (sum-of-squares n2 n3)
      (if (>= n1 n3)
        (sum-of-squares n2 n1)
        (sum-of-squares n2 n3)
      )
    )
  )
)

;; 연습문제 1.4
(defn a-plus-abs-b [a b]
  ((if (> b a) + -) a b)
)

;; 연습문제 1.5
(def p p)

(defn testing [x y]
  (if (= x 0)
    0
    y))

;; 1.1.7 연습: 뉴튼 법으로 제곱근 찾기
(defn average [x y]
  (/ (+ x y) 2)
)

(defn improve [guess x]
  (average guess (/ x guess)))


(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)
  )
)

(defn sqrt[x]
  (sqrt-iter 1.0 x)
)

(sqrt 9)

(sqrt (+ 100 37))

(sqrt (+ (sqrt 2) (sqrt 3)))

(square (sqrt 1000))

;; 연습문제 1.6
;;  (defn new-if [predicate then-clause else-clause]
;;    (cond predicate then-clause
;;          :else else-clause))
;;  (new-if (> 2 3) 1 0)
;;  (new-if (> 4 3) 1 0)
;;  (defn wrong-iter [x y]
;;    (new-if (> x y)
;;      x
;;      (wrong-iter (+ x 1) y)))
;;  (wrong-iter 1 3)


;; 연습문제 1.7
;;(defn good-enough? [guess x]
;;  (< (abs (- (square guess) x)) 0.001)
;;)

(good-enough? 299999.9 90000000000) ;; false
(good-enough? 299999.999999999 90000000000) ;; true
(good-enough? 0.001 0.00000000001) ;;true

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.01)
)

(good-enough? 299999.9 90000000000) ;; false
(good-enough? 299999.99999999 90000000000) ;; true
(good-enough? 0.01 0.00000000001) ;;true
(good-enough? 1 0.99) ;; false


;; 연습문제 1.8
(defn cube[x] (* x x x))

(defn cube-average [x y]
  (/ (+ x y) 3))

(defn cube-good-enough? [guess x]
  (< (abs (- (cube guess) x)) 0.0001))

(defn cube-improve [guess x]
  (float (cube-average (/ x (square guess)) (* 2 guess))))

(defn cube-iter [guess x]
  (if (cube-good-enough? guess x)
    guess
    (cube-iter (cube-improve guess x)
               x)))

(cube-iter 10 1000)
(cube-iter 7 (* 7 7 7))
(cube-iter 5 125)
(cube-iter 4 65)


;; p38
;;(defn sqrt [x]
;;  (sqrt-iter 1.0 x))
;;
;;(def sqrt-iter [guess x]
;;  (if (good-enough? guess x)
;;    guess
;;    (sqrt-iter (improve guess x) x)))
;;
;;(defn good-enough? [guess x]
;;  (< (abs (- (square gess) x)) 0.001))
;;
;;(defn improve [guess x]
;;  (average guess (/ x guess)))
;;
;;;;;;;;;;;;
;;
;;(defn sqrt [x]
;;  (defn (good-enough? guess x)
;;    (< (abs (- (square gess) x)) 0.001))
;;  (defn improve [guess x]
;;    (average guess (/ x guess)))
;;  (defn sqrt-iter [guess x]
;;    (if (good-enough? guess x)
;;      guess
;;      (sqrt-iter (improve guess x) x)))
;;  (sqrt-iter 1.0 x))
;;
;;;;;;;;;;;;;;;;;;;
;;
;;(defn sqrt [x]
;;  (defn (good-enough? guess)
;;    (< (abs (- (square gess) x)) 0.001))
;;  (defn improve [guess]
;;    (average guess (/ x guess)))
;;  (defn sqrt-iter [guess]
;;    (if (good-enough? guess x)
;;      guess
;;      (sqrt-iter (improve guess))))
;;  (sqrt-iter 1.0 x))
