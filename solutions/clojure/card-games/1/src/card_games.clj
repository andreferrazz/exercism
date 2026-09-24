(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (+ 1 n) (+ 2 n))
  )

(defn concat-rounds 
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2)
  )

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #{n} l))
  )

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (def length (count hand))
  (def sum (reduce + hand))
  (/ sum (float length))
  )

(defn approx-average? [hand]
  (def average (card-average hand))
  (or 
   (== average (/ (+ (first hand) (last hand)) 2))
   (== average (nth hand (/ (count hand) 2))))
  )

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (def evens (take-nth 2 hand))
  (def odds (take-nth 2 (rest hand)))
  (= 
   (/ (reduce + odds) (count odds))
   (/ (reduce + evens) (count evens)))
  )

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (= 11 (last hand))
    (concat (butlast hand) (list (* 2 (last hand))))
    hand)
  )
