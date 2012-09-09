(ns euler.problem20)

(defn euler-20 []

  ;; Find the sum of the digits in the number 100!

  ;; factorial
  (defn factorial[n] (reduce *' (range 1 (inc n))))

  (reduce
   +
   (map
    #(- (int %1) (int \0))
    (str (factorial 100)))))
