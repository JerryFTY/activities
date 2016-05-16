(ns activities.svg
  (:require [hiccup.core]
            [clojure.string :refer [join]]))

(defn convert [content]
  (hiccup.core/html content))

(defn css [m]
  (join " "
        (map (fn [[k v]]
               (str (name k) ": " v ";")) m)))

(defn svg [content]
  [:svg {"xmlns:svg" "http://www.w3.org/2000/svg"
         "xmlns" "http://www.w3.org/2000/svg"
         "xmlns:xlink" "http://www.w3.org/1999/xlink"
         "version" "1.0"}
   content])

(defn html [content]
  [:html
   [:body
    content]])

(defn xml [content]
  [:?xml {:version "1.0"
          :encoding "UTF-8"}
   content])

(defn spit-html [filename content]
  (spit filename
        (-> content
            html
            convert)))

(defn spit-svg [filename content]
  (spit filename
        (-> content
            xml
            convert)))


