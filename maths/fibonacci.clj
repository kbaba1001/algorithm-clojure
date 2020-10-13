; 増井敏克. プログラマ脳を鍛える数学パズル シンプルで高速なコードが書けるようになる70問 Q_11

(def fib-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+ a b)))))
   1 1))

(defn sum [n]
  (apply + (map read-string (re-seq #"\d" (str n)))))

(->>
 (filter
  (fn [x]
    (= (mod x (sum x)) 0))
  fib-seq)
 (take 13)
 (drop 8))

; (2584 14930352 86267571272 498454011879264 160500643816367088)
