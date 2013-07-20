(ns euler.problem02)

;; Each new term in the Fibonacci sequence is generated by adding the previous
;; two terms. By starting with 1 and 2, the first 10 terms will be:
;;
;;   1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;;
;; By considering the terms in the Fibonacci sequence whose values do
;; not exceed four million, find the sum of the even-valued terms.

(defn euler-2 []
  (defn fib-up-to
    ([x] (fib-up-to [1 2] x))
    ([y x] (let [z (+ (last y) (last (butlast y)))]
             (if
                 (> z x) y
                 (fib-up-to (conj y z) x)))))

  (reduce + (filter even? (fib-up-to 4000000))))

