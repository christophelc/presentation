# Specs


```clojure
(require '[clojupyter.misc.helper :as helper])
(helper/add-dependencies '[selfsame/pdfn "1.0.3"])
:ok
```




    :ok




```clojure
(ns foo.core (:require [pdfn.core :refer :all]))
```




    nil




```clojure
(defpdfn open)

(pdfn open [subject ^:contents object] 
  (str "opening reveals" (:contents object)))

(pdfn open [subject object] 
  {object (and* :contents :locked)}
  (str "it's locked"))

(pdfn open [^:key subject object] 
  {object (and* :contents :locked)}
  (str "unlocking and opening reveals" (:contents object)))
```




    #'foo.core/open




```clojure
(open {} {:locked true :contents [:boots]})
```




    "it's locked"




```clojure
(open {:key true} {:locked true :contents [:boots]})
```




    "unlocking and opening reveals[:boots]"




```clojure
(defpdfn ^:inline foo)
```




    #'foo.core/foo




```clojure
(pdfn foo 
  ([^pos?  a        b ^map?   c] :fish)
  ([^pos?  a ^neg?  b ^empty? c] :snail)
  ([^neg?  a ^zero? b         c] :mouse)
  ([       a ^neg?  b ^map?   c] :bird)
  ([^neg?  a        b ^set?   c] :dog)
  ([^odd?  a ^pos?  b         c] :lion)
  ([^even? a ^neg?  b ^map?   c] :horse))
```




    #'foo.core/foo




```clojure
(foo 4 -1 [])
```




    :snail




```clojure

```
