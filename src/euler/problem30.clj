(ns euler.problem30)

(defn euler-30 []

  (defn fifth[n] (* n n n n n))

  (defn curious? [n]
    (= n
       (reduce + (map #(fifth (- (int %) (int \0))) (str n)))))

  (apply + (filter curious? (range 11 10000000))))

(println (euler-30))
