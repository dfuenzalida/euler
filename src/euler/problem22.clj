(ns euler.problem22)

;; Using *names.txt*, a 46K text file containing over five-thousand
;; first names, begin by sorting it into alphabetical order. Then
;; working out the alphabetical value for each name, multiply this
;; value by its alphabetical position in the list to obtain a name
;; score.
;;
;; For example, when the list is sorted into alphabetical order,
;; COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name
;; in the list. So, COLIN would obtain a score of 938  53 = 49714.
;;
;; What is the total of all the name scores in the file?

(defn euler-22 []

  (defn score [word position]
    (*
     (reduce +
             (map #(inc (- (int %1) (int \A))) (seq word)))
     position))

  (defn names-to-list[]
    (def names-string (vec (.split (slurp "names.txt") ",")))
    (map #(.substring %1 1 (- (.length %1) 1)) names-string))

  (def names
    (vec (sort (names-to-list))))

  (loop [i 1 total 0]
    (if (> i (count names)) total
        (recur
         (inc i)
         (+ total (score (names (dec i)) i)))))
  )

(println (euler-22))