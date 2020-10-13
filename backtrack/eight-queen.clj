(ns eight-queen
  (:require [clojure.string :as s]))

(defn conflict? [x y board]
  (->> (map-indexed vector (take y board))
       (some (fn [[y1 x1]]
               (or
                (= (- x1 y1) (- x y))
                (= (+ x1 y1) (+ x y)))))))

(defn check? [board]
  (->> (map-indexed vector board)
       (every? (fn [[y x]] (not (conflict? x y board))))))

(defn queen [n]
  (loop [board (vec (range n))]
    (if (check? board)
      board
      (recur (shuffle board)))))

(defn display-queen [n]
  (let [board (vec (repeat n (vec (repeat n "."))))
        queens (map-indexed vector (queen n))
        result (reduce #(assoc-in %1 %2 "Q") board queens)]
    (println (s/join "\n" (map #(s/join " " %) result)))))

(display-queen 8)
