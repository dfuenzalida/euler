(ns euler.problem34)

(defn euler-34 []

  (defn fact[n]
    (if (< n 1) 1 (reduce * (range 1 (inc n)))))

  (defn curious? [n]
    (= n
       (reduce + (map #(fact (- (int %) (int \0))) (str n)))))

  (apply + (filter curious? (range 11 100000))))

(println (euler-34))
