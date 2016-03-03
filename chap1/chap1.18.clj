;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; p60 연습문제 1.18
;; 예제 1.16, 1.17을 이용하여
;; 계산 단계가 로그 비례로 자라나는 반복 프로세스를 펼치도록,
;; 곱셈 프로시져를 짜보라.

(defn even? [n]
  (= (rem n 2) 0))

(even? 5)

(defn halve [a]
  (/ a 2))

(halve 1)
(halve 10)
(halve 4.6)

(defn double [a]
  (+ a a))

(double 3.5)
(double 3.4)
(double 3)

;; iterative process
(defn iterative-calculate [multiplicand muliplier product]
  (cond (= muliplier 0) product
        (even? muliplier) (iterative-calculate (double multiplicand)
                                               (halve muliplier)
                                               product)
        :else (iterative-calculate multiplicand
                                   (- muliplier 1)
                                   (+ multiplicand product))))

(defn muliply [a b]
  (iterative-calculate a b 0))

(= (muliply 2 0) 0)
(= (muliply 2 1) (* 2 1))
(= (muliply 2 2) (* 2 2))
(= (muliply 2 3) (* 2 3))
(= (muliply 2 4) (* 2 4))
(= (muliply 2 5) (* 2 5))
(= (muliply 2 6) (* 2 6))
(= (muliply 2 7) (* 2 7))
(= (muliply 2 8) (* 2 8))
(= (muliply 2 9) (* 2 9))
(= (muliply 2 10) (* 2 10))
(= (muliply 2 11) (* 2 11))
(= (muliply 34534 123434) (* 34534 123434))
