;; p63
(defn gcd [a b]
  (if (= b 0)
  a
  (gcd b (rem a b))))

(= (gcd 206 40) 2)

;;p 64 연습문제 1.20
;; 맞바꿈 계산방법, 정의한 대로 구하는 프로세스(normal-order evaluation)
(gcd 206 40)

(if (= 40 0)
  206
  (gcd 40 (rem 206 40)))

(if (= (rem 206 40) 0) ;; b = 6, rem: 1 call
  40
  (gcd (rem 206 40) (rem 40 (rem 206 40))))

(if (= (rem 40 (rem 206 40)) 0) ;; b = 4, rem: 1 + 2 call
  (rem 206 40)
  (gcd (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40)))))

(if (= (rem (rem 206 40) (rem 40 (rem 206 40))) 0) ;; b = 2, rem: 1 + 2 + 4 call
  (rem 40 (rem 206 40))
  (gcd (rem (rem 206 40) (rem 40 (rem 206 40)))
       (rem (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40))))))

(if (= (rem (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40)))) 0) ;; b = 0, rem: 1 + 2 + 4 + 7 call
  (rem (rem 206 40)
       (rem 40 (rem 206 40))) ;; rem: 4 call
  (gcd (rem (rem 40 (rem 206 40))
            (rem (rem 206 40)
                 (rem 40 (rem 206 40))))
       (rem (rem (rem 206 40)
                 (rem 40 (rem 206 40)))
            (rem (rem 40 (rem 206 40))
                 (rem (rem 206 40)
                      (rem 40
                           (rem 206
                                40)))))))
;; 총 18 call


;; 인자먼저 계산법(applicative-order evaluation)
(gcd 206 40)

(if (= 40 0)
  206
  (gcd 40 (rem 206 40)))

(if (= 6 0)
  40
  (gcd 6 (rem 40 6)))

(if (= 4 0)
  6
  (gcd 4 (rem 6 4)))

(if (= 2 0)
  4
  (gcd 2 (rem 4 2)))

(if (= 0 0)
  2
  (gcd 0 (rem 2 0)))

;; 총 4번 호출



