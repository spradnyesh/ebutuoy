(ns ebutuoy.utils
  (:require [re-frame.core :as rf]
            [ajax.core :refer [GET POST]]))

(defonce server-url "https://www.googleapis.com/youtube/v3")

(defn make-server-call [opts]
  (let [url (str server-url (:endpoint opts))
        s-handler (fn [response]
                    ((:handler opts) response))
        e-handler (fn [error]
                    ((:error-handler opts) error))
        options (merge {:handler s-handler
                        :response-format :json
                        :keywords? true
                        :error-handler e-handler
                        :params (or (:params opts) {})}
                       {:body (:body opts)})]
    (if (= (:method opts) :post)
      (POST url options)
      (GET url options))))
