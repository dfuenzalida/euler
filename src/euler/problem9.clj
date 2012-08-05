(ns euler.problem9)

;; A Pythagorean triplet is a set of 3 natural numbers, a  b  c, for which,
;;   a^2 + b^2 = c^2
;;
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;;
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product a * b * c.
;;

(defn euler-9 []
  (apply *
         (loop [a 1 b 1]
           ;; a + b + c = 1000 ==> c = 1000 - a - b
           (let [c (- 1000 a b)]
             (if (= a 999) (recur 1 (inc b))
                 (if (= (+ (* a a) (* b b)) (* c c)) [a b c]
                     (recur (inc a) b)))))))