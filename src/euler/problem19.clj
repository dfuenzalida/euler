(ns euler.problem19
  (:import (java.util Calendar Locale TimeZone)
           (java.text SimpleDateFormat)))

;; How many Sundays fell on the first of the month during the twentieth century
;; (1 Jan 1901 to 31 Dec 2000)?

(defn euler-19 []

  (def datefmt (SimpleDateFormat. "dd/MM/yyyy"))
  (def weekday (SimpleDateFormat. "EEE" Locale/US))

  (count
   (for [y (range 1901 2001) m (range 1 (inc 12))
         :when (= "Sun" (.format weekday (.parse datefmt (format "01/%02d/%04d" m y))))]
     [:anything])))

;; $ lein repl
;; user=> (use 'euler.problem19)
;; user=> (euler-19)
