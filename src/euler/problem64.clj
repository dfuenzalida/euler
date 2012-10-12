(ns euler.problem64)

(defn euler-64 []

  ;; Up to 20 coeficients of the continued fraction as described on
  ;; http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
  ;; #Continued_fraction_expansion

  ;; straigth from wikipedia
  (defn a0 [n]
    (apply max (filter #(< (* % %) n) (range 1 n))))

  ;; straigth from wikipedia
  (defn coeficients [x]
    (println x)
    (loop [m 0 d 1 a (a0 x) coefs []]
      (if (= 400 (count coefs)) ;; up to 400 digits
        coefs
        (let [m2 (- (* d a) m)
              d2 (quot (- x (* m2 m2)) d)
              a2 (quot (+ (a0 x) m2) d2)]
          (recur m2 d2 a2 (conj coefs a2))))))

  ;; compare two copies of the period digits, find where they are equal
  (defn period-length [digits]
    (loop [length 1 d1 (drop 1 digits) d2 (butlast digits)]
      (if (seq d1)
        (if (= d1 d2)
          length
          (recur (inc length) (drop 1 d1) (butlast d2)))
        length)))

  ;; check if the number is not a perfect square
  (defn not-square? [i]
    (not (contains? (set (map #(* % %) (range 1 200))) i)))

  ;; count how many odd periods for non-square numbers between 1 and 10,000
  (defn count-odd-periods [n]
  (count
   (filter
    odd?
    (map #(period-length (coeficients %))
         (filter not-square? (range 1 (inc n)))))))

  (count-odd-periods 10000)
  )

(println (euler-64))
