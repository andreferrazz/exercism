(ns anagram
  (:require [clojure.string :as str]))

(defn anagram? [source target]
  (let [source (str/upper-case source) target (str/upper-case target)]
    (and (not= source target)
         (= (sort source) (sort target)))))

(defn anagrams-for [word prospect-list]
  (filterv #(anagram? word %) prospect-list))
