(ns euler.problem16)

;; Problem 16:
;; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;;
;; What is the sum of the digits of the number 2^1000?

;; Java-interop version
(defn euler-16 []

  (import '(java.math BigInteger))
  (def two (BigInteger. "2"))
  (def power (str (.pow two 1000))) ;; 2^1000 as a string

  ;; sum digits
  (reduce
   +
   (map #(- (int %1) (int \0)) power)))