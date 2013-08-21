(ns euler.problem67)

(defn read-numbers [filename]
  (map
   #(Integer. %)
   (.split (.replaceAll (slurp filename) "\n" " ") " +")))

(defn as-vectors [numbers]
  "Splits seq of numbers in vectors of incresing size: [1] [2 3] [4 5 6] ..."
  (loop [vects [] n 1 numbers numbers]
    (if (seq numbers)
      (recur (conj vects (into [] (take n numbers))) (inc n) (drop n numbers))
      vects)))

(defn compute-max [a b]
  "Computes one step of the algorithm by merging 2 consecutive rows a and b"
  (let [a (into a [0])] ;; add a 0 for padding, solves edge case
    (vec
     (for [i (range (count a))]
       (if (zero? i)
         (+ (a 0) (b 0))
         (+ (b i)
            (max (a (dec i)) (a i))))))))

(defn loop-max [rows]
  (loop [top (first rows)
         rows (rest rows)]
    (if (seq rows)
      (recur (compute-max top (first rows)) (rest rows))
      ;; no more rows? then just return the max of the top row
      (reduce max top))))

(defn euler-67 []
  (loop-max
   (as-vectors (read-numbers "triangle.txt"))))

(println (euler-67))
