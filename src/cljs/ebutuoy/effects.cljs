(ns ebutuoy.effects
  (:require [re-frame.core :as rf]
            [ebutuoy.utils :as utils]
            [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))

;; NOTE: this needs to be filled before testing/building
(def auth-key "")

(rf/reg-fx
 :search
 (fn-traced [query]
            (utils/make-server-call {:method :get
                                     :endpoint "/search"
                                     :handler #(rf/dispatch [:results %])
                                     :error-handler #(rf/dispatch [:error %])
                                     :params {:q query
                                              :part :snippet
                                              :max-results 500
                                              ;; :safe-search :strict
                                              :key auth-key}})))
