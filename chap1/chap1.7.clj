;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; p60 연습문제 1.17
;; 계산 단계가 logN 비례로 자라나는 곱셈 프로시저를 짜보라.
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

(defn fast-muliply-by-add [a b accmulator]
  (cond (= b 0) accmulator
        (even? b) (fast-muliply-by-add (fn_double a) (halve b) accmulator)
        :else (fast-muliply-by-add a (- b 1) (+ a accmulator))))

(defn multiply [a b]
  (fast-muliply-by-add a b 0))

(= (multiply 2 0) 0)
(= (multiply 2 1) 2)
(= (multiply 2 4) 8)
(= (multiply 2 5) 10)
(= (multiply 2 5001) 10002)
(= (multiply 2 1000) 2000)