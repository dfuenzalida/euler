(ns euler.problem38)

(defn euler-38 []

  (defn pandigital? [n]
    (= (sort (seq (str n))) [\1 \2 \3 \4 \5 \6 \7 \8 \9]))

  (defn conc-product [n]
    (loop [i 1 prod ""]
      (if (>= (count prod) 9)
        (Long. prod)
        (recur (inc i) (str prod (* n i))))))

  ;; find the max pandigital number after applying conc-prod from 1 to 100001
  (apply max (filter pandigital? (map conc-product (range 1 100001))))

  )

(println (euler-38))