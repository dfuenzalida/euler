(ns euler.problem52)

;; It can be seen that the number, 125874, and its double, 251748,
;; contain exactly the same digits, but in a different order.
;;
;; Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x,
;; and 6x, contain the same digits.

(defn euler-52 []

  (defn good?[n]
    (apply = (map #(sort (seq (str (* n %)))) (range 1 6))))

  (loop [n 1]
    (if (> n 10000000) :nope
        (if (good? n) n
            (recur (inc n)))))
  )

(println (euler-52))