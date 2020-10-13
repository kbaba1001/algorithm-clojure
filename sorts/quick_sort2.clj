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

(qsort [3 2 5 4 1 2])
()
;; (qsort [1 214 2 412 12172 418 0 -1 248])
;; (-1 0 1 2 214 248 412 418 12172)

;; 入力値: [3,2,5,4,1,2]
;; 出力値: [1,2,2,3,4,5]
