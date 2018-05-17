(ns ebutuoy.views
  (:require [re-frame.core :as rf]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; panels

(defn search []
  (let [query (rf/subscribe [:query])]
    [:form.search
     [:input {:type "text"
              :placeholder "search query"
              :value @query
              :on-change #(rf/dispatch [:query (-> % .-target .-value)])}]
     [:input {:type "submit"
              :value "Search"
              :on-click (fn [e]
                          (.preventDefault e)
                          (rf/dispatch [:search @query]))}]]))

(defn error []
  [:div.error
   (let [error (rf/subscribe [:error])]
     (when @error
       [:p error]))])

(defn player []
  [:div.player
   (let [video-id (rf/subscribe [:video-id])]
     (when @video-id
       [:iframe {:src (str "https://www.youtube.com/embed/" @video-id)}]))])

(defn results []
  [:div.results
   (let [results (rf/subscribe [:results])]
     (when-not (empty? @results)
       (let [total-results (:totalResults (:pageInfo @results))
             items (:items @results)]
         [:div
          [:h4 (str "Total results: " total-results)]
          [:ul (doall (map (fn [itm]
                             (when-let [video-id (:videoId (:id itm))]
                               ^{:key video-id}
                               [:li {:on-click (fn [e]
                                                 (.preventDefault e)
                                                 (rf/dispatch [:video-id video-id]))}
                                [:img {:src (:url (:default (:thumbnails (:snippet itm))))}]
                                [:p (:title (:snippet itm))]]))
                           items))]])))])

(defn home-panel []
  [:div.container
   [search]
   [error]
   [player]
   [results]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    [show-panel @active-panel]))
