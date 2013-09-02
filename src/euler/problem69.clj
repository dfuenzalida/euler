(ns euler.problem69)

;; Begin helper functions
(defn read-numbers [filename]
  (map #(Integer. %) (.split (.replaceAll (slurp filename) "\n" " ") " +")))
(def primes (vec (read-numbers "primes-1m.txt")))
(def primes-set (set primes))
(defn prime? [x] (contains? primes-set x))
;; End of helper functions

(defn relative-primes? [a b]
  (loop [small-primes primes]
    (if (zero? (count small-primes))
      true ;; tried every prime, none could divide both
      (let [p (first small-primes)]
        (if (and (zero? (rem a p)) (zero? (rem b p)))
          false
          (recur (rest small-primes)))))))

(defn count-relative-primes [n]
  ;; (if (prime? n)
  ;;   (dec n) ;; When N is prime there are (dec n) relative primes
    (loop [i 1 c 0]
      (if (= i n)
        c
        (if (relative-primes? i n)
          (recur (inc i) (inc c))
          (recur (inc i) c)))))

(defn euler-69 []
  (println "starting...")
  (loop [n 2 x 2 max-q 2]
    (if (> n 1000000)
      x
      (let [qu (/ n (count-relative-primes n))]
        (println (str n " vs " max-q))
        (if (> qu max-q)
          (recur (inc n) n qu)
          (recur (inc n) x max-q))))))

(println (str "\n\n" (euler-69)))

;; Again got lucky using
;; user=> (* 2 3 5 7 11 13 17)
;; 510510

