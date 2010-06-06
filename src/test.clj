((loop [result [] x 5 ]
   (if (zero? x)
     result
     (recur (conj result x) (dec x))))

					
(merge-with
       concat
       {:rubble ["Barney"] :flintstone [ "Fred"]}
       {:rubble [ "Betty" ] :flintstone [ "Wilma"]}
       {:rubble ["Bam-Bam"] :flintstone [ "Pebbles"]})