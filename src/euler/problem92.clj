(ns euler.problem92)

(def squares [0 1 4 9 16 25 36 49 64 81])

;; Look-up table with numbers from the question itself
(def table (atom (into (zipmap [44 32 13 10 1] (cycle [1]))
                       (zipmap [85 89 145 42 20 4 16 37 58] (cycle [89])))))

(defn sum-squares [n]
  (reduce + (map #(squares (- (int %) 48)) (str n))))

(defn compute [n]
  ;; (if (zero? (rem n 1000)) (print (str n "   \r"))) ;; status
  (if (contains? @table n)
    (@table n)
    (loop [x (sum-squares n)]
      (if (or (= 89 x) (= 1 x))
        (do
          (swap! table assoc n x)
          x)
        (recur (sum-squares x))))))

(defn euler-92 [n]
  (count
   (for [i (range 1 n) :when (= 89 (compute i))] 1)))

(println (euler-92 10000000))

