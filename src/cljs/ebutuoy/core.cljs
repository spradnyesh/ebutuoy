(ns ebutuoy.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [ebutuoy.config :as config]
            [ebutuoy.routes :as routes]
            [ebutuoy.views :as views]
            [ebutuoy.subs]
            [ebutuoy.events]
            [ebutuoy.effects]))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
