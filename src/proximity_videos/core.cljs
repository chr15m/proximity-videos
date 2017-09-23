(ns proximity-videos.core
    (:require
      [reagent.core :as r]))

(def initial-state {:year nil
                    :video nil})
(defonce app-state (r/atom initial-state))

(def videos
  [["2012"	"01"  "Hydrosis_Final"	"Hydrosis"	"Janette McGinty"	"WA"]
   ["2012"	"02"  "How-To-Have-A-3-Minute-Shower_Final"	"How To Have A 3 Minute Shower"	"Jen Jamieson"	"WA"]
   ["2012"	"03"  "Your-Private-Hoofer_Final"	"Your Private Hoofer"	"Claudia Alessi & Rhiannon Newton"	"WA"]
   ["2012"	"04"  "Slowfood-Sunday_Final"	"Slowfood Sunday"	"Sarah Rowbottam"	"WA"]
   ["2012"	"05"  "Ush_and_Them_Final"	"Ush and Them"	"Nikki Jones"	"WA"]
   ["2012"	"06"  "Flush_Final"	"Flush"	"Janet Carter"	"WA"]
   ["2012"	"07"  "Fragmentation_Final"	"Fragmentation 1.2"	"Hellen Russo"	"WA"]
   ["2012"	"08"  "How-close-do-you-want-me_Final_B"	"How Close Do You Want Me?"	"Russya Connor"	"WA"]
   ["2012"	"09"  "Mobile-Moments_Final"	"Mobile Moments: Series #2"	"Sarah Nelson"	"WA"]
   ["2012"	"10"  "Sweetlife_Final_B"	"Sweetlife"	"James Berlyn"	"WA"]
   ["2012"	"11"  "The-Union_Final"	"The Union"	"Renae Coles"	"WA"]
   ["2012"	"12"  "Gloryhole-Beard_Final"	"Glory Hole Beard"	"Jackson Eaton"	"WA"]

   ["2013"	"01"  "Ours_Final"	"Ours"	"Elise Reitze"	"WA"]
   ["2013"	"02"  "The-Plantarum-Empathic-Limb-Clinic_Final_B"	"The Plantarum: Empathic Limb Clinic"	"Cat Jones & Melissa Hunt"	"NSW"]
   ["2013"	"03"  "Asterion_Final"	"Asterion"	"Humphrey Bower"	"WA"]
   ["2013"	"04"  "Remains-Management-Services_Final"	"Remains Management Services"	"Loren Kronemyer "	"USA/WA"]
   ["2013"	"05"  "Incendia-Lascivio_Final"	"Incendia Lascivio"	"Sarah Elson"	"WA"]
   ["2013"	"06"  "The-Mark_Final"	"The Mark"	"Moya Thomas"	"WA"]
   ["2013"	"07"  "Where-You-End-and-I-Begin_Final"	"Where You End & I Begin"	"Rachel Ariane Ogle "	"WA"]
   ["2013"	"08"  "Hang_Final"	"Hang"	"Ian Sinclair"	"WA"]
   ["2013"	"09"  "Prior-Arrangement_Final"	"Prior Arrangement"	"Janet Pettigrew "	"WA"]
   ["2013"	"10"  "String-Duet_Final_B"	"String Duet"	"Leon Hendroff & Emma Craig"	"WA"]
   ["2013"	"11"  "Meditation-on-the-Breath_Final"	"Meditation on the breath"	"Janet Carter & Nikki Jones"	"WA"]
   ["2013"	"12"  "The-Gallery-of-Impermanent-Things_Final"	"The Gallery of Impermanent Things"	"Daniel Nevin"	"WA"]

   ["2014"	"01"  "Anatomys-Confection_Final_C"	"Anatomy’s Confection"	"Cat Jones"	"NSW"]
   ["2014"	"02"  "Twerkshop_Final_C"	"Twerkshop"	"Caroline Garcia"	"NSW"]
   ["2014"	"03"  "The-Queue_Final_B"	"The Queue"	"Toyi-Toyi Theatre"	"WA"]
   ["2014"	"04"  "Learner_Final_B"	"Learner"	"Ian Sinclair"	"WA"]
   ["2014"	"05"  "Tetherweight_Final_B"	"Tetherweight (for Adrian Howells)"	"James Berlyn"	"WA"]
   ["2014"	"06"  "The-Floriographer_Final_B"	"The Floriographer"	"Alina Tang"	"WA"]
   ["2014"	"07"  "Lets-make-love_Final_B"	"Let’s Make Love"	"Jen Jamieson"	"WA"]
   ["2014"	"08"  "Personal-Trainer_Final_B"	"Personal Trainer"	"Tanya Lee"	"WA"]
   ["2014"	"09"  "Natual-Selection_Final_B"	"Natural Selection"	"Loren Kronemyer"	"USA/WA"]
   ["2014"	"10"  "Different-Kinds-of-Air_Final_B"	"Different Kinds of Air, a Plant’s Diary"	"Emily Parsons-Lord"	"NSW"]
   ["2014"	"11"  "Somewhere-Youve-Been-Before_Final_B"	"Somewhere You’ve Been Before"	"Hallie Shellam"	"VIC"]
   ["2014"	"12"  "Dance-With-Me_Final_B"	"Dance With Me"	"Sylvia Rimat"	"UK"]

   ["2015"	"01"  "Monopolly_Final_B"	"Monopolly"	"Chloe Flockart"	"WA"]
   ["2015"	"02"  "Once-of-Twice-Daily_Final"	"Once of Twice Daily"	"Malcolm Whittaker"	"NSW"]
   ["2015"	"03"  "Sex-Talk_Final_B"	"Sex Talk"	"Mish Grigor"	"NSW"]
   ["2015"	"04"  "Current-Mood_Final_B"	"Current Mood"	"Jackson Eaton"	"VIC"]
   ["2015"	"05"  "Micronational_Final_B"	"Micronational"	"Tom Blake"	"WA"]
   ["2015"	"06"  "After_Final_B"	"After"	"Phillip Adams"	"VIC"]
   ["2015"	"07"  "Meditations-on-Water_Final"	"Meditations on Water"	"Mei Swan Lim"	"WA"]
   ["2015"	"08"  "Beings-unlike-us_Final_B"	"Beings-unlike-us"	"Caroline Garcia"	"NSW"]
   ["2015"	"09"  "Raised-by-Brutalism_Final"	"Raised by Brutalism"	"Leon Ewing"	"WA"]
   ["2015"	"10"  "You-will-always-be-wanted-by-me_Final_B"	"You will always be wanted by me"	"Emily Parsons-Lord"	"NSW"]
   ["2015"	"11"  "When-Youre-Here-Im-Nowhere_Final"	"When you’re here, I’m nowhere"	"Brett Smith"	"WA"]
   ["2015"	"12"  "Dead-Line_Final"	"Dead Line"	"Jo Bannon"	"UK"]])

(defn get-years [videos]
  (set (reverse (map first videos))))

(defn get-videos-for-year [videos year]
  (filter #(= year (first %)) videos))

(defn home! []
  (reset! app-state initial-state))

(defn select-year! [y ev]
  (.preventDefault ev)
  (swap! app-state assoc :year y))

(defn fullscreen [e]
  (cond
    (aget e "requestFullscreen") (.requestFullscreen e)
    (aget e "mozRequestFullScreen") (.mozRequestFullScreen e)
    (aget e "webkitRequestFullScreen") (.webkitRequestFullScreen e)
    true (js/console.log "no full screen")))

;; -------------------------
;; Views

(defn component-video-inner [year filename]
  [:video {:controls true
           :autoPlay true
           :preload "auto"}
   [:source {:src (str "video/" year "/ProximityArchive_" year "_" filename ".mov")}]
   [:source {:src (str "video/" year "/ProximityArchive_" year "_" filename ".mp4")}]])

(def component-video
  (with-meta
    component-video-inner
    {:component-did-mount (fn [this]
                            (let [el (r/dom-node this)]
                              (.addEventListener el "canplay"
                                                 (fn [ev] (js/console.log "canplay")))))}))

(defn component-back-button []
  [:div#back {:on-click home!}
   [:img {:src "img/back.svg"}]])

(defn component-year [year-selected]
  [:div#year-videos
   [component-back-button]
   [:h1.year {:on-click home!} year-selected]
   (for [[video-year number filename title person place] (if (= year-selected "All") videos (get-videos-for-year videos year-selected))]
     [:div.item {:key (str video-year number)}
      [:img {:on-click #(swap! app-state assoc :video filename :year video-year)
             :src (str "video/" video-year "/ProximityArchive_" video-year "_" filename ".png")}]
      [:span.caption
       [:p title]
       [:p.alt.who person [:br] " (" place ")"]]])])

(defn component-year-list []
  [:div#year-list
   (concat
     (for [y (get-years videos)]
       [:div {:key y
              :on-click (partial select-year! y)
              :on-touch-end (partial select-year! y)}
        [:h1.year y]])
     [[:div {:key "all"
             :on-click (partial select-year! "All")
             :on-touch-end (partial select-year! "All")}
       [:h1.year "View All"]]])])

(defn home-page []
  (let [year (@app-state :year)
        video (@app-state :video)]
    (if (and video year)
      [:div
        [component-video year video] 
        [component-back-button]]
      [:div
       [:img#logo {:src "img/logo.png"
                   :on-click home!}]
       [:img#festival {:src "img/festival.png"
                       :on-click home!}]
       [:div#container
        (if year
          [component-year year]
          [component-year-list])]])))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
