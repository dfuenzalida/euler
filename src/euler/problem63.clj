(ns euler.problem63)

(defn good? [b p]
  (= p (count (str (reduce *' (take p (cycle [b])))))))

(def LIMIT 60) ;; 60-th power is good enough

(defn euler-63 []
  (count
   (for [a (range 1 (inc LIMIT))
         b (range 1 (inc LIMIT))
         :when (good? a b)]
     :ok)))

(println (euler-63))
