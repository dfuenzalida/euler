(ns euler.problem81)

(def numbers [131  673  234  103   18
              201   96  342  965  150
              630  803  746  422  111
              537  699  497  121  956
              805  732  524   37  331])

(defn min'
  "Find the minimum of the args, discards non-numbers"
  [& args] (apply min (filter number? args)))

(defn between? [n a b] (and (>= n a) (<= n b)))

(defn update-matrix [matrix x y]
  (if (and
       (between? x 0 (dec (count matrix)))
       (between? y 0 (dec (count matrix))))
    (let [c (get-in matrix [y x])
          above (get-in matrix [(dec y) x])
          left (get-in matrix [y (dec x)])
          val (+ c (min' above left))]
      (update-in matrix [y x] (fn [_] val)))
    matrix))

(defn compute-sums [matrix]
  (loop [x 0
         y 1 ;; start right below the top-left corner
         m matrix]
    (if (and (= 5 x) (= 5 y))
      m
      (if (zero? y)
        (recur 0 (inc x) (update-matrix m x y))
        (recur (inc x) (dec y) (update-matrix m x y))))))

(defn euler-81 []
  (let [matrix (vec (map vec (partition 5 numbers)))]
    ;; => [[131 673 234 103 18] [201 96 342 965 150] [630 803 746 422 111]
    ;;     [537 699 497 121 956] [805 732 524 37 331]]

    ;; now I can do: (get-in matrix [0 1]) => 673
    ;; and (update-in matrix [0 1] (fn [_] 999)) => [[131 999 234 103 18]...
    (compute-sums matrix)))

(println (last (last (euler-81))))
