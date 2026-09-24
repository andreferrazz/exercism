(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn replace-spaces-with-underscores [s]
  (str/replace s " " "_"))

(defn replace-control-characters [s]
  (str/replace s #"\p{Cc}" "CTRL"))

(defn to-camel-case [s]
  (def i (str/index-of s \-))
  (def c (nth s (inc i)))
  (def upper (Character/toUpperCase c))
  (str/replace s (str \- c) (str upper)))

(defn to-camel-case [s]
  (def c (nth s (inc i)))
  (def upper (Character/toUpperCase c))
  (clojure.string/replace s (str \- c) (str upper)))

(defn from-kebab-case-to-camel-case [s]
  (def i (clojure.string/index-of s \-))
  (if (= i nil) s (to-camel-case s)))

(defn omit-non-letters [s]
  (str/replace s #"[^\p{L}_]" ""))

(defn omit-greek-lowercase-letters [s]
  (str/replace s #"[α-ω]" ""))

(defn clean [s]
  (-> s
    (replace-spaces-with-underscores)
    (replace-control-characters)
    (from-kebab-case-to-camel-case)
    (omit-non-letters)
    (omit-greek-lowercase-letters)))
