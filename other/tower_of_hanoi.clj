#!/usr/bin/env bb

;; https://en.wikipedia.org/wiki/Tower_of_Hanoi

;; I was not able to use pop! or java.util.Stack in Babashka :/
(defn pop!! [stack-atom]
  (let [x (first @stack-atom)]
    (swap! stack-atom next)
    x))
(defn push!! [stack-atom value]
  (reset! stack-atom (cons value @stack-atom)))

(defn hanoi
  ([n]
   (let [a (atom [])]
     (doseq [i (reverse (range 1 (inc n)))]
       (push!! a i))
     (hanoi n 1 [a (atom []) (atom [])])))
  ([n m [a b c :as arr]]
   (printf "A: %s\nB: %s\nC: %s\n--------\n" @a @b @c)
   (when (< (count @c) n)
     (let [from-stack (get arr (mod (bit-and m (dec m)) 3))]
       (when (seq @from-stack)
         (push!! (get arr (mod (inc (bit-or m (dec m))) 3)) (pop!! from-stack)))
       (recur n (inc m) arr)))))

(hanoi 3)
