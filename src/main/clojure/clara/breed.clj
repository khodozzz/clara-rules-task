(ns clara.breed
  (:require [clara.rules :refer :all]))

(defrecord Dog [name fur height weight tail ears body character color marks])

(defrecord DogBreed [name breed])

(defrule is-english-bulldog
  [Dog
   (= name ?name)
   (= fur :short)
   (< height 50)
   (= tail :short)]
  =>
  (println ?name "is English Bulldog")
  (insert! (->DogBreed ?name "English Bulldog")))

(defrule is-hound
  [Dog
   (= name ?name)
   (= fur :short)
   (< height 50)
   (= tail :long)
   (= ears :long)]
  =>
  (println ?name "is Hound")
  (insert! (->DogBreed ?name "Hound")))

(defrule is-pug
  [Dog
   (= name ?name)
   (= fur :short)
   (< height 50)
   (= tail :long)
   (= ears :short)]
  =>
  (println ?name "is Pug")
  (insert! (->DogBreed ?name "Pug")))

(defrule is-chihuahua
  [Dog
   (= name ?name)
   (= fur :short)
   (< height 50)
   (= tail :long)
   (= ears :short)
   (= body :long)]
  =>
  (println ?name "is Chihuahua")
  (insert! (->DogBreed ?name "Chihuahua")))

(defrule is-danish-dog
  [Dog
   (= name ?name)
   (= fur :short)
   (> height 50)
   (> weight 50)]
  =>
  (println ?name "is Danish Dog")
  (insert! (->DogBreed ?name "Danish Dog")))

(defrule is-foxhound
  [Dog
   (= name ?name)
   (= fur :short)
   (> height 50)
   (< weight 50)]
  =>
  (println ?name "is Foxhound")
  (insert! (->DogBreed ?name "Foxhound")))

(defrule is-cocker-spaniel
  [Dog
   (= name ?name)
   (= fur :long)
   (< height 50)
   (= character :friendly)]
  =>
  (println ?name "is Cocker Spaniel")
  (insert! (->DogBreed ?name "Cocker Spaniel")))

(defrule is-irish-setter
  [Dog
   (= name ?name)
   (= fur :long)
   (< height 50)
   (= character :unfriendly)]
  =>
  (println ?name "is Irish Setter")
  (insert! (->DogBreed ?name "Irish Setter")))

(defrule is-great-vendee-griffin
  [Dog
   (= name ?name)
   (= fur :long)
   (> height 50)
   (< height 70)
   (= ears :long)]
  =>
  (println ?name "is Great Vendée Griffin")
  (insert! (->DogBreed ?name "Great Vendée Griffin")))

(defrule is-collie
  [Dog
   (= name ?name)
   (= fur :long)
   (> height 50)
   (< height 70)
   (= ears :short)]
  =>
  (println ?name "is Collie")
  (insert! (->DogBreed ?name "Collie")))

(defrule is-st-bernard
  [Dog
   (= name ?name)
   (= fur :long)
   (> height 70)
   (= color :red)
   (= marks :white)]
  =>
  (println ?name "St. Bernard")
  (insert! (->DogBreed ?name "St. Bernard")))

(defrule is-irish-wolfhound
  [Dog
   (= name ?name)
   (= fur :long)
   (> height 70)
   (= color :white)]
  =>
  (println ?name "is Irish Wolfhound")
  (insert! (->DogBreed ?name "Irish Wolfhound")))

(defrule is-newfoundland
  [Dog
   (= name ?name)
   (= fur :long)
   (> height 70)
   (not= color :white)
   (not= color :red)]
  =>
  (println ?name "is Newfoundland")
  (insert! (->DogBreed ?name "Newfoundland")))


(defquery get-dogs
  []
  [?dog <- Dog])

(defquery get-breeds
  []
  [?dogBreed <- DogBreed])


(defn run-examples
  []
  (let [session (-> (mk-session 'clara.breed)
                    (insert (->Dog "Dog1" :long 55 65 :short :short :long :friendly :white :no))
                    (insert (->Dog "Dog2" :short 25 20 :short :short :long :friendly :white :no))
                    (insert (->Dog "Dog3" :short 55 20 :long :long :long :unfriendly :red :no))
                    (insert (->Dog "Dog4" :short 25 20 :short :short :long :friendly :red :no))
                    (insert (->Dog "Dog5" :short 55 60 :short :short :long :friendly :red :white))
                    (insert (->Dog "Dog6" :short 55 60 :long :short :short :unfriendly :white :no))
                    (fire-rules))]

    (println)
    (println "saved dogs")
    (clojure.pprint/pprint (query session get-dogs))
    (println)
    (println "saved results")
    (clojure.pprint/pprint (query session get-breeds))))


(defn -main []
  (run-examples))