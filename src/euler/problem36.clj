(ns euler.problem36)

(defn euler-36 []

  (defn palin? [x] (= (apply str (reverse x)) x))

  (defn both-palin? [n]
    (and
     (palin? (str n))
     (palin? (Integer/toBinaryString n))))

  (apply + (filter both-palin? (range 1 1000000))))

(println (euler-36))
