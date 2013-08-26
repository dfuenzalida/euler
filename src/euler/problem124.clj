(ns euler.problem124)

;; Begin helper functions
(defn read-numbers [filename]
  (map #(Integer. %) (.split (.replaceAll (slurp filename) "\n" " ") " +")))
(def primes (vec (read-numbers "primes-1m.txt")))
(def primes-set (set primes))
(defn prime? [x] (contains? primes-set x))
;; End of helper functions

(defn factors
  "Vector of the different prime factors of n"
  [n]
  (loop [n n ps primes-set ftors #{}]
    (if (= n 1)
      (vec ftors)
      (let [fp (first ps)]
        (if (zero? (rem n fp))
          (recur (/ n fp) ps (into ftors [fp]))
          (recur n (rest ps) ftors))))))

(defn rad
  "Product of the distinct prime factors of n"
  [n] (reduce * (factors n)))

(defn get-ordered
  "Sort pairs of numbers by the second element"
  [pairs n]
  (first
   (nth
    (vec (sort #(- (second %1) (second %2)) pairs))
    (dec n))))

(defn euler-124 []
  (let [unsorted (map #(vec [% (rad %)]) (range 1 (inc 100000)))]
    (get-ordered unsorted 10000)))

(println (euler-124))
