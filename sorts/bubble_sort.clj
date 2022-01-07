#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Bubble_sort
(defn bubble-sort
  ([collection] (bubble-sort collection 0))
  ([collection i]
   (if (< i (dec (count collection)))
     (let [result (reduce (fn [r x]
                            (if (empty? r)
                              (conj r x)
                              (if (< x (peek r))
                                (conj r x)
                                (conj (pop r) x (peek r))))) () collection)]
       (recur result (inc i)))
     collection)))

(println (bubble-sort [8 4 3 7 6 5 2 1]))
