(require '[clojupyter.misc.helper :as helper])
(helper/add-dependencies '[org.clojure/spec.alpha "0.2.187"])
:ok

(require '[clojure.spec.alpha :as s])

(s/def ::big-even (s/and int? even? #(> % 1000)))

(s/valid? ::big-even :foo) ;; false

(s/valid? ::big-even 10) ;; false

(s/valid? ::big-even 100000) ;; true

(import java.util.Date)
(s/valid? inst? (Date.))

(s/def ::date inst?)

(s/valid? ::date (java.util.Date.))

(use 'clojure.repl)
(doc ::date)

(s/def ::big-even (s/and int? even? #(> % 1000)))

(s/valid? ::big-even :foo) ;; false

(s/valid? ::big-even 10) ;; false

(s/valid? ::big-even 100000) ;; true

(s/explain ::big-even 5)

(ns my.domain (:require [clojure.spec.alpha :as s]))
(def email-regex #"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,63}$")
(s/def ::email-type (s/and string? #(re-matches email-regex %)))

(s/def ::acctid int?)
(s/def ::first-name string?)
(s/def ::last-name string?)
(s/def ::email ::email-type)

(s/def ::person (s/keys :req [::first-name ::last-name ::email]
                        :opt [::phone]))

(defn person-name
  [person]
  {:pre [(s/valid? ::person person)]
   :post [(s/valid? string? %)]}
  (str (::first-name person) " " (::last-name person)))

(person-name 42)

(s/valid? ::person
  {::first-name "Bugs"
   ::last-name "Bunny"
   ::email "bugs@example.com"})


