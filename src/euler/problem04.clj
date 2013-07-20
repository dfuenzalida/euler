(ns euler.problem04)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of two 2-digit
;; numbers is 9009 = 91 x 99.
;;
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn euler-4 []

  ;; convert number to seq, compare it to the seq's reverse
  (defn palin? [x] (= (seq (str x)) (reverse (seq (str x)))))

  ;; max elem on a double loop from 100 to 999 looking for palindromes
  (reduce max
    (for [x (range 100 1000) y (range 100 1000) :when (palin? (* x y))] (* x y))))
