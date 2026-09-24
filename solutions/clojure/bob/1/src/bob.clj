(ns bob
  (:require [clojure.string :as str]))

(defn is-question? [s]
  (-> s str/trim (str/ends-with? "?")))

(defn is-yell? [s]
  (and (= s (str/upper-case s))
       (boolean (re-find #"\p{L}" s))))

(defn is-yell-and-question? [s]
  (and (is-question? s) (is-yell? s)))

(defn response-for [s]
  (cond
    (str/blank? s) "Fine. Be that way!"
    (is-yell-and-question? s) "Calm down, I know what I'm doing!"
    (is-question? s) "Sure."
    (is-yell? s) "Whoa, chill out!"
    :else "Whatever."))
