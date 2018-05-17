(ns ebutuoy.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))

(re-frame/reg-sub
 :query
 (fn [db _]
   (:query db)))

(re-frame/reg-sub
 :results
 (fn [db _]
   (:results db)))

(re-frame/reg-sub
 :video-id
 (fn [db _]
   (:video-id db)))

(re-frame/reg-sub
 :error
 (fn [db _]
   (:error db)))
