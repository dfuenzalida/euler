(ns euler.problem14)

;; The following iterative sequence is defined for the set of positive
;; integers:
;;
;; n -> n/2    (n is even)
;; n -> 3n + 1 (n is odd)
;;
;; Using the rule above and starting with 13, we generate the
;; following sequence:
;;
;;   13 -> 40 ->  20 ->  10 ->  5 -> 16 ->  8 ->  4 -> 2 -> 1
;;
;; It can be seen that this sequence (starting at 13 and finishing at
;; 1) contains 10 terms. Although it has not been proved yet (Collatz
;; Problem), it is thought that all starting numbers finish at 1.
;;
;; Which starting number, under one million, produces the longest chain?
;;
;; NOTE: Once the chain starts the terms are allowed to go above one million.

(defn euler-14[]

  (defn seq-len [x]
    (loop [i 1 n x]
      (if (= n 1) i
          (if (= 0 (rem n 2))
            (recur (inc i) (/ n 2))
            (recur (inc i) (+ 1 (* 3 n)))))))

  (loop [i 1 max-pos 0 max-len 0]

    (if (= 1000000 i) [max-pos max-len] ;; 1000000 iterations
        (let [new-len (seq-len i)]
          (if (> new-len max-len)
            (recur (inc i) i new-len)
            (recur (inc i) max-pos max-len))))))

(println (euler-14))