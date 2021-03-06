(defproject dda/pallet "0.9.2-SNAPSHOT"
  :description
  "DevOps for the JVM.

Pallet is a platform for agile and programmatic automation of infrastructure
in the cloud, on server racks or directly on virtual machines. Pallet
provides cloud provider and operating system independence, and allows for an
unprecedented level of customization."

  :url "http://palletops.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:url "git@github.com:DomainDrivenArchitecture/pallet.git"}

  :dependencies [[org.clojure/tools.logging "0.5.0-alpha"]
                 [org.clojure/tools.macro "0.1.5"]
                 [org.clojure/tools.cli "0.4.1"]
                 [org.clojure/algo.monads "0.1.6"]
                 [dda/chiba "0.2.3" :exclusions [razum2um/bultitude]]
                 [razum2um/bultitude "0.3.1"]
                 [com.palletops/thread-expr "1.3.0"]
                 [dda/pallet-common "0.5.0" :exclusions [org.clojure/tools.logging]]
                 [com.palletops/pallet-repl "0.8.0-beta.2"
                  :exclusions [com.palletops/pallet]]
                 ;do NOT upgrade script-exec to version 0.5.0 as it is older!
                 [com.palletops/script-exec "0.4.2" :exclusions [com.palletops/pallet-common]]
                 [dda/stevedore "0.9.0-beta.1" :exclusions [org.clojure/tools.logging]]
                 [clj-ssh "0.5.14"]
                 [enlive "1.1.6"
                  :exclusions [org.clojure/clojure]]
                 [pallet-fsmop "0.3.1"
                  :exclusions [org.clojure/tools.logging]]
                 [pallet-map-merge "0.1.1"]
                 [org.clojars.runa/clj-schema "0.9.4"]
                 ;TODO: org.clojars.runa/clj-schema "1.0.0" is no longer compatible with clojure1.10
                 ;[dda/clj-schema "1.0.1-SNAPSHOT"]
                 [prismatic/schema "1.1.10"]
                 [org.flatland/useful "0.11.6"]
                 [commons-codec "1.12"]]
  :classifiers {:tests {:source-paths ^:replace ["test"]
                        :resource-paths ^:replace []}}
  :test-selectors {:default
                   ;; travis sudo is configured with !env_reset
                   (complement :require-no-ssh-env)}
  :deploy-repositories [["snapshots" :clojars]
                        ["releases" :clojars]]
  :aliases {"test-all" ["with-profile" "-user,+1.10:-user,+1.9:-user,+1.8" "test"]
            "test-latest" ["with-profile" "-user,+1.10" "test"]})
