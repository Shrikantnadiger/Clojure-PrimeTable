(defn prime? [n]
    (not-any? zero? (map #(rem n %) (range 2 n))))


(defn primetable[]
  (println "Enter prime count")
  (let [count (Integer. (read-line))
        primes (take count (filter prime? (iterate inc 2)))
        tabledata (for [x1 primes x2 primes] (* x1 x2))]
      (doseq [x primes] (print "   " x))
      (newline)
      (keep-indexed
        (fn [index item] 
          (print (nth primes index))
          (doseq [y item] (print " " y " "))
          (newline)) (partition count tabledata))))

(primetable)
