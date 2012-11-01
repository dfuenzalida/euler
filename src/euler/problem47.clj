(ns euler.problem47)

(defn euler-47 []

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

  (def lots-of-primes (primes-up-to 200000))

  (defn four-factors? [n]
    (<= 4
     (count
      (filter
       #(= (rem n %) 0)
       (filter (fn [x] (< x n)) lots-of-primes)))))

  (def ff-set (set (filter four-factors? (range 1 200001))))

  (sort
   (filter
    ;; N and N+1 and N+2 and N+3 have 4+ prime factors
    #(and (ff-set %) (ff-set (+ 1 %)) (ff-set (+ 2 %)) (ff-set (+ 3 %)) )
   ff-set))

  )

(println (euler-47))