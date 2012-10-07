(ns euler.problem26
  (:import (java.math BigDecimal)))

;; A unit fraction contains 1 in the numerator. The decimal
;; representation of the unit fractions with denominators 2 to 10 are
;; given:
;;
;;     1/2  = 0.5
;;     1/3  = 0.(3)
;;     1/4  = 0.25
;;     1/5  = 0.2
;;     1/6  = 0.1(6)
;;     1/7  = 0.(142857)
;;     1/8  = 0.125
;;     1/9  = 0.(1)
;;     1/10 = 0.1
;;
;; Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
;; It can be seen that 1/7 has a 6-digit recurring cycle.
;;
;; Find the value of d < 1000 for which 1/d contains the longest
;; recurring cycle in its decimal fraction part.

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