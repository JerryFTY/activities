(ns activities.test.core
  (:require [activities.svg :refer [css svg spit-html spit-svg]]
            [activities.crossword.core :refer [crossword]]))

(defn run-svg []
  (let [content (svg [:g {:x 100
                          :y 100}
                      [:rect {:x 0
                              :y 0
                              :height 50
                              :width 300
                              :style (css {:stroke "#000000"
                                           :stroke-width 5
                                           :fill "#660000"})}]
                      [:text {:style (css {:fill "#FFFFFF"
                                           :font-size "25px"
                                           :font-family "Verdana"})
                              :x 150
                              :y 25}
                       "Hello World"]])]

    (spit-html "test.html" content)
    (spit-svg "test.svg" content)))


(defn run-crossword []
  (spit-html
    "crossword.html"
    (crossword [{:text "Ottawa" :clue "Capital of Canada"}
                {:text "Moscow" :clue "Capital of Russia"}
                {:text "Washington D.C." :clue "Capital of The United States"}
                {:text "Mexico City" :clue "Capital of Mexico"}
                {:text "Beijing" :clue "Capital of China"}]))

  )
