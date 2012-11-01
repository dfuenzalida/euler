(ns euler.problem55)

(defn euler-55 []

  (defn palin? [n] (= (seq (str n)) (reverse (seq (str n)))))

  (defn lychrel? [n]
    (loop [i 1 x n]
      (let [c (+' x (BigInteger. (apply str (reverse (str x)))))]
        (if (palin? c)
          false
          (if (>= i 50)
            true
            (recur (inc i) c))))))

  (count (filter lychrel? (range 1 10000)))
  )

(println (euler-55))