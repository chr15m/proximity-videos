(ns ^:figwheel-no-load proximity-videos.dev
  (:require
    [proximity-videos.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
