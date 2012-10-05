(ns euler.problem15)

;; Problem #15:
;;
;; ==== My first solution ====
;;
;; Starting in the top left corner of a 2x2 grid, there are 6 routes
;; (without backtracking) to the bottom right corner.
;;
;; Route 1: right, right, down, down
;; Route 2: right, down, right, down
;; Route 3: right, down, down, right
;; Route 4: down, right, right, down
;; Route 5: down, right, down, right
;; Route 6: down, down, right, right
;;
;; How many routes are there through a 20x20 grid?
;;
;; Solution:
;; Using '0' to encode right and '1' to encode 'down', we
;; can iterate the solutions for the 2x2 grid as:
;;
;;   0011, 0101, 0110, 1001, 1010, 1100
;;
;; My solution for the 2x2 grid is: iterate from the binary number
;; "0011" (two zeroes, two ones) up to the binary number
;; "1100" (two ones, two zeroes) and accept only those numbers
;; with exactly two ones and two zeroes. Then, change the parameter
;; from size 2 to size 20
;;
;; ==== Final solution ====
;;
;; From a few runs for grids of smaller sizes (2 to 10) it was clear
;; the number of combinations was explosive. After leaving the program
;; running for 2+ days for N=20 it was time to try something else.
;; With the first numbers (2, 6, 20, 70, 252) I searched on the OEIS
;; website (www.oeis.org) for the sequence and learned about the
;; *central binomial coefficients* from Pascal's triangle, and even
;; better, the Pascal Triangle page on Wikipedia contains a site note:
;;
;;    +---+---+---+---+
;;    | @ | 1 | 1 | 1 |
;;    +---+---+---+---+
;;    | 1 | 2 | 3 | 4 |
;;    +---+---+---+---+
;;    | 1 | 3 | 6 | 10|
;;    +---+---+---+---+
;;    | 1 | 4 | 10| 20|
;;    +---+---+---+---+
;;
;;    "Pascal's triangle overlaid on a grid gives the number of unique
;;     paths to each square, assuming only right and down movements are
;;     considered."
;;

(defn euler-15[n]

  ;; === old implementation ===
  ;; binary 11111...111 (n times)
  (defn lower-bound[n]
    (Long/parseLong (apply str (map (fn[_] "1") (range n))) 2))

  ;; binary number of n-ones followed by n-zeroes
  (defn upper-bound[n]
    (- (lower-bound (* 2 n)) (lower-bound n)))

  (defn count-ones [n]
    (loop [ones 0 num n]
      (if (= 0 num) ones
          (if (= 1 (bit-and num 1))
            (recur (inc ones) (bit-shift-right num 1))
            (recur ones (bit-shift-right num 1))))))

  (defn bruteforce-count-routes [n]
    (loop [total 0 i (lower-bound n) top (upper-bound n)]
      (if (> i top) total
          (if (= n (count-ones i))
            (recur (inc total) (inc i) top)
            (recur total (inc i) top)))))

  ;; (bruforce-count-routes n))
  ;; == end old implementation ===

  ;; only the functions below are required
  (defn factorial[n] (apply *' (range 1 (inc n))))
  (defn square[n] (*' n n))

  ;; the solution is the n-th central binomial coefficient:
  (quot (factorial (* 2 n)) (square (factorial n))))

(println (euler-15 20))