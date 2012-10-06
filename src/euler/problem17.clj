(ns euler.problem17)

;; If the numbers 1 to 5 are written out in words: one, two, three,
;; four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in
;; total.
;;
;; If all the numbers from 1 to 1000 (one thousand) inclusive were
;; written out in words, *how many letters would be used*?
;;
;; NOTE: Do not count spaces or hyphens. For example, 342 (three
;; hundred and forty-two) contains 23 letters and 115 (one hundred and
;; fifteen) contains 20 letters. The use of "and" when writing out
;; numbers is in compliance with British usage.

(defn euler-17 []

  (def smaller-numbers
    (vec (map name [:zero :one :two :three :four :five :six :seven :eight
                    :nine :ten :eleven :twelve :thirteen :fourteen :fifteen
                    :sixteen :seventeen :eighteen :nineteen])))
  (def tens
    (vec (map name [:zero :ten :twenty :thirty :forty :fifty :sixty
                    :seventy :eighty :ninety])))

  (defn as-words[n]
    (cond
     (= n 1000) "one thousand"
     (and (< n 1000) (> n 99))
       (str
         (smaller-numbers (quot n 100)) " hundred"
         (if (= 0 (rem n 100)) "" " and ") ;; any 100-remainder?
         (as-words (rem n 100)))
     (and (< n 100) (> n 19))
          (str (tens (quot n 10)) "-" (as-words (rem n 10)))
     (and (< n 20) (> n 0))
          (smaller-numbers n)
     :else ""))

  (defn clean[s] (.replaceAll s "[- ]" "")) ;; remove dashes and spaces

  ;; solution
  (apply + (map #(count (clean (as-words %))) (range 1 (inc 1000))))

  )

;; solution for numbers 1..5
;; (apply + (map #(count (smaller-numbers %)) (range 1 (inc 5))))

(println (euler-17))