#!/usr/bin/env bb

;; I don't know this sort algorithm's name...
(defn xxx-sort [coll]
  (reduce
   (fn [r x]
     (let [{left true right false} (group-by #(> x %) r)]
       (concat left right)))
   coll
   coll))

(println (xxx-sort [6 11 12 4 1 5]))
