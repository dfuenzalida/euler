(ns euler.problem125)

(defn palin? [n] (= (seq (str n)) (reverse (seq (str n)))))

(defn euler-125 [x]
  (let [max-n (int (Math/sqrt (/ x 2)))]
    (loop [i 1
           j 2
           totals #{}] ;; some numbers repeat! I use a set to store them
      (if (> i max-n)
        (reduce + totals)
        (if (> j max-n)
          (recur (inc i) (inc (inc i)) totals)
          (let [nums (range i (inc j))
                sum (reduce + (map #(* % %) nums))]
            (if (> sum x)
              (recur (inc i) (inc (inc i)) totals)
              (if (palin? sum)
                (do ;; (println sum) ;; progress
                  (recur i (inc j) (into totals [sum])))
                (recur i (inc j) totals)))))))))

(println (euler-125 100000000))
