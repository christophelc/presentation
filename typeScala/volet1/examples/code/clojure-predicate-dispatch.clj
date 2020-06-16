(require '[clojupyter.misc.helper :as helper])
(helper/add-dependencies '[selfsame/pdfn "1.0.3"])
:ok

(ns foo.core (:require [pdfn.core :refer :all]))

(defpdfn open)

(pdfn open [subject ^:contents object] 
  (str "opening reveals" (:contents object)))

(pdfn open [subject object] 
  {object (and* :contents :locked)}
  (str "it's locked"))

(pdfn open [^:key subject object] 
  {object (and* :contents :locked)}
  (str "unlocking and opening reveals" (:contents object)))

(open {} {:locked true :contents [:boots]})

(open {:key true} {:locked true :contents [:boots]})

(defpdfn ^:inline foo)

(pdfn foo 
  ([^pos?  a        b ^map?   c] :fish)
  ([^pos?  a ^neg?  b ^empty? c] :snail)
  ([^neg?  a ^zero? b         c] :mouse)
  ([       a ^neg?  b ^map?   c] :bird)
  ([^neg?  a        b ^set?   c] :dog)
  ([^odd?  a ^pos?  b         c] :lion)
  ([^even? a ^neg?  b ^map?   c] :horse))

(foo 4 -1 [])


