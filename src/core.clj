;;; new file ;;;

(apply hash-map (interleave [:a :b :c] [1 2 3]))

(into {} (map vector [:a :b :c] [1 2 3]))


;;; fleetdb ;;;

;; start db with:

;;   $ java -cp fleetdb-standalone.jar fleetdb.server -f demo.fdb

;; To connect the client to the database:

(client ["ping"])

(use 'fleetdb.client)
(def client (connect {:host "127.0.0.1", :port 3400}))


(client ["insert" "accounts" {"id" 1, "owner" "Eve", "credits" 100}])


(client ["insert" "accounts"
          [{"id" 2, "owner" "Bob", "credits" 150}
           {"id" 3, "owner" "Dan", "credits" 50}
           {"id" 4, "owner" "Amy", "credits" 1000, "vip" true}]])


(client ["select" "accounts" {"where" ["=" "id" 2]}])

(client ["select" "accounts"])


(client ["insert" "accounts"
          [{"id" 52, "owner" "Fred", "credits" 2150}
           {"id" 53, "owner" "Ethel", "credits" 550}
           {"id" 54, "owner" "Lucie", "credits" 14000, "vip" false}]])


(client ["update" "accounts" {"credits" 55} {"where" ["=" "owner" "Bob"]}])

