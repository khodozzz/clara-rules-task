(defproject com.cerner/clara-examples "0.2.0-SNAPSHOT"
  :dependencies [[com.google.guava/guava "15.0"] ; Explicitly pull new Guava version for dependency conflicts.
                 [org.clojure/clojure "1.7.0"]
                 [com.cerner/clara-rules "0.21.0"]

                 ;; Dependencies for ClojureScript example.
                 [prismatic/dommy "1.1.0"]
                 [hipo "0.4.0"]
                 [org.clojure/clojurescript "1.7.170"]

                 ;; Dependency for time-based rules example.
                 [clj-time "0.6.0"]

                 ;; Dependency for rule DSL example.
                 [instaparse "1.4.1"]

                 ;; !
                 [org.clojure/tools.nrepl "0.2.13"]

                 ;; !
                 [javax.xml.bind/jaxb-api "2.4.0-b180830.0359"]]

  :plugins [[lein-cljsbuild "1.1.1"]]
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :java-source-paths ["src/main/java"]
  :main clara.breed)
