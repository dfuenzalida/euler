(ns euler.problem53)

;; How many, not necessarily distinct, values of combinations of "n over r",
;; for 1 ≤ n ≤ 100, are greater than one-million?

(defn factorial [n]
  (reduce *' (range 2 (inc n))))

(defn combs [n r]
  (quot (factorial n)
        (*' (factorial r) (factorial (- n r)))))

;; Naive approach, simple but it works

(println
 (count
  (for [n (range 1 101)
        r (range 1 (inc n))
        :when (> (combs n r) 1000000)] :ok)))
