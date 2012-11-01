(ns euler.problem99)

(defn euler-99 []

  (def lines (clojure.string/split (slurp "base_exp.txt") #"\r\n"))

  ;; map line number to [ (exponent x log(base)) line-number]
  (def pairs
    (map
     (fn [n]
       (let [line (lines n)
             [b e] (clojure.string/split line #",")]
         [(* (Float. e) (Math/log (Float. b))) n]))
     (range (count lines))))

  ;; find the first (sort (numbers)) -> find the associated line
  (inc ((last (sort pairs)) 1))
  
  )

(println (euler-99))