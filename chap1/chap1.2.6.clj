;; p64~68 약수 찾기
;; fermat 검사는 정확한 답이 나오지 않고 어림잡은 답만 나온다.
;; 다시 말해, 어떤 수 n이 fetmat 검사를 모두 거쳤다고 해도 n이 소수라고 잘라 말하지 못한다.
;; 그저 그럴 확률이 높을 뿐이다.

(defn divides? [a b]
  (= (rem a b) 0))

;;(= (divides? 6 3) true)

(defn find-divisor [n test-divisor]
  (cond (> (Math/sqrt test-divisor) n) n
        (divides? n test-divisor) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(= (prime? 1) true)
(= (prime? 2) true)
(= (prime? 3) true)
(= (prime? 4) false)
(= (prime? 5) true)
(= (prime? 6) false)
(= (prime? 7) true)
(= (prime? 8) false)
(= (prime? 9) false)
(= (prime? 10) false)
(= (prime? 11) true)
(= (prime? 12) false)
(= (prime? 13) true)
(= (prime? 17) true)
(= (prime? 19) true)
(= (prime? 23) true)
(= (prime? 29) true)
(= (prime? 31) true)
(= (prime? 37) true)
(= (prime? 41) true)


;; p66
(defn square [n]
  (* n n))

(square 1)
(square 2)
(square 3)
(square 4)

(defn expmod [base exp m]
  (cond (= exp 0) 1
        (even? exp) (rem (square (expmod  base
                                          (/ exp 2)
                                          m))
                         m)
        :else (rem (* base (expmod base
                                   (- exp 1)
                                   m))
                   m)))

(even? 1)
(even? 2)
(even? 3)
(even? 4)

(expmod 1 11 1)
(expmod 1 11 2)
(expmod 1 11 3)
(expmod 1 11 4)


(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

;; 결과값이 계속 바뀐다.
(farmat-test 1)
(farmat-test 2)
(farmat-test 3)
(farmat-test 4)
(farmat-test 5)
(farmat-test 6)
(farmat-test 7)
(farmat-test 8)
(farmat-test 9)
(farmat-test 10)
(farmat-test 11)
(farmat-test 12)
(farmat-test 13)
(farmat-test 14)
(farmat-test 15)
(farmat-test 16)
(farmat-test 17)
(farmat-test 18)
(farmat-test 19)
(farmat-test 20)

(defn fast-prime? [n times]
  (cond (= times 0) true
        (fermat-test n) (fast-prime? n (- times 1))
        :else false))

;; 결과값이 계속 바뀐다.
(fast-prime? 3 1)
(fast-prime? 3 2)
(fast-prime? 3 3)

(fast-prime? 4 1)
(fast-prime? 4 2)
(fast-prime? 4 3)
(fast-prime? 4 4)
