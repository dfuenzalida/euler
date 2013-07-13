(ns euler.problem19
  (:import (java.util Calendar)))

;; How many Sundays fell on the first of the month during the twentieth century
;; (1 Jan 1901 to 31 Dec 2000)?

(defn euler-19 []

  (defn sunday? [d m y]
    (let [cal (doto (Calendar/getInstance) (.set y (dec m) d))]
      (= Calendar/SUNDAY (.get cal Calendar/DAY_OF_WEEK))))

  (count
   (for [y (range 1901 (inc 2000)) m (range 1 (inc 12)) :when (sunday? 1 m y)] :ok)))

;; $ lein repl
;; user=> (use 'euler.problem19)
;; user=> (euler-19)
