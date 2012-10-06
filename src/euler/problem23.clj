(ns euler.problem23)

(defn euler-23 []

  (defn divisors [x]
    (loop [i 2 divisors #{}]
      (if (> (* i i) x)
        (conj divisors 1) ;; add '1' as a divisor
        (if (= (rem x i) 0)
          ;; keep i and x/i as divisors in a SET to discard duplicates
          (recur (inc i) (conj (conj divisors i) (/ x i)))
          (recur (inc i) divisors)))))

  (defn abundant? [x] (> (apply + (divisors x)) x))

  (def abundants (filter abundant? (range 1 (inc 28123))))

  ;; take all the numbers in the range 1 -> 28123 and discard those
  ;; which can be expressed as the sum of 2 abundant numbers, then sum all

  (reduce +
   (loop [all (set (range 1 28124)) ab1 abundants ab2 abundants]
     (if (empty? ab2)
       all
       (if (empty? ab1)
         (recur all abundants (rest ab2))
         (let [sum (+ (first ab1) (first ab2))]
           (recur (disj all sum) (rest ab1) ab2)))))))

(println (euler-23))
