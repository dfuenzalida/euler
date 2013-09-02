(ns euler.problem243)

(defn resilience [d]
  ;; (print (str d "   \r"))
  (loop [i 1 r 0]
    (if (= i d)
      (/ r (dec d))
      (let [x (/ i d)]
        (if (= d (denominator x))
          (recur (inc i) (inc r))
          (recur (inc i) r))))))

(defn euler-243 [limit]
  (loop [i 2]
    (let [r (resilience i)]
      (if (< r limit)
        i
        (recur (inc i))))))


(println (str "\n\n" (euler-243 15499/94744)))
;; (println (str "\n\n" (euler-243 4/10)))

;; Processed up to 510,000 one-by-one, then gave up

;; user=> (double 15499/94744)
;; 0.1635881955585578

;; user=> (double (resilience (* 2 3 5 7 11 13 17 19 23)))
;; 0.1635881960888674

;; got lucky with:
;; user=> (* 2 2 2 3 5 7 11 13 17 19 23)
;; 892371480
;; user=> (time (double (resilience (* 2 2 2 3 5 7 11 13 17 19 23))))
;; "Elapsed time: 1188489.160245 msecs"
;; 0.1635881955389119
