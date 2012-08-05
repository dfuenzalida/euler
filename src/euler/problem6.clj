(ns euler.problem6)

(defn euler-6 []
  (defn square [x] (* x x))
  (-
   (square (reduce + (range 1 101)))
   (reduce + (map square (range 1 101)))))
