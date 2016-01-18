(defproject org.clojars.gguthe/phpass "1.0.2"
  :description "Fork of PHPass, used for opertions around password hashing"
  :url "https://github.com/RJMetrics/PHPass.git"
  :java-source-paths ["src/main/java/org/clojars/gguthe/phpass"]
  :resource-paths ["resources/base"]
  :test-paths []
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.mindrot/jbcrypt "0.3m"]]
  :jvm-opts ["-Duser.timezone=GMT" "-XX:MaxPermSize=512M"])
