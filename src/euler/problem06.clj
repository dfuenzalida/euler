(ns euler.problem06)

;; Find the difference between the sum of the squares of the first one
;; hundred natural numbers and the square of the sum.

(defn euler-6 []
  (defn square [x] (* x x))
  (-
   (square (reduce + (range 1 101)))
   (reduce + (map square (range 1 101)))))
