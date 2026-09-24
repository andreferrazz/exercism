(ns acronym
  (:require [clojure.string :as str]))

(defn put-space-between-lower-case-and-upper-case-letters [phrase]
  (str/replace phrase #"(?<=[a-z])[A-Z]" #(str " " %1)))

(defn split-on-space-or-dash [phrase]
  (str/split phrase #"[\s-]"))

(defn map-to-first-letter [coll]
  (map #(first %) coll))

(defn filter-non-nil [coll]
  (filter #(not (nil? %)) coll))

(defn map-to-upper-case [coll]
  (map str/upper-case coll))

(defn acronym [phrase]
  (-> phrase
      put-space-between-lower-case-and-upper-case-letters
      split-on-space-or-dash
      map-to-first-letter
      filter-non-nil
      map-to-upper-case
      str/join))
