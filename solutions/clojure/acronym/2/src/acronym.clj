(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [phrase]
  (if (empty? phrase) ""
    (-> phrase
        (str/replace #"(?<=[a-z])[A-Z]" #(str " " %1))
        (str/split #"[\s-]")
        (->> (map #(subs % 0 1))
             (map str/upper-case)
             str/join))))
