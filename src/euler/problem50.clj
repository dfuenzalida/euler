(ns euler.problem50)

(def LIMIT 1000000)

;; Read primes from file as a convenience
(defn read-numbers [filename]
  (map
   #(Integer. %)
   (.split (.replaceAll (slurp filename) "\n" " ") " +")))

(def primes
  (vec (filter #(< % LIMIT) (read-numbers "primes-1m.txt"))))

(def primes-set (set primes))

(defn prime? [x]
  (contains? primes-set x))

(defn euler-50 []
  (loop [i 0 ;; index of starting prime in the list
         n 1 ;; number of items to count in the sum
         max-prime 0 ;; keep the maximum prime
         max-len 0]  ;; keep the maximum length
    (print (str "checking " (primes i) " ...\r")) ;; status
    (if (= i (dec (count primes)))
      max-prime ;; output maximum
      (let [x (reduce + (take n (drop i primes)))]
        (if (> x LIMIT)
          (recur (inc i) 1 max-prime max-len) ;; off the limit, move fwd
          (if (and (prime? x) (> n max-len))
            (recur i n x n) ;; new best maximum
            (recur i (inc n) max-prime max-len))))))) ;; continue looping

(println (str "\n\n" (euler-50)))

