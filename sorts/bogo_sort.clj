;; https://en.wikipedia.org/wiki/Bogosort
(defn bogo-sort [collection]
  (let [result (shuffle collection)]
    (if (every? (fn [[n1 n2]] (< n1 n2)) (partition 2 1 result))
      result
      (recur result))))

(println (bogo-sort [8 4 3 7 6 5 2 1]))
