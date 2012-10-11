(ns euler.problem24
  (:import [java.text DecimalFormat]))

(defn euler-24 []

  ;; Simple bruteforce version: iterate all numbers from 123456789
  ;; until 987654321, see which of them are formed with the all the
  ;; digits from 0 to 9. Takes several hours.
  ;;
  ;; (def df (DecimalFormat. "0000000000"))
  ;;
  ;; (loop [i 123456780 n 0]
  ;;   (if (or (= n 1000001) (= i 9876543219)) (dec i)
  ;;       (if (= [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9] (sort (.format df i)))
  ;;         (do
  ;;           (println (str (.format df i) " #" n))
  ;;           (recur (inc i) (inc n)))
  ;;         (recur (inc i) n)))))


  ;; Quick version: keep the count on an atom, use recursion to
  ;; compute each combination, increase the count in the bottom of the
  ;; recursion tree. If the count reaches 1,000,000 then print the
  ;; current iteration and exit violently :-)

  (def counter (atom 1))

  (defn except [elem vect]
    (vec (filter #(not (= elem %)) vect)))

  (defn iter [done pending]
    (if (seq pending)
      (map #(iter (conj done %) (except % pending)) pending)
      (do
        (swap! counter inc)
        (if (> @counter 1000000)
          (do
            (println done)
            (System/exit 0))))))

  (iter [] [0 1 2 3 4 5 6 7 8 9])

  )

  (println (euler-24))
