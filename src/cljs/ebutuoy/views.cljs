(ns ebutuoy.views
  (:require [re-frame.core :as rf]
            [ebutuoy.subs :as subs]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; home

(defn home-panel []
  [:div])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
