(ns clochart.core
    (:use 
      [clochart.utils])
    (:import
      [com.panayotis.gnuplot JavaPlot]))


;; References:
;; http://clj-me.cgrand.net/2009/10/15/multidim-arrays/
;; http://gnujavaplot.sourceforge.net/docs/

; (doto (JavaPlot.)
;       (.addPlot "sin(x)")
;       (.plot))
; 
; (doto (JavaPlot.)
;       (.addPlot (coll-data->array [[1 1.5] [2 1] [2.5 1.1] [3 0.5]]))
;       ;(.addPlot "besj0(x)*0.12e1")
;       (.plot))

;; TODO: generic plot function
(defn- gen-plot*
  "Generic plot function."
  ([x-coll y-coll])
  )

(defn scatter-plot
  "Plots a scattergraph using Cartesian coordinates.
   EXAMPLE: 
        > (scatter-plot [1 2 2.5 3] [1.5 1 1.1 0.5])"
  ;; TODO: legend, title, data-type
  ([y-coll] (scatter-plot (range (count y-coll)) y-coll))
  ([x-coll y-coll]
   {:pre [(= (count x-coll) (count y-coll))]}
   (doto (JavaPlot.)
         (.addPlot (->> (interleave x-coll y-coll)
                        (partition 2)
                        (coll-data->array)))
         (.plot))))
