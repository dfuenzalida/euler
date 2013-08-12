(ns euler.problem97)

;; Find the last 10 digits of 28433 × 2^7830457 + 1

(defn last-digits []
  (loop [x 1 n 7830457]
    (if (zero? n)
      (+ 1 (*' 28433 x))
      (if (> x 1000000000000000000)
        ;; Drop but the last 10 digits, convert to Long, keeps it fast
        (let [s (str x)]
          (recur (* 2 (Long. (apply str (drop (- (count s) 10) s))))
                 (dec n)))
        (recur (* 2 x) (dec n))))))

(def s (str (last-digits)))

(println (apply str (drop (- (count s) 10) s)))
