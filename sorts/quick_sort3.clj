#!/usr/bin/env bb

;; I was not able to use pop! or java.util.Stack in Babashka :/
(defn pop!! [stack-atom]
  (let [x (first @stack-atom)]
    (swap! stack-atom next)
    x))
(defn push!! [stack-atom value]
  (reset! stack-atom (cons value @stack-atom)))

;; https://en.wikipedia.org/wiki/Quicksort
(defn qsort [arr]
  (let [stack (atom [])
        result (atom [])]
    (push!! stack arr)
    (while (seq @stack)
      (let [target (pop!! stack)
            pivot (first target)
            res (next target)
            left (filter #(< % pivot) res)
            right (filter #(>= % pivot) res)]
        (if (and (empty? left) (empty? right))
          (push!! result pivot)
          (do
            (push!! stack left)
            (push!! stack [pivot])
            (push!! stack right)))))
    (remove nil? @result)))

(qsort [3,2,5,4,1,2])
;; => (1 2 2 3 4 5)
