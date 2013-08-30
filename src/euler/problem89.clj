(ns euler.problem89)

(def roman-literals [1000 "M" 900 "CM" 500 "D" 400 "CD" 100 "C" 90 "XC"
                     50 "L" 40 "XL" 10 "X" 9 "IX" 5 "V" 4 "IV" 1 "I"])

(defn to-roman [n]
  (loop [output "" n n romans roman-literals]
    (if (zero? n)
      output
      (let [k (first romans) r (second romans)]
        (if (>= n k)
          (recur (str output r) (- n k) romans)
          (recur output n (drop 2 romans)))))))


(defn to-decimal [s]
  (loop [output 0 s s romans roman-literals]
    (if (zero? (count s))
      output
      (let [d (first romans) r (second romans)]
        (if (zero? (.indexOf s r))
          (recur (+ output d) (apply str (drop (count r) s)) romans)
          (recur output s (drop 2 romans)))))))

(defn saving [s]
  (- (count s) (count (to-roman (to-decimal s)))))

(defn euler-89 []
  (let [lines (vec (.split (slurp "roman.txt") "\n"))]
    (reduce + (map saving lines))))

(println (euler-89))
