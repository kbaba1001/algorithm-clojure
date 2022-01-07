#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Quicksort
(defn qsort [arr]
  (println "arr:" arr)
  (if (empty? arr)
    arr
    (let [pivot (first arr)
          res (next arr)
          left (qsort (filter #(> % pivot) res))
          right (qsort (filter #(<= % pivot) res))]
      (flatten (conj left pivot right)))))

(qsort [3, 2, 5, 4, 1, 2])
