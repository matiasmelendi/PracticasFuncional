(ns tictactoe.core)

;;Utilities
(defn flip [f x y] (f y x))
(def IlegalMovementException Exception)


;;Cell
(defstruct cell :mark)

(def empty_cell (struct cell :unmarked) )
(defn mark [c] (get c :mark))
(def is_unmarked (comp (partial = :unmarked) mark))

;;Board
(def board_is_empty (comp (partial every? is_unmarked) vals))
(defn mark_cell [cellnumber m b] (if (is_unmarked (get b cellnumber)) (assoc b cellnumber m) (throw IlegalMovementException) ))
(def create_empty_board (zipmap (range 1 10) (repeat empty_cell) ))

(def group_by_mark (partial group-by mark ))
(defn get_lines [board positions]  (for [p positions] (select-keys board p)))


(defn rows [board] (get_lines board [[1 2 3] [4 5 6] [7 8 9]]))
(defn columns [board] (get_lines board [[1 4 7] [2 5 8] [3 6 9]]))
(defn diagonal [board] (get_lines board [[1 5 9] [3 5 7]]))


(defn possibles_lines [board] (for [ f [rows columns diagonal]] (f board) ))
(defn is_marked_line [line] (not-every? is_unmarked (vals line)))
(defn marked_lines [board] (map (partial filter is_marked_line) (possibles_lines board)))



;;Player
(defstruct player :name :mark )

(defn create_computer [m] (struct player "Computer" m) )
(defn create_human [n m] (struct player n m))
(defn assoc_mark [p] (p :mark))
(defn play [p cellnumber b] (mark_cell cellnumber (assoc_mark p) b) )

;;Movement

;;Queda hacer que is_winning_movement filtre al que tiene más cantidad de marcas
;;y ver que esa marca no sea :unmarked
(defn XXX [marks] (= 2 ((comp count first) (vals (dissoc marks :unmarked))) ))

(defn is_winning_line [movement] (XXX (group_by_mark (vals (first movement)) )))


(defn with_winning_movement [board] (not-every? (comp not is_winning_line) (marked_lines board) ))


