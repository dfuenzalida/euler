(ns euler.500digits
  (:import (java.math BigInteger)))

;; Find the last 500 digits of 3^12345678

(defn last-500-digits []

  ;; returns a string the last N chars from a string
  (defn last-n [n string]
    (if (> (.length string) n)
      (.substring string (- (.length string) n))
      string))

  ;; loop 12345678 times, keeping only the last 500 digits
  ;; at a time, which is much faster than handling numbers
  ;; of several 1000s of digits long.

  (loop [i 1 n 3]
    (if (= 12345678 i)
      (last-n 500 (str n))
      (recur
       (inc i)
       (BigInteger. (last-n 500 (str (*' 3 n))))))))

;; (.pow (BigInteger "3") 12345678) takes about an hour in my laptop
;; but the call below takes about 15 minutes

(println (last-500-digits))

;; 8715687278696432432994961010648380433496157202370140491508044974159183708
;; 2656464468069917302541842361942283164779911348011465471183299683768731207
;; 7284152095999433343004613914581466846112229120004724676918745932984264896
;; 2175585635959791328260686648424335662749740691523399893525847253119037931
;; 6665249840537485644261909612041603631373948800325493070406571863279221366
;; 9616526838406005450894579932263822893522677141680288821998458778326759800
;; 73150351381618596189829222460434447018788922211923389322503289