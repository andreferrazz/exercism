(ns say)

(defn number [num]
  (cond
    (or (< num 0) (>= num 1000000000000)) (throw (IllegalArgumentException.))
    (= num 0) "zero"
    (= num 1) "one"
    (= num 2) "two"
    (= num 3) "three"
    (= num 4) "four"
    (= num 5) "five"
    (= num 6) "six"
    (= num 7) "seven"
    (= num 8) "eight"
    (= num 9) "nine"
    (= num 10) "ten"
    (= num 11) "eleven"
    (= num 12) "twelve"
    (= num 13) "thirdteen"
    (= num 14) "fourteen"
    (= num 15) "fifteen"
    (= num 16) "sixteen"
    (= num 17) "seventeen"
    (= num 18) "eighteen"
    (= num 19) "ninteen"
    (= num 20) "twenty"
    (= num 30) "thirty"
    (= num 40) "forty"
    (= num 50) "fifty"
    (= num 60) "sixty"
    (= num 70) "seventy"
    (= num 80) "eighty"
    (= num 90) "ninety"
    (= 0 (mod num 1000000000)) (str (number (int (/ num 1000000000.0))) " billion")
    (= 0 (mod num 1000000)) (str (number (int (/ num 1000000.0))) " million")
    (= 0 (mod num 1000)) (str (number (int (/ num 1000.0))) " thousand")
    (= 0 (mod num 100)) (str (number (int (/ num 100.0))) " hundred")
    (< num 100) (str (number (* 10 (int (/ num 10.0)))) "-" (number (mod num 10)))
    (< num 1000) (str (number (* 100 (int (/ num 100.0)))) " " (number (mod num 100)))
    (< num 1000000) (str (number (* 1000 (int (/ num 1000.0)))) " " (number (mod num 1000)))
    (< num 1000000000) (str (number (* 1000000 (int (/ num 1000000.0)))) " " (number (mod num 1000000)))
    (< num 1000000000000) (str (number (* 1000000000 (int (/ num 1000000000.0)))) " " (number (mod num 1000000000)))))
