(ns armstrong-numbers)

(defn digits 
  ([num] (digits num []))
  ([num acc] (let [[digit rest] [(mod num 10) (-> num (/ 10.0) int)]]
               (if (= digit 0) [acc (count acc)]
                   (digits rest (conj acc digit))))))

(defn sum [[digits digits-count]] (->> digits
                                       (map #(Math/pow % digits-count))
                                       (reduce +)))

(defn armstrong? [num] (->> num
                            digits
                            sum
                            (== num)))
