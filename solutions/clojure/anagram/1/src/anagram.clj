(ns anagram
  (:require [clojure.string :as str]))

(defn sorted-letters [word]
  (-> word
      str/upper-case
      (str/split #"")
      sort))

(defn not-same-word? [source target]
  (not= (str/upper-case source) (str/upper-case target)))

(defn contains-exactly-the-same-letters? [source target]
  (let [source (sorted-letters source) target (sorted-letters target)]
    (= source target)))

(defn anagram? [source target]
  (and (not-same-word? source target)
       (contains-exactly-the-same-letters? source target)))

(defn anagrams-for [word prospect-list]
  (filterv #(anagram? word %) prospect-list))
