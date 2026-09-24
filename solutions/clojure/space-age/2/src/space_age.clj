(ns space-age)

(def year-in-seconds-on-earth 31557600)

(defn on-mercury [x]
  (/ x year-in-seconds-on-earth 0.2408467))

(defn on-venus [x]
  (/ x year-in-seconds-on-earth 0.61519726))

(defn on-earth [x]
  (/ x year-in-seconds-on-earth))

(defn on-mars [x]
  (/ x year-in-seconds-on-earth 1.8808158))

(defn on-jupiter [x]
  (/ x year-in-seconds-on-earth 11.862615))

(defn on-saturn [x]
  (/ x year-in-seconds-on-earth 29.447498))

(defn on-uranus [x]
  (/ x year-in-seconds-on-earth 84.016846))

(defn on-neptune [x]
  (/ x year-in-seconds-on-earth 164.79132))
