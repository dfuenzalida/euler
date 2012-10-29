(ns euler.problem44)

(defn euler-44 []

  (defn penta [n] (/ (* n (- (* 3 n) 1)) 2))
  (def pents (set (map penta (range 1 10001))))

  (defn both-penta? [[x y]]
    (let [a (penta x) b (penta y)]
      (and (pents a) (pents b) (pents (+ a b)) (pents (- a b)))))

  (first (map
   #(- (penta (first %)) (penta (second %)))
   (filter both-penta?
           (for [x (range 1 3001) y (range 1 3001) :while (< y x)] [x y]))))

  )

(println (euler-44))