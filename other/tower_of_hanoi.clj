;; https://en.wikipedia.org/wiki/Tower_of_Hanoi

(defn hanoi
  ([n]
   (let [a (java.util.Stack.)]
     (doseq [i (reverse (range 1 (inc n)))]
       (.push a i))
     (hanoi n 1 [a (java.util.Stack.) (java.util.Stack.)])))
  ([n m [a b c :as arr]]
   (printf "A: %s\nB: %s\nC: %s\n--------\n" a b c)
   (when (< (.size c) n)
     (let [from-stack (get arr (mod (bit-and m (dec m)) 3))]
       (when-not (.empty from-stack)
         (.push (get arr (mod (inc (bit-or m (dec m))) 3)) (.pop from-stack)))
       (recur n (inc m) arr)))))

(hanoi 2)
