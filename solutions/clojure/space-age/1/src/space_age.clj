(ns space-age)

(defn on-mercury [x]
  (/ x 31557600 0.2408467))

(defn on-venus [x]
  (/ x 31557600 0.61519726))

(defn on-earth [x]
  (/ x 31557600))

(defn on-mars [x]
  (/ x 31557600 1.8808158))

(defn on-jupiter [x]
  (/ x 31557600 11.862615))

(defn on-saturn [x]
  (/ x 31557600 29.447498))

(defn on-uranus [x]
  (/ x 31557600 84.016846))

(defn on-neptune [x]
  (/ x 31557600 164.79132))
