(ns euler.problem62)

;; The cube, 41063625 (345**3), can be permuted to produce two other cubes:
;; 56623104 (384**3) and 66430125 (405**3). In fact, 41063625 is the smallest
;; cube which has exactly three permutations of its digits which are also
;; cube.
;;
;; Find the smallest cube for which exactly five permutations of its digits
;; are cube.

(defn euler-62 []
  (loop [n 1
         perms {}] ;; map from "01234566" to [345 384 405]
    (let [cube (*' n n n)
          k  (apply str (sort (str cube))) ;; compute as string, sort digits
          nums (get perms k [])]
      (if (= (count nums) 4) ;; 4 existing + 1 new
        (let [x (first nums)]
          (*' x x x)) ;; return the cube of the first element
        (recur
         (inc n)
         (conj perms [k (into nums [n])]))))))

(println (euler-62))
