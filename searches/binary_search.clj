;; https://en.wikipedia.org/wiki/Binary_search_algorithm
;; 

(defn binary-search [coll target]
  (loop [left 0
         right (count coll)]
    (let [mid (int (/ (+ left right) 2))]
      (if (>= left right)
        -1
        (if (= (get coll mid) target)
          mid
          (if (< target (get coll mid))
            (recur left mid)
            (recur (inc mid) right)))))))

(println (= (binary-search [0 5 7 10 15] 0) 0))
(println (= (binary-search [0 5 7 10 15] 15) 4))
(println (= (binary-search [0 5 7 10 15] 5) 1))
(println (= (binary-search [0 5 7 10 15] 6) -1))
