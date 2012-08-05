(ns euler.problem4)

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
   (loop [x 100 y 100 palindromes []]
         (if (palin? (* x y))
             (recur (inc x) y (conj palindromes (* x y)))
           (if (> x 999) (recur 100 (inc y) palindromes)
             (if (> y 999) palindromes
               (recur (inc x) y palindromes)))))))