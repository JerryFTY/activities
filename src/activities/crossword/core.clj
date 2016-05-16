(ns activities.crossword.core
  (:require [activities.svg :refer [css svg]]))

(defn crossword [words]
  (svg
    (into [:g {:x 100 :y 1000}]
          (map-indexed
            (fn [i word]
              [:text {:x 0
                      :y (* i 20)} (word :text)]) words))))

