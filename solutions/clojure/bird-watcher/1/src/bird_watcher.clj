(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds 6 (+ (today birds) 1))
  )

(defn day-without-birds? [birds]
  (boolean (some #{0} birds))
  )

(defn n-days-count [birds n]
  (reduce + (subvec birds 0 n))
  )

(defn busy-days-aux [birds i acc]
  (def day (get birds i))
  (if (= day nil) 
    acc
    (if (>= day 5) 
      (busy-days-aux birds (+ i 1) (+ acc 1)) 
      (busy-days-aux birds (+ i 1) acc)
      )
    )
  )

(defn busy-days [birds]
  (busy-days-aux birds 0 0)
  )

(defn do-odd-week [birds i]
  (def day (get birds i))
  (cond
    (= day nil) true
    (and (odd? i) (= day 1)) false
    (and (even? i) (= day 0)) false
    :else (do-odd-week birds (+ i 1))
    )
  )

(defn odd-week? [birds]
  (do-odd-week birds 0)
  )
