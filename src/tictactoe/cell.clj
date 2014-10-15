(ns tictactoe.cell)

(defstruct cell :mark)

(def empty_cell (struct cell :unmarked) )
(defn mark [c] (get c :mark))
(def is_unmarked (comp (partial = :unmarked) mark))
