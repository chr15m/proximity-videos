(ns proximity-videos.prod
  (:require
    [proximity-videos.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
