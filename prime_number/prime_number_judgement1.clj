(ns prime-number.prime-number-judgement1
  (:require [clojure.test :as t]))

;; If there is a number that can devide `n` between 2 to `n-1`, then `n` is not a prime number.
(defn is-prime [n]
  (loop [i 2]
    (cond
      (<= n i)
      true

      (zero? (mod n i))
      false

      :else
      (recur (inc i)))))

(t/deftest is-prime-test
  (t/are [number result] (t/is (= (is-prime number) result))
    2 true
    4 false
    5 true
    52 false
    53 true))

(t/run-tests)
