(ns euler.problem46)

(defn euler-46 []

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

  (def primes (primes-up-to 200000))
  (def primes-set (set primes))
  (def squares (map #(* % %) (range 1 1001)))

  (def odd-composites
    (drop 1
          (filter
           #(and (odd? %) (nil? (primes-set %)))
           (range 1 200000 2))))

  (defn good? [n]
    (let [small-primes (filter #(< % n) primes)
          small-squares (filter #(< % n) squares)
          to-test (set (for [x (filter #(< % n) small-primes)
                             y (filter #(< % n) small-squares)]
                         (+ x (* 2 y))))]
      (nil? (to-test n)))) ;; is N missing from the set to-test?

  (first (filter good? odd-composites))

  )

(println (euler-46))