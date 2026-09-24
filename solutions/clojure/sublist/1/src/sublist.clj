(ns sublist)

(defn superlist?
  ([a b] (superlist? a b 0))
  ([a b start] (let [[a-length end] [(count a) (+ start (count b))]]
                 (cond
                   (> end a-length) false
                   (= (subvec a start end) b) true
                   :else (superlist? a b (+ start 1))))))

(defn classify
  [a b]
  (cond
    (= a b) :equal
    (superlist? b a) :sublist
    (superlist? a b) :superlist
    :else :unequal))
