(defproject algorithm-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "https://github.com/kbaba1001/algorithm-clojure/blob/main/LICENSE"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot learn-clojure.core
  :target-path "target/%s"
  :plugins [[lein-exec "0.3.7"]]
  :profiles {:uberjar {:aot :all}
             :project/dev {:dependencies [[philoskim/debux "0.7.7"]]
                           :injections [(require '[debux.core :as d])]}})
