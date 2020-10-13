;; https://en.wikipedia.org/wiki/Eight_queens_puzzle

(ns eight-queen
  (:require [clojure.string :as s]))

(defn check? [x y queens]
  (not (->> (map-indexed vector queens)
            (some (fn [[qy qx]]
                    (or
                     (= y qy)
                     (= x qx)
                     (= (- qx qy) (- x y))
                     (= (+ qx qy) (+ x y))))))))

(defn pop-queen [n x queens]
  (if (>= x n)
    (recur n (inc (peek queens)) (pop queens))
    [x queens]))

(defn queen
  ([n] (queen n 0 ()))
  ([n x queens]
   (if (>= (count queens) n)
     queens
     (when (< x n)
       (if (check? x (count queens) (reverse queens))
         (recur n 0 (conj queens x))
         (let [[nx nqueens] (pop-queen n (inc x) queens)]
           (recur n nx nqueens)))))))

(defn display-queen [n]
  (let [board (vec (repeat n (vec (repeat n "."))))
        queens (map-indexed vector (queen n))
        result (reduce #(assoc-in %1 %2 "Q") board queens)]
    (println (s/join "\n" (map #(s/join " " %) result)))))

(display-queen 8)
