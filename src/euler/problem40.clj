(ns euler.problem40)

(defn euler-40 []

  ;; concatenate 1 to 200000 - memory is cheap :-)
  (def digits (vec (apply str (range 0 200000))))

  (defn nth-digit [n] (- (int (digits n)) (int \0)))

  ;; (nth-digit 12)
  (*
   (nth-digit 1)
   (nth-digit 10)
   (nth-digit 100)
   (nth-digit 1000)
   (nth-digit 10000)
   (nth-digit 100000)
   (nth-digit 1000000)
   ))

(println (euler-40))
