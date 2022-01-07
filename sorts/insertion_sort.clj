#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Insertion_sort
(defn insert [n coll]
  (cond
    (empty? coll) (list n)
    (> (first coll) n) (cons n coll)
    :else (cons (first coll) (insert n (next coll)))))

(defn insertion-sort [coll]
  (reduce #(insert %2 %1) '() coll))

(println (insertion-sort [8 3 1 5 2 1]))
