(ns euler.problem56)

;; Considering natural numbers of the form, a^b, where a, b < 100,
;; What is the maximum digital sum?

(defn pow [a b]
  (reduce *' (for [x (range b)] a)))

(defn as-digits [number]
  (map #(- (int %1) (int \0)) (apply str number)))

(defn sum-digits [number]
  (reduce + (as-digits (str number))))

(println
 (apply max
  (for [a (range 1 101) b (range 1 101)] (sum-digits (pow a b)))))
