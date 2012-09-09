(ns euler.problem25)

;; The Fibonacci sequence is defined by the recurrence relation:
;; F(n) = F(n-1) + F(n-2), where F(1) = 1 and F(2) = 1.
;;
;; Fib(12) is the first term of the Fibonacci sequence to contain 3
;; digits. What is the first term in the Fibonacci sequence to contain
;; 1000 digits?

(defn euler-25[]
  (loop [i 2 fibs [1 1]]
    (let [new-fib (+' (last (butlast fibs)) (last fibs))]
      (if (= (.length (str new-fib)) 1000) ;; more than 999 digits
        (inc i)
        (recur (inc i) (conj fibs new-fib))
      ))))

;; (println (euler-25))