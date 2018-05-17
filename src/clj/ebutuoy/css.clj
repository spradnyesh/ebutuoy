(ns ebutuoy.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:* {:margin 0
       :padding 0}]
  [:body {:color "#333"
          :font-family "sans-serif"
          :margin "0 1.2em"}]
  [:ul [:li {:list-style-type "none"
             :margin "1em 0"}]]
  [:.search {:margin "1.5em 0"}]
  [:.player {:margin "1.5em 0"}]
  [:.results {:margin "1.5em 0"}])
