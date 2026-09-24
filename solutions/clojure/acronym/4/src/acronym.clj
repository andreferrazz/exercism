(ns acronym
  (:require [clojure.string :as str]))


(defn first-letters-of-each-word
  "Returns a lazy sequence of:
   - first letter
   - capital letter after lowercase letter
   - any letter after space or dash"
  [phrase]
  (re-seq #"^.|(?<=[a-z])[A-Z]|(?<=[\s\-])[a-zA-Z]" phrase))

(defn acronym [phrase]
  (->> phrase
       first-letters-of-each-word
       str/join
       str/upper-case))
