(ns proximity-videos.core
    (:require
      [reagent.core :as r]))

(def initial-state {:year nil
                    :video nil})
(defonce app-state (r/atom initial-state))

(def videos
  [["2012"	"01"	"Hydrosis"	"Janette McGinty"	"WA"]
   ["2012"	"02"	"How To Have A 3 Minute Shower"	"Jen Jamieson"	"WA"]
   ["2012"	"03"	"Your Private Hoofer"	"Claudia Alessi & Rhiannon Newton"	"WA"]
   ["2012"	"04"	"Slowfood Sunday"	"Sarah Rowbottam"	"WA"]
   ["2012"	"05"	"Ush and Them"	"Nikki Jones"	"WA"]
   ["2012"	"06"	"Flush"	"Janet Carter"	"WA"]
   ["2012"	"07"	"Fragmentation 1.2"	"Hellen Russo"	"WA"]
   ["2012"	"08"	"How Close Do You Want Me?"	"Russya Connor"	"WA"]
   ["2012"	"09"	"Mobile Moments: Series #2"	"Sarah Nelson"	"WA"]
   ["2012"	"10"	"Sweetlife"	"James Berlyn"	"WA"]
   ["2012"	"11"	"The Union"	"Renae Coles"	"WA"]
   ["2012"	"12"	"Glory Hole Beard"	"Jackson Eaton"	"WA"]
   ["2013"	"01"	"Ours"	"Elise Reitze"	"WA"]
   ["2013"	"02"	"The Plantarum: Empathic Limb Clinic"	"Cat Jones & Melissa Hunt"	"NSW"]
   ["2013"	"03"	"Asterion"	"Humphrey Bower"	"WA"]
   ["2013"	"04"	"Remains Management Services"	"Loren Kronemyer "	"USA/WA"]
   ["2013"	"05"	"Incendia Lascivio"	"Sarah Elson"	"WA"]
   ["2013"	"06"	"The Mark"	"Moya Thomas"	"WA"]
   ["2013"	"07"	"Where You End & I Begin"	"Rachel Ariane Ogle "	"WA"]
   ["2013"	"08"	"Hang"	"Ian Sinclair"	"WA"]
   ["2013"	"09"	"Prior Arrangement"	"Janet Pettigrew "	"WA"]
   ["2013"	"10"	"String Duet"	"Leon Hendroff & Emma Craig"	"WA"]
   ["2013"	"11"	"Meditation on the breath"	"Janet Carter & Nikki Jones"	"WA"]
   ["2013"	"12"	"The Gallery of Impermanent Things"	"Daniel Nevin"	"WA"]
   ["2014"	"01"	"Anatomy’s Confection"	"Cat Jones"	"NSW"]
   ["2014"	"02"	"Twerkshop"	"Caroline Garcia"	"NSW"]
   ["2014"	"03"	"The Queue"	"Toyi-Toyi Theatre"	"WA"]
   ["2014"	"04"	"Learner"	"Ian Sinclair"	"WA"]
   ["2014"	"05"	"Tetherweight (for Adrian Howells)"	"James Berlyn"	"WA"]
   ["2014"	"06"	"The Floriographer"	"Alina Tang"	"WA"]
   ["2014"	"07"	"Let’s Make Love"	"Jen Jamieson"	"WA"]
   ["2014"	"08"	"Personal Trainer"	"Tanya Lee"	"WA"]
   ["2014"	"09"	"Natural Selection"	"Loren Kronemyer"	"USA/WA"]
   ["2014"	"10"	"Different Kinds of Air, a Plant’s Diary"	"Emily Parsons-Lord"	"NSW"]
   ["2014"	"11"	"Somewhere You’ve Been Before"	"Hallie Shellam"	"VIC"]
   ["2014"	"12"	"Dance With Me"	"Sylvia Rimat"	"UK"]
   ["2015"	"01"	"Monopolly"	"Chloe Flockart"	"WA"]
   ["2015"	"02"	"Once of Twice Daily"	"Malcolm Whittaker"	"NSW"]
   ["2015"	"03"	"Sex Talk"	"Mish Grigor"	"NSW"]
   ["2015"	"04"	"Current Mood"	"Jackson Eaton"	"VIC"]
   ["2015"	"05"	"Micronational"	"Tom Blake"	"WA"]
   ["2015"	"06"	"After"	"Phillip Adams"	"VIC"]
   ["2015"	"07"	"Meditations on Water"	"Mei Swan Lim"	"WA"]
   ["2015"	"08"	"Beings-unlike-us"	"Caroline Garcia"	"NSW"]
   ["2015"	"09"	"Raised by Brutalism"	"Leon Ewing"	"WA"]
   ["2015"	"10"	"You will always be wanted by me"	"Emily Parsons-Lord"	"NSW"]
   ["2015"	"11"	"When you’re here, I’m nowhere"	"Brett Smith"	"WA"]
   ["2015"	"12"	"Dead Line"	"Jo Bannon"	"UK"]])

(defn get-years [videos]
  (set (reverse (map first videos))))

(defn get-videos-for-year [videos year]
  (filter #(= year (first %)) videos))

(defn home! []
  (reset! app-state initial-state))

;; -------------------------
;; Views

(defn component-year [year]
  [:div
   [:h1.year {:on-click home!} year]
   (for [[year number title person place] (get-videos-for-year videos year)]
     [:div.item {:key (str year number)}
      [:video {:src (str year "." number ".mp4")}]
      [:span.caption
       [:p title]
       [:p.alt.who person [:br] " (" place ")"]]])])

(defn component-year-list []
  [:div
   (for [y (get-years videos)]
     [:div {:key y
            :on-click (fn [ev] (.preventDefault ev) (swap! app-state assoc :year y))}
      [:h1.year y]])])

(defn home-page []
  (let [year (@app-state :year)
        video (@app-state :video)]
    [:div
     [:img#logo {:src "img/logo.png"
                 :on-click home!}]
     [:img#festival {:src "img/festival.png"
                     :on-click home!}]
     [:div#container
      (if year
        [component-year year]
        [component-year-list])]
     [:div#filter-cover]]))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
