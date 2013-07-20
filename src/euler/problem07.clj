(ns euler.problem07)

;; What is the 10001st prime number?

(defn euler-7 []

  ;; test primality against a list of given primes
  (defn prime? [primes num]
    (loop [testing primes]
          (if (empty? testing) true
            (if (zero? (rem num (first testing))) false
              (recur (rest testing))))))

  (defn this-many-primes [num]
    (loop [primes [2 3] current 3]
      (if (= (count primes) num) primes
          (if (prime? primes current)
            (recur(conj primes current) (+ 2 current))
            (recur primes (+ 2 current))))))

  (last (this-many-primes 10001)))

