(ns prime-number.integer-factorization
  (:require [clojure.test :as t]))

(defn is-prime [n]
  (loop [i 2]
    (cond
      (< n (* i i))
      true

      (zero? (mod n i))
      false

      :else
      (recur (inc i)))))

(defn integer-factorization [n]
  ;; 60 / 2 = 30
  ;; 30 / 2 = 15
  ;; 15 / 3 = 5
  ;; 5 / 5 = 1

  (loop [i 1
         r []]
    (cond
      (< n (* i i))
      r)))

(t/deftest integer-factorization-test
  (t/are [number result] (t/is (= (integer-factorization number) result))
    60
    [2 2 3 5]

    286
    [2 11 13]

    20211225
    [3 5 5 31 8693]))

(t/run-tests)
