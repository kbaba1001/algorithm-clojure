;; https://en.wikipedia.org/wiki/Bead_sort

(defn bead-sort [collection]
  (let [transposed-list (reduce
                         (fn [r x] (into (mapv inc (subvec r 0 x)) (subvec r x)))
                         (vec (repeat (apply max collection) 0))
                         collection)]
    (reduce (fn [r x]
              (conj r (count (filter #(> % x) transposed-list))))
            []
            (range (count collection)))))

(println (bead-sort [6 11 12 4 1 5]))
