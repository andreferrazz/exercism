(ns nth-prime)

(defn prime? [candidate]
  (loop [x (int (inc (Math/sqrt candidate)))]
    (cond
      (= x 1) true
      (zero? (rem candidate x)) false
      :else (recur (dec x)))))

(defn nth-prime [n]
  (when (< n 1) (throw (IllegalArgumentException.)))
  (if (= n 1) 2
      (loop [candidate 3 count 1]
        (if (= n count) (- candidate 2)
            (if (prime? candidate) (recur (+ candidate 2) (inc count))
                (recur (+ candidate 2) count))))))
