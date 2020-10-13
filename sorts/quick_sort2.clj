;; https://en.wikipedia.org/wiki/Quicksort
(defn qsort
  ([lst]
   (qsort lst identity))
  ([lst k]
   (if (empty? lst)
     (k lst)
     (let [x (first lst)
           res (next lst)
           lt (filter #(> % x) res)
           ge (filter #(<= % x) res)]
       (recur lt (fn [v1]
                   (qsort ge (fn [v2]
                               (k (flatten (conj v1 x v2)))))))))))

(println (qsort [3 2 5 4 1 2]))
(println (qsort [1 214 2 412 12172 418 0 -1 248]))
