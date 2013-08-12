(ns euler.problem57)

(defn expansions []
  (loop [n 1000 ratios [3/2] x (+ 2 1/2)]
    (if (zero? n)
      ratios
      (let [current (+ 2 (/ 1 x))]
        (recur (dec n)
               (conj ratios (+ 1 (/ 1 current)))
               current)))))

(defn euler-57 []
  (count
   (filter
    #(> (count (str (numerator %))) (count (str (denominator %))))
    (expansions))))

(println (euler-57))

