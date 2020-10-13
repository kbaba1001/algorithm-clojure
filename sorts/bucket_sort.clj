;; https://en.wikipedia.org/wiki/Bucket_sort

;; function bucketSort(array, k) is
;;     buckets ← new array of k empty lists
;;     M ← the maximum key value in the array
;;     for i = 1 to length(array) do
;;         insert array[i] into buckets[floor(k × array[i] / M)]
;;     for i = 1 to k do
;;         nextSort(buckets[i])
;;     return the concatenation of buckets[1], ...., buckets[k]
;;    
(defn bucket-sort [coll]
  (let [max-value (apply max coll)]))

;; public static void bucketsort(int[] src, int[] dst, int len, int range) {
;;     /** 値ごとの出現回数 */
;;     int[] count = new int[range];
;;     /** ソート後配列における値ごとの開始位置 */
;;     int[] offset = new int[range];
;;     /** ループ制御用 */
;;     int i;

;;     /* 出現回数を数える */ 
;;     for (i = 0; i < len; i++) {
;;         count[ src[i] ]++;
;;     }
;;     /* 開始位置計算 */
;;     offset[0] = 0;
;;     for (i = 1; i < range; i++) {
;;         offset[i] = offset[i-1] + count[i-1];
;;     }
;;     /* ソート処理 */
;;     for (i = 0; i < len; i++) {
;;         int target = src[i];
;;         dst[ offset[target] ] = target;
;;         offset[target]++;
;;     }
;; }

(println (bucket-sort [3 2 2 1 2 2 1 3 3 1 2 3]))
