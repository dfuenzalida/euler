(ns euler.problem10)

;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;; Find the sum of all the primes below two million.

(defn euler-10 []

  ;; test primality against a list of given primes
  (defn prime? [primes n]
    (loop [pos 0]
      (if (= pos (count primes)) true
          (if (zero? (rem n (nth primes pos))) false
              (recur (inc pos))))))

  (defn primes-up-to [num]
    (loop [primes [2 3] current 3]
      (if (> current num) primes
          (if (prime? primes current)
            (recur (conj primes current) (+ 2 current))
            (recur primes (+ 2 current))))))

  (apply + (primes-up-to 2000000)))

(println (euler-10))

;; don't run this on `lein repl`, use the clj command line instead:
;; $ clj src/euler/problem10.clj
;; ... wait 5 minutes ...
;; => 142913828922