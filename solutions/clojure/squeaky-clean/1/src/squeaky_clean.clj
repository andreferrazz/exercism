(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn replace-spaces-with-underscores [s]
  (str/replace s " " "_"))

(defn replace-control-characters [s]
  (str/replace s #"[\u0000-\u001F\u007F-\u009F]" "CTRL"))

(defn to-camel-case [s]
  (def i (str/index-of s \-))
  (def c (nth s (inc i)))
  (def upper (Character/toUpperCase c))
  (str/replace s (str \- c) (str upper)))

(defn do-to-camel-case [s]
  (def c (nth s (inc i)))
  (def upper (Character/toUpperCase c))
  (clojure.string/replace s (str \- c) (str upper)))

(defn from-kebab-case-to-camel-case [s]
  (def i (clojure.string/index-of s \-))
  (if (= i nil) s (do-to-camel-case s)))

(defn omit-non-letters [s]
  (str/replace s #"[😀\d]" ""))

(defn omit-greek-lowercase-letters [s]
  (str/replace s #"[βιεγτω]" ""))

(defn clean [s]
  (-> s
    (replace-spaces-with-underscores)
    (replace-control-characters)
    (from-kebab-case-to-camel-case)
    (omit-non-letters)
    (omit-greek-lowercase-letters)))
