;; WIP
;; https://en.wikipedia.org/wiki/Tower_of_Hanoi

;; 【問題】N段のハノイの塔を解くプログラムを作成してください。ハノイの塔のルールは次のとおりです。
;; 
;; * 3本の杭と、中央に穴の開いた大きさの異なる複数の円盤があります。
;; * 最初はすべての円盤が左端の杭に小さいものが上になるように順に積み重ねられています
;; * 円盤を一回に一枚ずつどれかの杭に移動させることができるが、小さな円盤の上に大きな円盤を乗せることはできません
;; * すべての円盤を上記のルールに従って右端の杭に移動してください
;; 
;; プログラムでは杭を左からA, B, Cとし、円盤を小さい方から1,2,3,...として表現します。円盤を移動するたびに次のように杭と円盤の状態を表示してください。
;; 
;; 入力: n (任意の自然数。ひとまず3, 5, 10 の場合で動けば良しとします)
;; 出力例 (n = 3 の例):
;; A: 3 2 1
;; B:
;; C: 
;; ------
;; A: 3 2 
;; B:
;; C: 1
;; ------
;; A: 3
;; B: 2
;; C: 1
;; ------
;; A: 3
;; B: 2 1
;; C: 
;; ------
;; A: 
;; B: 2 1
;; C: 3
;; ------
;; A: 1
;; B: 2
;; C: 3
;; ------
;; A: 1
;; B: 
;; C: 3 2
;; ------
;; A: 
;; B: 
;; C: 3 2 1
;; 
;; n = 1
;; ------
;; A: 1
;; B:
;; C:
;; ------
;; A:
;; B:
;; C: 1
;; 
;; (n & (n-1)) % 3 番目の棒にある円盤を ((n| (n-1)) +1) %3 番目の棒に移動する
;; n = 2
;; ------
;; A: 2 1  (0)
;; B:      (0)
;; C:      (0)
;; ------
;; A: 2    (0)
;; B: 0    (0)
;; C: 1    (1)
;; (A -> C)
;; ------
;; A: 2    (0)
;; B: 1    (1)
;; C:      (0)
;; (A -> B)
;; ------
;; A: 1
;; B: 2
;; C: 
;; (C -> A)
;; ------
;; A: 1
;; B: 
;; C: 2
;; (B -> C)
;; ------
;; A: 
;; B: 
;; C: 2 1
;; (A -> C)

;; ((m & (m-1)) % 3) - 1 番目の棒にある円盤を (((m| (m-1)) +1) %3) - 1 番目の棒に移動する
(defn hanoi
  ([n] (hanoi n 0 [(atom (vec (reverse (range 1 (inc n))))) (atom []) (atom [])]))
  ([n m [[a b c] :as sticks]]
   (println "A: " @a "\nB: " @b "\nC: " @c "\n---------")
   (when-not (or (= (count @c) n) (< m 10))
     (let [from-index (dec (mod (bit-and m (dec m)) n))
           to-index (dec (mod (inc (bit-or m (dec m))) n))
           from-arr (get sticks from-index)
           to-arr (get sticks to-index)
           from-value (last @from-arr)]
       (reset! from-arr (vec (take (dec (count @from-arr)) @from-arr)))
       (swap! to-arr conj from-value)
       (hanoi n (inc m) sticks)))))

(hanoi 2)
