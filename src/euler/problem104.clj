(ns euler.problem104)

(def digits #{\1 \2 \3 \4 \5 \6 \7 \8 \9})

(defn good-start? [n]
  (= digits (set (take 9 (str n)))))

(defn good-end? [n]
  (= digits (set (str (rem n 1000000000)))))

(defn euler-104 []
  (loop [a 1 b 1 n 1]
    ;; (print (str n "   ...\r"))
    (if (and (good-start? b) (good-end? b))
      (inc n)
        (recur b (+' a b) (inc n)))))

(println (str "\n\n" (euler-104)))

