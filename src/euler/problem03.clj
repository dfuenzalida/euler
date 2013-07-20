(ns euler.problem03)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?
;; *** WARNING ***: TAKES ~2 MINUTES
(defn euler-3 []

  ;; test primality against a list of given primes
  (defn prime? [primes num]
    (loop [testing primes]
          (if (empty? testing) true
            (if (zero? (rem num (first testing))) false
              (recur (rest testing))))))

  (defn primes-up-to [num]
    (loop [primes [2 3] current 3]
      (if (> (* current current) num) primes
          (if (prime? primes current)
            (recur(conj primes current) (+ 2 current))
            (recur primes (+ 2 current))))))

  ;; return the last of the primes up to 600851475143 which is a
  ;; divisor of that number with zero reminder
  (last (filter #(zero? (rem 600851475143 %1)) (primes-up-to 600851475143))))

