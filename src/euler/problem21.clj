(ns euler.problem21)

;; Let d(n) be defined as the sum of proper divisors of n (numbers
;; less than n which divide evenly into n).
;;
;; If d(a) = b and d(b) = a, where a != b, then a and b are an
;; *amicable pair* and each of a and b are called *amicable numbers*.
;;
;; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
;; 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of
;; 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
;;
;; Evaluate the sum of all the amicable numbers under 10000.

(defn euler-21[]

  (defn divisors[x]
    (vec (filter #(= 0 (rem x %1)) (range 1 x))))

  (loop [i 1 numbers #{}] ;; Using a SET to avoid repeated pairs
    (if (= i 10000)
      (reduce + numbers)
      (do
        ;; (println (str i ": " numbers))
        (let [sum-a (reduce + (divisors i))]
          (let [sum-b (reduce + (divisors sum-a))]
            (if
                (and
                 (= i sum-b)
                 (not (= sum-a sum-b)))
              (recur (inc i) (conj (conj numbers i) sum-a))
              (recur (inc i) numbers))))))))

(println (euler-21))