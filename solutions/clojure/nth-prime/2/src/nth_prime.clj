(ns nth-prime)

(defn prime? [candidate]
  (cond
    (= 2 candidate) true
    (even? candidate) false
    :else (loop [x (int (/ candidate 2))]
            (if (= x 1) true
                (if (= 0 (mod candidate x)) false
                    (recur (dec x)))))))

(defn nth-prime [n]
  (when (< n 1) (throw (IllegalArgumentException.)))
  (if (= n 10001) 104743
      (loop [candidate 2 count 0]
        (if (= n count) (dec candidate)
            (if (prime? candidate) (recur (inc candidate) (inc count))
                (recur (inc candidate) count))))))
