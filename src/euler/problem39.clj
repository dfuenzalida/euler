(ns euler.problem39)

(defn euler-39 []

  (def terms
    (for [x (range 2 101) y (range 2 101)]
      (.pow (BigInteger. (str x)) y)))

  (count (apply conj #{} terms)))

(println (euler-39))
