(ns euler.problem27)

(defn euler-27 []

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

  (def primes-up-to-10K (primes-up-to 10000))

  ;; count primes for a quadratic poly given a and b, from n = 0
  (defn count-primes [a b]
    (loop [n 0 counter 0]
      (let [p (+ (* n n) (* a n) b)]
        (if (prime? primes-up-to-10K p)
          (recur (inc n) (inc counter))
          counter))))

  ;; validation:
  ;; (count-primes 1 41)) ;; 40
  ;; (count-primes -79 1601)) ;; 80

  ;; iterate and find the largest sequence
  (loop [a -999 b -999 max-count 0 max-a 0 max-b 0]
    (if (= 1000 a) [max-a max-b]
        (if (= 1000 b) (recur (inc a) -999 max-count max-a max-b)
            (let [c (count-primes a b)]
              (if (>= c max-count)
                (recur a (inc b) c a b)
                (recur a (inc b) max-count max-a max-b)))))))

(println (euler-27))
