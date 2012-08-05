(ns euler.problem1)

;; If we list all the natural numbers below 10 that are multiples
;; of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn euler-1 []
  (reduce
   +
   (filter #(or (zero? (mod %1 3)) (zero? (mod %1 5)))
           (range 1 1000))))

;; $ lein repl
;; user=> (use 'euler.core)
;; nil
;; user=> (euler-1)
;; 233168
