;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; p60 연습문제 1.17
;; 계산 단계가 logN 비례로 자라나는 곱셈 프로시저(Recursive Process)를 짜보라.
;; 계산단계가 b에 비례하게 자라남(선형 비례).
(defn * [a b]
  (if (= b 0)
    0
    (+ a (* a (- b 1)))))

(* 3 4)

;; 계산단계가 logN에 비례하게 자라남.
(defn even? [n]
  (= (rem n 2) 0))

(even? 5)

(defn halve [a]
  (/ a 2))

(halve 1)
(halve 10)
(halve 4.6)

(defn fn_double [a]
  (+ a a))

(fn_double 3.5)
(fn_double 3.4)
(fn_double 3)

(defn multiply [multiplicand multiplier]
  (cond (= multiplier 0) 0
        (even? multiplier) (multiply
                            (fn_double multiplicand)
                            (halve multiplier))
        :else (+ multiplicand (multiply
                               multiplicand
                               (- multiplier 1)))))

(= (multiply 3 0)  0)
(= (multiply 3 1)  3)
(= (multiply 3 2)  6)
(= (multiply 3 3)  9)
(= (multiply 3 4)  12)
(= (multiply 3 5)  15)
(= (multiply 3 6)  18)
(= (multiply 3 7)  21)
(= (multiply 3 8)  24)
(= (multiply 3 9)  27)
(= (multiply 3 10) 30)
(= (multiply 3 2023) 6069)
