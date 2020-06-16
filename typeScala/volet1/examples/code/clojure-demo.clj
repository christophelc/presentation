(println (str "Date:\t\t\t" (java.util.Date.)))
(println (apply format "Clojure version:\tv%d.%d" ((juxt :major :minor) *clojure-version*)))
(println (str "Clojupyter version:\t" (clojupyter.kernel.version/version-string)));

(def hello (fn [] "Hello world"))

(hello)

(defn argcount
  ([] 0)
  ([x] 1)
  ([x y] 2)
  ([x y & more] (+ (argcount x y) (count more))))

(argcount)

(argcount 1)

(argcount 1 2)

(argcount 1 2 3 4 5)

(let [my-vector [1 2 3 4]
      my-map {:fred "ethel"}
      my-list (list 4 3 2 1)]
  (list
    (conj my-vector 5)
    (assoc my-map :ricky "lucy")
    (conj my-list 5)
    ;the originals are intact
    my-vector
    my-map
    my-list))

(require '[clojupyter.display :as display])

;; displaying html
(display/hiccup-html 
    [:ul 
     [:li "a " [:i "emphatic"] " idea"]
     [:li "a " [:b "bold"] " idea"]
     [:li "an " [:span {:style "text-decoration: underline;"} "important"] " idea"]])

(display/hiccup-html
    [:svg {:height 100 :width 100 :xmlns "http://www.w3.org/2000/svg"}
            [:circle {:cx 50 :cy 40 :r 40 :fill "red"}]])

(->> clojupyter/*logo* type (str "Logo is of type: ") println)
clojupyter/*logo*

(display/render-mime "text/plain" "This is plain text.")

(display/render-mime "text/html" "<h1>This is a heading</h1>")

;; do not use VPN
(require '[clojupyter.misc.helper :as helper])
(helper/add-dependencies '[incanter "1.5.7"])
(use '(incanter core stats charts io)) ; include Incanter's facilities into working namespace
:ok

(-> (sample-normal 10000)
    histogram
    (.createBufferedImage 600 400))

(-> (scatter-plot (sample-normal 1000) 
                  (sample-normal 1000)
                  :x-label "x" :y-label "y")
    (.createBufferedImage 600 400))

clojupyter/*license*
