(ns euler.problem19
  (:import (java.util Calendar Locale TimeZone)
           (java.text SimpleDateFormat)))

(defn euler-19 []

  (defn get-days []
    (def sdf-yyyy (SimpleDateFormat. "dd/MM/yyyy"))
    (def sdf-week (SimpleDateFormat. "EEE" Locale/US))

    (def start (Calendar/getInstance))
    (.setTime start (.parse sdf-yyyy "01/01/1901"))

    (def end (Calendar/getInstance))
    (.setTime end (.parse sdf-yyyy "31/12/2000"))

    (loop [days []]
      (if (.after start end) days
          (do
            (.add start Calendar/MONTH 1)
            (recur
             (conj days (.format sdf-week (.getTime start)))
             )))))

  (count (filter #(= "Sun" %1) (get-days))))

;; lein repl
;; (use 'euler.problem19)
;; (euler-19)