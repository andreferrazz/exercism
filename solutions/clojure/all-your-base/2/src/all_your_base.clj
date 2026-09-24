(ns all-your-base)

(defn to-digits
  ([num] (to-digits num '()))
  ([num acc] (let [[digit rest] [(-> num (mod 10) int) (-> num (/ 10.0) int)]]
               (if (= digit 0) acc
                   (to-digits rest (conj acc digit))))))

(defn to-base-10 [digits source]
  (let [i (atom (count digits))]
    (->> digits
         (map #(* % (Math/pow source (swap! i dec))))
         (reduce +)
         int)))

(defn from-base-10
  ([num target] (from-base-10 num target '()))
  ([num target acc] (if (= num 0) acc
                        (let [digit (mod num target)]
                          (if (= rest 0) acc
                              (from-base-10 (-> num (/ (float target)) int) target (conj acc digit)))))))

(defn convert [source digits target]
  (cond
    (< source 2) nil
    (< target 2) nil
    (some #(< % 0) digits) nil
    (some #(> % (dec source)) digits) nil
    (empty? digits) '()
    (every? zero? digits) '(0)
    (= target 10) (-> digits (to-base-10 source) to-digits)
    :else (-> digits (to-base-10 source) (from-base-10 target))))
