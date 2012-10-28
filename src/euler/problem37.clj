(ns euler.problem37)

(defn euler-37 []

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

  (def primes (set (primes-up-to 800000)))

  (defn right-prime? [n]
    (if (< n 10) (primes n)
        (and (primes n) (right-prime? (quot n 10)))))

  (defn left-prime? [n]
    (if (< n 10) (primes n)
        (and (primes n) (left-prime? (Integer. (.substring (str n) 1))))))

  ;; primes over 10 which are both "left" and "right" primes, sum them
  (apply
   +
   (filter
    #(and (> % 7) (left-prime? %) (right-prime? %))
    primes)))

(println (euler-37))
