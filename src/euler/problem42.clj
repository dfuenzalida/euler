(ns euler.problem42)

(defn euler-42 []

  (def triangle-numbers
    (set (map #(quot (* % (inc %)) 2) (range 1 1000))))

  (defn score [word]
    (apply + (map #(- (int %) (int \A) -1) word)))

  (defn triangle-word? [word]
    (contains? triangle-numbers (score word)))

  (defn words-to-list []
    (clojure.string/split
     (clojure.string/replace (slurp "words.txt") "\"" "") #","))

  (count (filter triangle-word? (words-to-list))))

(println (euler-42))