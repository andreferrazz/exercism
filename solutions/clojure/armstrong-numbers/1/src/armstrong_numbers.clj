(ns armstrong-numbers)

(defn digits
  ([num] (digits num []))
  ([num acc]
   (let [digit (mod num 10)]
     (if (= digit 0) acc
         (digits (int (/ num 10.0)) (conj acc digit))))))

(defn sum
  ([digits] (sum 0 digits (count digits)))
  ([acc digits digits-count]
   (if (empty? digits) acc
       (let [[first & rest] digits]
         (-> first
             (Math/pow digits-count)
             (+ acc)
             (sum rest digits-count))))))

(defn armstrong? [num]
  (-> num
      digits
      sum
      (int)
      (= num)))
