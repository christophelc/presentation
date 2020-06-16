# Specs


```clojure
(require '[clojupyter.misc.helper :as helper])
(helper/add-dependencies '[org.clojure/spec.alpha "0.2.187"])
:ok
```




    :ok




```clojure
(require '[clojure.spec.alpha :as s])
```




    nil




```clojure
(s/def ::big-even (s/and int? even? #(> % 1000)))
```




    :user/big-even




```clojure
(s/valid? ::big-even :foo) ;; false
```




    false




```clojure
(s/valid? ::big-even 10) ;; false
```




    false




```clojure
(s/valid? ::big-even 100000) ;; true
```




    true




```clojure
(import java.util.Date)
(s/valid? inst? (Date.))
```




    true




```clojure
(s/def ::date inst?)
```




    :user/date




```clojure
(s/valid? ::date (java.util.Date.))
```




    true




```clojure
(use 'clojure.repl)
(doc ::date)
```

    -------------------------
    :user/date
    Spec
      inst?





    nil



## Composing predicate


```clojure
(s/def ::big-even (s/and int? even? #(> % 1000)))
```




    :user/big-even




```clojure
(s/valid? ::big-even :foo) ;; false
```




    false




```clojure
(s/valid? ::big-even 10) ;; false
```




    false




```clojure
(s/valid? ::big-even 100000) ;; true
```




    true




```clojure
(s/explain ::big-even 5)
```

    5 - failed: even? spec: :user/big-even





    nil



## Use specs for validation


```clojure
(ns my.domain (:require [clojure.spec.alpha :as s]))
(def email-regex #"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$")
(s/def ::email-type (s/and string? #(re-matches email-regex %)))

(s/def ::acctid int?)
(s/def ::first-name string?)
(s/def ::last-name string?)
(s/def ::email ::email-type)

(s/def ::person (s/keys :req [::first-name ::last-name ::email]
                        :opt [::phone]))
```




    :my.domain/person




```clojure
(defn person-name
  [person]
  {:pre [(s/valid? ::person person)]
   :post [(s/valid? string? %)]}
  (str (::first-name person) " " (::last-name person)))
```




    #'my.domain/person-name




```clojure
(person-name 42)
```

    Execution error (AssertionError) at my.domain/person-name (REPL:1).
    Assert failed: (s/valid? :my.domain/person person)



       core.clj:  3214 clojure.core$eval/invokeStatic

       core.clj:  3210 clojure.core$eval/invoke

       main.clj:   437 clojure.main$repl$read_eval_print__9086$fn__9089/invoke

       main.clj:   458 clojure.main$repl$fn__9095/invoke

       main.clj:   368 clojure.main$repl/doInvoke

    RestFn.java:  1523 clojure.lang.RestFn/invoke

       AFn.java:    22 clojure.lang.AFn/run

       AFn.java:    22 clojure.lang.AFn/run

    Thread.java:   748 java.lang.Thread/run



```clojure
(s/valid? ::person
  {::first-name "Bugs"
   ::last-name "Bunny"
   ::email "bugs@example.com"})
```




    true




```clojure

```
