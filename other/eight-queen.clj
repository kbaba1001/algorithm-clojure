#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Eight_queens_puzzle

(ns eight-queen
  (:require [clojure.string :as s]))

(defn conflict? [x y queens]
  (->> (map-indexed vector (take y queens))
       (some (fn [[y1 x1]]
               (or
                (= (- x1 y1) (- x y))
                (= (+ x1 y1) (+ x y)))))))

(defn check? [queens]
  (->> (map-indexed vector queens)
       (every? (fn [[y x]] (not (conflict? x y queens))))))

(defn queen [n]
  (loop [queens (vec (range n))]
    (if (check? queens)
      queens
      (recur (shuffle queens)))))

(defn display-queen [n]
  (let [board (vec (repeat n (vec (repeat n "."))))
        queens (map-indexed vector (queen n))
        result (reduce #(assoc-in %1 %2 "Q") board queens)]
    (println (s/join "\n" (map #(s/join " " %) result)))))

(display-queen 8)
