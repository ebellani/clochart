(ns clochart.utils)


(defn coll-data->array
  "Converts a collection of collections into a 2D java array.
   The default data-type is Double/TYPE. 
   EXAMPLE:
        > (coll-data->array [[1 1] [2 2]] Double/TYPE)
        #<double[][] [[D@347f65f2>"
  ([coll-data] (coll-data->array coll-data Double/TYPE))
  ([coll-data data-type]
   (->> (map (partial into-array data-type) coll-data)
        (into-array))))
