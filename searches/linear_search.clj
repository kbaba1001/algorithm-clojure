#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Linear_search

;; (defn linear-search [coll target]
;;   (let [i (atom 0)]
;;     (while (and (< @i (count coll)) (not= (coll @i) target))
;;       (swap! i inc))
;;     (if (= @i (count coll))
;;       -1
;;       @i)))

(defn linear-search [coll target]
  (reduce
   (fn [_ [i x]]
     (if (= x target)
       (reduced i)
       -1))
   0
   (map-indexed vector coll)))

(println (= (linear-search [0 5 7 10 15] 0) 0))
(println (= (linear-search [0 5 7 10 15] 15) 4))
(println (= (linear-search [0 5 7 10 15] 5) 1))
(println (= (linear-search [0 5 7 10 15] 6) -1))
