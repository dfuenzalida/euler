(ns euler.problem35)

(defn euler-35 []

  (defn permutations
    "Returns the permutations of a circular number" [n]
    (map
     #(Integer. %)
     (map
      #(apply str (take (count (str n)) (drop % (str n n))))
      (range (count (str n))))))

  ;; test primality against a list of given primes
  (defn prime? [primes n]
    (if (< n 1) false ;; negative numbers are not prime!
        (loop [pos 0]
          (let [p (primes pos)]
            (if
                (or
                 (> (* p p) n)
                 (= pos (count primes)))
              true
              (if (zero? (rem n p)) false
                  (recur (inc pos))))))))

  ;; computes a list of primes to look up
  (defn primes-up-to [num]
    (loop [primes [2 3] current 3]
      (if (> current num) primes
          (if (prime? primes current)
            (recur (conj primes current) (+ 2 current))
            (recur primes (+ 2 current))))))

  (def primes (primes-up-to 1000000))

  ;; a prime is circular if the number of permutations is equal
  ;; to the number of primes made of its permutations
  (defn circular-prime? [n primes]
    (=
     (count (permutations n))
     (count (filter #(prime? primes %) (permutations n)))))

  ;; count the circular primes
  (count (set (filter #(circular-prime? % primes) primes)))
  )

(println (euler-35))