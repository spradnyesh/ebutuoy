(ns ebutuoy.events
  (:require [re-frame.core :as re-frame]
            [ebutuoy.db :as db]
            [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))

(re-frame/reg-event-db
 :initialize-db
 (fn-traced [_ _]
            db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn-traced [db [_ active-panel]]
            (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :query
 (fn-traced [db [_ query]]
            (assoc db :query query)))

(re-frame/reg-event-fx
 :search
 (fn-traced [cofxb [_ query]]
            {:search query}))

(re-frame/reg-event-db
 :results
 (fn-traced [db [_ results]]
            (assoc db :results results)))

(re-frame/reg-event-db
 :video-id
 (fn-traced [db [_ video-id]]
            (assoc db :video-id video-id)))

(re-frame/reg-event-db
 :error
 (fn-traced [db [_ error]]
            (assoc db :error error)))
