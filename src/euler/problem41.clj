(ns euler.problem41)

(defn euler-41 []

  (defn n-pandigital? [n]
    (= (sort (seq (str n)))
       (take (count (str n)) [\1 \2 \3 \4 \5 \6 \7 \8 \9])))

  ;; my prime functions (sieve) are too slow, so this version uses the
  ;; file "primes1.txt" which can be downloaded from
  ;; http://primes.utm.edu/lists/small/millions/
  ;; this file contains the first million primes, which is a good
  ;; guess.
  ;;
  ;; Actually, I should test the first 6 million, where the
  ;; largest prime is 104,395,301 which contains more than 9 digits so
  ;; it can't be 9-pandigital.

  (def lines (clojure.string/split (slurp "primes1.txt") #"\n"))
  (def lines2 (clojure.string/join " " lines))
  (def primes (clojure.string/split lines2 #" +"))

  (last (filter n-pandigital? primes))

  )

(println (euler-41))