(ns euler.problem26
  (:import (java.math BigDecimal)))

(defn euler-26 []

  (def decimal-places 5000)

  (loop [i 1 d 2 cicle ""]
    (if (= i 1001)
      [d cicle] ;; return the number and cicle
      (let [fraction (.divide 1M (BigDecimal. i) decimal-places BigDecimal/ROUND_FLOOR)
            frac-str (str fraction)
            frac-res (re-find #"([0-9]*?)([0-9]+?)\2\2([0-9]+?)" frac-str)]
          (if (> (count (frac-res 2)) (count cicle))
            (recur (inc i) i (frac-res 2))
            (recur (inc i) d cicle)))))

  )

(println (euler-26))