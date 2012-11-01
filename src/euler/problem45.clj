(ns euler.problem45)

(defn euler-45 []

  (def pents (set (map #(/ (* % (- (* 3 %) 1)) 2) (range 1 100001))))
  (def hexas (set (map #(* % (- (* 2 %) 1)) (range 1 100001))))

  (loop [i 286]
    (if (> i 1000000) :notfound
      (let [t (/ (* i (inc i)) 2)]
        (if (and (pents t) (hexas t))
          t
          (recur (inc i))))))
  )

(println (euler-45))