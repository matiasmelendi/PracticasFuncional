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
(defn mark_cell [cellnumber m b] (if (is_unmarked (get b cellnumber)) (b cellnumber m) (throw IlegalMovementException) ))
(def create_empty_board (zipmap (range 1 10) (repeat empty_cell) ))
(def rows (partial partition-all 3))
(defn columns [board] (for [f [first second last]] (map f (partition-all 3 board)) ))


(def diagonal (comp list (partial flip select-keys [1 5 9])))
(def group-by-mark (partial group-by mark ))
(def is_empty_line (comp (partial every? is_unmarked) vals))
(def possibles_lines (for [ f [rows columns diagonal]] (f create_empty_board) ))
(def marked_lines (filter (comp every? (comp not is_unmarked)) possibles_lines ))

(def is_winning_movement (comp (comp (comp (partial some (comp not is_unmarked)) (partial flip get 2)) group-by-mark) marked_lines))
(def with_winning_movement (partial some is_winning_movement) )


;;Player
(defstruct player :name :mark )

(defn create_computer [m] (struct player "Computer" m) )
(defn create_human [n m] (struct player n m))
(defn assoc_mark [p] (p :mark))
(defn play [p cellnumber b] (mark_cell cellnumber (assoc_mark p) b) )

;;Movement


