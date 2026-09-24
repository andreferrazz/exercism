(ns acronym)

(defn acronym [phrase]
  (if (empty? phrase) ""
    (->> (clojure.string/split 
          (clojure.string/replace phrase #"(?<=[a-z])[A-Z]" #(str " " %1)) #"[\s-]") 
       (map #(subs % 0 1))
       (map clojure.string/upper-case)
       clojure.string/join)))
