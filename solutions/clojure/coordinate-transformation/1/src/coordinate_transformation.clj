(ns coordinate-transformation)

(defn translate2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y] (vector (+ x dx) (+ y dy)))
  )

(defn scale2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y] (vector (* x sx) (* y sy)))
  )

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y] 
    (def res (f x y))
    (g (first res) (second res))))

(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  (let [cache (atom {})]
    (fn [x y]
      (def cached (get @cache (vector x y) nil))
      (if (not (= cached nil))
        cached
        (let [res (f x y)]
          (reset! cache {(vector x y) res})
          res)))))  
