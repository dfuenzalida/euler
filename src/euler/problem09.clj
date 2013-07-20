(ns euler.problem09)

;; A Pythagorean triplet is a set of 3 natural numbers, a  b  c, for which,
;;   a^2 + b^2 = c^2
;;
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;;
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product a * b * c.

(defn euler-9 []
  (for [x (range 1 1000) y (range x 1000)
        :let [z (- 1000 x y)]
        :when (= (+ (* x x) (* y y)) (* z z))]
    (* x y z)))
