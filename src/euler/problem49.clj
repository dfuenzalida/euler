(ns euler.problem49)

;; The arithmetic sequence, 1487, 4817, 8147, in which each of the
;; terms increases by 3330, is unusual in two ways: (i) each of the
;; three terms are prime, and, (ii) each of the 4-digit numbers are
;; permutations of one another.
;;
;; There are no arithmetic sequences made up of three 1-, 2-, or
;; 3-digit primes, exhibiting this property, but there is one other
;; 4-digit increasing sequence.
;;
;; What 12-digit number do you form by concatenating the three terms
;; in this sequence?

(defn euler-49 []

  (defn prime? [n] (= 0 (count (filter #(= 0 (rem n %)) (range 2 n)))))

  (def four-digit-primes (filter prime? (range 1000 9999)))

  ;; for all the 4 digit primes, sort the digits, increase the count
  ;; on a map, then filter the map entries with a count of 4 or more
  (defn count-primes [primes-list]
    (loop [primes primes-list total {}]
      (if (empty? primes)
        total
        (let [p (first primes)]
          ;; s = convert prime p to string, digits sorted
          (let [s (apply str (sort (str p)))]
            (if (total s)
              (recur (rest primes) (conj total {s (conj (total s) p)}))
              (recur (rest primes) (conj total {s [p]}))))))))

  (def prime-count (count-primes four-digit-primes))

  ;; lists of primes of 3 or more elements which are permutations of one another
  (def prime-lists
    (filter #(>= (count %1) 3) (vals prime-count)))

  (defn upto-size-3 [lists]
    (if (= 0 (count (filter #(> (count %) 3) lists)))
      lists
      ;; build new lists, if it's size 3 or less, leave
      ;; if it's size 4 or larger, build lists by remove 1 at a time
      (loop [new-lists [] orig-lists lists]
        (if (= 0 (count orig-lists))
          ;; new-lists
          (upto-size-3 new-lists)
          (if (= 3 (count (first orig-lists)))
            (recur (conj new-lists (first orig-lists)) (rest orig-lists))
            ;; lists of 4 or more, remove each
            (let [vect (first orig-lists)]
              (recur
               (reduce conj new-lists (map #(vec (disj (set vect) %)) vect))
               (rest orig-lists))))))))

  ;; (filter
  ;;  #(contains? %1 (/ (apply + %1) 3))
  ;;   (upto-size-3 prime-lists)))
  ;; (filter #(= (+ (first %) (nth % 3)) (+ (second %) (nth % 2))) prime-lists))
  ;; (sort prime-lists))

  ;; test: produce lists from sets of size 11
  ;; (upto-size-3 (filter #(= (count %) 11) prime-lists))

  (def l4 (upto-size-3 (filter #(= (count %) 4) prime-lists)))

  (filter #(contains? (set %) (/ (apply + %) 3)) l4))

  (println (euler-49))
