(ns euler.problem39)

(defn euler-39 []

  ;; If p is the perimeter of a right angle triangle with integral
  ;; length sides, {a,b,c}, there are exactly three solutions for
  ;; p = 120
  ;;
  ;; {20,48,52}, {24,45,51}, {30,40,50}
  ;;
  ;; For which value of p <= 1000, is the number of solutions maximised?

  (defn valid? [triplet]
    (let [a (first (sort triplet))
          b (second (sort triplet))
          c (nth (sort triplet) 2)]
      (= (* c c) (+ (* a a) (* b b)))))

  (defn all-triangles [perimeter]
    (for [a (range 1 (inc perimeter))
          b (range 1 (inc perimeter))
          :while (and
                  (< b a)
                  (< (+ a b) perimeter))]
      [a b (- perimeter a b)]))

  (loop [i 3 max-index 0 max-count 0]
    (if (= 1001 i)
      [max-index max-count]
      (let [c (count (filter valid? (all-triangles i)))]
        (if (> c max-count)
          (recur (inc i) i c)
          (recur (inc i) max-index max-count)))))

  )

(println (euler-39))
