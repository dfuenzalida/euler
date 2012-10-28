(ns euler.problem33)

;; The fraction 49/98 is a curious fraction, as an inexperienced
;; mathematician in attempting to simplify it may incorrectly believe
;; that 49/98 = 4/8, which is correct, is obtained by cancelling the
;; 9s.
;;
;; We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
;;
;; There are exactly four non-trivial examples of this type of
;; fraction, less than one in value, and containing two digits in the
;; numerator and denominator.
;;
;; If the product of these four fractions is given in its lowest
;; common terms, find the value of the denominator.

(defn euler-33 []

  (defn curious? [[num den]]
    (let [n1 (quot num 10)
          n2 (rem  num 10)
          d1 (quot den 10)
          d2 (rem  den 10)]
      (or
       (and (> d2 0) (= n2 d1) (= (/ num den) (/ n1 d2)))
       (and (> d1 0) (= n1 d2) (= (/ num den) (/ n2 d1))))))

  (apply
   *
   (map #(/ (first %) (second %))
        (filter
         curious?
         (for [x (range 10 100) y (range 10 100) :while (< y x)] [y x])))))

(println (euler-33))