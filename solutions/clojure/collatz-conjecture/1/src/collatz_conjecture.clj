(ns collatz-conjecture)

(defn collatz [input]
  (when (< input 1) (throw (Throwable.)))
  (loop [steps 0 num input]
    (if (= num 1) steps
        (recur (inc steps) (if (even? num) (int (/ num 2)) (inc (* num 3)))))))
