(ns euler.problem31)

;; In England the currency is made up of pound, £, and pence, p, and
;; there are eight coins in general circulation:
;;
;; 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
;; It is possible to make £2 in the following way:
;;
;; 1 x £1 + 1 x 50p + 2 x 20p + 1 x 5p + 1 x 2p + 3 x 1p
;; How many different ways can £2 be made using any number of coins?

(defn euler-31 []

  ;; user=> (merge-with + {:uno 1 :dos 1 :tres 2} {:dos 1 :tres 1 :cuatro 4})
  ;; {:cuatro 4, :tres 3, :uno 1, :dos 2}

  (defn comb[n] (+ 0 n))

  (def comb-memo (memoize comb))

  ;; receive combinations of change and n money yet to be combined
  (defn comb[n]
    (if (< n 2)
      ({0 #{{}} 1 #{{1 1}}} n) ;; how to give 0 or 1 pence
      (loop [coins (filter #(<= % n) [1 2 5 10 20 50 100 200])
             combs #{}]
        ;; consider value 'coin', continue with the reminder (n - coin)
        (if (seq coins)
          (let [coin (first (seq coins))
                restcombs (comb-memo (- n coin))
                newcombs
                (for [c [{coin 1}] x restcombs] (merge-with + c x))]
            (recur (rest coins) (apply conj combs newcombs)))
          combs))))

  (count (comb 200)))

(println (euler-31))