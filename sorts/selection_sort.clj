#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Selection_sort

(defn selection-sort [coll]
  (loop [input coll
         result []]
    (if (= (count coll) (count result))
      result
      (let [min (apply min input)
            rest (filter #(not= min %) input)]
        (recur rest (conj result min))))))

(println (selection-sort [5 4 8 7 9 3 1]))
