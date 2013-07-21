(ns euler.problem43)

;; The number, 1406357289, is a 0 to 9 pandigital number because it is made
;; up of each of the digits 0 to 9 in some order, but it also has a rather
;; interesting sub-string divisibility property.

;; Let d1 be the 1st digit, d2 be the 2nd digit, and so on.
;; In this way, we note the following:

;; d2 d3 d4  = 406 is divisible by 2
;; d3 d4 d5  = 063 is divisible by 3
;; d4 d5 d6  = 635 is divisible by 5
;; d5 d6 d7  = 357 is divisible by 7
;; d6 d7 d8  = 572 is divisible by 11
;; d7 d8 d9  = 728 is divisible by 13
;; d8 d9 d10 = 289 is divisible by 17
;;
;; Find the sum of all 0 to 9 pandigital numbers with this property.


;; My naive, non-working version
;; (defn find-perms [perms pending]
;;   (if (empty? pending)
;;     perms
;;     (map
;;      (fn [p] (find-perms (map #(into % (list p)) perms) (disj pending p)))
;;      pending)))
;;
;; (find-perms [[] #{1 2 3}])

;; Borrowed permutations lib from
;; http://www.martinsahm.de/permutations-clojure.html

(defn insertions [x xs]
  (lazy-seq
   (map
    (fn [[h t]] (concat h (cons x t)))
    (map
     (fn [n] (split-at n xs))
     (range 0 (+ 1 (count xs)))))))

(defn permutations
  ([] ([]))
  ([xs]
     (reduce
      (fn [perms i]
        (mapcat
         (fn [y]
           (insertions i y))
         perms))
      [[(first xs)]]
      (rest xs))))

;; *** Borrowed functions end here ***

(def primes [1 2 3 5 7 11 13 17])

(defn good-triplet? [[[a b c] prime]]
  (zero? (rem (+ (* 100 a) (* 10 b) c) prime)))

(defn triplets [nums]
  (for [i (range 1 8)] [(vec (take 3 (drop i nums))) (primes i)]))

;; (def test-n [1 4 0 6 3 5 7 2 8 9])
;; (triplets test-n)
;; => ([[4 0 6] 1] [[0 6 3] 2] [[6 3 5] 3] [[3 5 7] 4] [[5 7 2] 5] [[7 2 8] 6] [[2 8 9] 7])

;; Thanks bbloom @ freenode, now I learned about "every?" :-)
(defn good-pandigital? [p]
    (every? true? (map good-triplet? (triplets p))))

(def good-ones
 (filter good-pandigital? (permutations (range 10))))

(println
 (reduce + (map #(Long. (apply str %)) good-ones)))

;; Run with
;; $ clj src/euler/problem43.clj
;; $ time clj src/euler/problem43.clj

;; real 0m33.112s
;; user 0m34.846s
;; sys  0m0.424s

