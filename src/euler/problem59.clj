(ns euler.problem59)

;; Transform cipher1.txt into a seq of numbers
(def codes
  (map
   #(Long. %)
   (re-seq #"\d+" (slurp "cipher1.txt"))))

;; Apply on 'codes' the mask formed with repeating x-y-z...
(defn apply-mask [codes x y z]
  (map char (map bit-xor codes (cycle [x y z]))))

;; Find the first text which contains the word 'people'
(def clear-text
  (let [lowercase-letters (range (int \a) (inc (int \z)))]
    (first
     (for [x lowercase-letters
           y lowercase-letters
           z lowercase-letters
           :let [applied (apply str (apply-mask codes x y z))]
           :when (> (.indexOf applied "people") -1)]
       applied))))

  ;; (println clear-text)

  ;; Decrypt the message and find the sum of the ASCII values in the text
  (println (reduce + (map int clear-text)))
