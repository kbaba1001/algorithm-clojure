(ns prime-number.divisor
  (:require [clojure.test :as t]))

;; https://en.wikipedia.org/wiki/Divisor
(defn divisor [n]
  (loop [i 1
         r #{}]
    (cond
      (< n (* i i))
      r

      (not (zero? (mod n i)))
      (recur (inc i) r)

      :else
      (recur (inc i) (if (not= (/ n i) i)
                       (conj r i (/ n i))
                       (conj r i))))))

(t/deftest divisor-test
  (t/are [n r] (= (divisor n) r)
    100
    #{1 2 4 5 10 20 25 50 100}))

(t/run-tests)
