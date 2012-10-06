(ns euler.problem5)

(defn euler-5 []

  ;; try to divide by prime the numbers on nums:
  ;; if reminder is zero then apply division, else leave number untouched
  (defn mcm-step [nums prime]
    (map
     #(if (zero? (rem %1 prime)) (quot %1 prime) %1)
     nums))

  ;; finds the minimum common multiple between 2 numbers
  (defn find-mcm [a b]
    (loop [both [a b] mcm 1 primes [2 3 5 7 11 13 17 19]]
      (if (= [1 1] both) mcm
          (if (= both (mcm-step both (first primes)))
            (recur both mcm (rest primes))
            (recur
             (mcm-step both (first primes)) (* mcm (first primes)) primes)))))

  ;; reduce the MCM function on all the numbers 1..20
  (reduce find-mcm (vec (range 1 21))))
