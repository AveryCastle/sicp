(defn square [n]
  (* n n))

(defn divides? [a b]
  (= (rem a b) 0))

(< 2 (Math/sqrt 5))
(= (square 5) 25)

;; square랑 Math/sqrt랑 결과가 같은데, 왜 그런지 몰겠다. 둘다 해도 맞는거라면 뭘로 하는게 더 적절한건지...
;; 책 내용상 Math/sqrt가 맞는 거 같은데...
(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? n test-divisor) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(= (smallest-divisor 199) 199)
(= (smallest-divisor 1999) 1999)
(= (smallest-divisor 19999) 7)
