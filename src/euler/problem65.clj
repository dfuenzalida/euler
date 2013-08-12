(ns euler.problem65)

;; Compute 120 coeficients
(def coefs
  (loop [n 1 coefs []]
    (if (= n 40)
      coefs
      (recur (inc n) (conj coefs 1 (* 2 n) 1)))))

;; Computes the n-th convergent
(defn compute [n]
  (loop [cs (rest (reverse (take n coefs)))
         conv (first (reverse (take n coefs)))
         rounds (dec n)]
    (if (zero? rounds)
      (+ 2 (/ 1 conv))
      (recur (rest cs) (+ (first cs) (/ 1 conv)) (dec rounds)))))

;; The 100-th convergent
(def conv-100 (compute (dec 100)))

(defn euler-65 []
  (reduce
   +
   (map #(- (int %) (int \0)) (str (numerator conv-100)))))

(println (euler-65))
