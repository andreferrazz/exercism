(ns triangle)

(defn is-valid? [a b c]
  (and (not= a 0)
       (not= b 0)
       (not= c 0)
       (>= (+ a b) c)
       (>= (+ a c) b)
       (>= (+ c b) a)))

(defn equilateral? [a b c]
  (and (is-valid? a b c) 
       (= a b c)))

(defn isosceles? [a b c]
  (and (is-valid? a b c)
       (or (= a b)
           (= a c)
           (= c b))))

(defn scalene? [a b c]
  (and (is-valid? a b c)
       (not= a b)
       (not= a c)
       (not= c b)))
