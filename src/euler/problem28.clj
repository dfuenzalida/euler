(ns euler.problem28
  (:import [java.text DecimalFormat]))

(defn euler-28 []

  (defn zero-grid
    "Creates a vector of N x N, full of zeros" [N]
    (vec (take (* N N) (repeatedly (constantly 0)))))

  (defn format-for-size
    "Returns a string with a 0 for each digit of a given size" [size]
    (loop [fmt "0" n 10]
      (if (> n size) fmt
          (recur (str "0" fmt) (* n 10)))))

  (defn grid-size "Returns the size of a square grid" [grid]
    (first (filter #(= (* % %) (count grid)) (range (count grid)))))

  (defn paint-grid "Set a number N at coords x, y on a grid G" [N G x y]
    (let [size (grid-size G) index (+ (* y size) x)]
      (if (or (< index 0) (> index (count G)))
        G ;; coords fall out of the grid, do noting
        (assoc G (+ (* y size) x) N))))

  (defn print-grid
    "Prints the grid using an appropriate column formatting" [grid]
    (let [size (grid-size grid)
          fmt (str (format-for-size (count grid)) " ")
          df (DecimalFormat. fmt)]
      (loop [i 0]
        (if (= i (count grid)) nil
            (do
              (if (= 0 (rem i size)) (println ""))
              (print (.format df (grid i)))
              (recur (inc i)))))))

  (def directions [[1 0] [0 1] [-1 0] [0 -1]])

  (defn draw-spiral [grid]
    (loop [g grid
           x (quot (grid-size grid) 2)
           y x
           n 1 ;; number at the position x, y
           direction 0 ;; [right, down, left, up]
           step 0
           phase 0 ;; phase 1 resets step to 0 and increases max-step
           max-step 1] ;; turn direction when step = max-step
      (do
        ;; debug
        ;; (println [n x y :dir direction :step step :phase phase :max max-step])
        (if (> n (count g)) g
            (recur
             (paint-grid n g x y)             ;; g
             (+ x ((directions direction) 0)) ;; x
             (+ y ((directions direction) 1)) ;; y
             (inc n)                          ;; n
             ;; direction
             (if (>= (inc step) max-step)
               (rem (inc direction) 4)
               direction)
             (rem (inc step) max-step)   ;; step
             ;; phase
             (if (>= (inc step) max-step)
               (rem (inc phase) 2)
               phase)
             ;; max-step
             (if (and
                  (= (inc step) max-step)
                  (= 1 phase))
               (inc max-step) max-step) ;; max-step
             )))))

  ;; (print-grid (draw-spiral (zero-grid 11)))
  (def the-spiral (draw-spiral (zero-grid 1001)))

  ;; final computation
  (+
   -1 ;; the 1 at the center is counted twice
   (reduce +
           (map the-spiral
                (range 0 (count the-spiral) (inc (grid-size the-spiral)))))
   (reduce +
           (map the-spiral
                (range
                 (dec (grid-size the-spiral))
                 (dec (count the-spiral))
                 (dec (grid-size the-spiral)))))
   )
  )

(println (euler-28))
