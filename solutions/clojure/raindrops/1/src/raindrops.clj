(ns raindrops)

(defn convert [n]
      (let [[mod3 mod5 mod7 result] [(mod n 3) (mod n 5) (mod n 7) (atom "")]]
        (if (= 0 mod3) (swap! result str "Pling"))
        (if (= 0 mod5) (swap! result str "Plang"))
        (if (= 0 mod7) (swap! result str "Plong"))
        (if (and (not= 0 mod3) (not= 0 mod5) (not= 0 mod7)) (swap! result str n))
        @result))
