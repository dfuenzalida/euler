(ns euler.problem48)

;; Find the last ten digits of the series:
;;   1^1 + 2^2 + 3^3 + ... + 1000^1000.

(defn euler-48[]

  ;; returns a string the last N chars from a string
  (defn last-n [n string]
    (if (> (.length string) n)
      (.substring string (- (.length string) n))
      string))

  (defn term [n]
    (loop [i 1 x n]
      (if (= i n)
        (BigInteger. (last-n 10 (str x)))
        (recur (inc i) (BigInteger. (last-n 10 (str (*' x n))))))))

  ;; LONG VERSION
  ;;(last-n 10 (str (apply +' (map term (range 1 1001)))))

  ;; SHORT VERSION (one liner)
  (rem
   (apply +' (map #(.pow (BigInteger. (str %)) %) (range 1 1001)))
   10000000000)
  )

(println (euler-48))
