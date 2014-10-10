(ns tictactoe.core)

;;Utilities
(defn flip [f x y] (f y x))
(def IlegalMovementException Exception)


;;Cell
(defstruct cell :mark)

(def empty_cell (struct cell :unmarked) )
(def is_unmarked (comp (partial = :unmarked) (partial flip get :mark)))
(defn mark [c] (get c :mark))


;;Board
(def board_is_empty (comp (partial every? is_unmarked) vals))
(defn mark_cell [cellnumber m b] (if (is_unmarked (get b cellnumber)) (b cellnumber m) (throw IlegalMovementException) ))
(def create_empty_board (zipmap (range 1 10) (repeat empty_cell) ))
(def rows (partial partition-all 3))
(def columns (comp first (partial partition-all 3)))
(defn diagonal [board] (map (comp get (partition-all 3 board)) '(1 5 9) ))

    ;;Will fix these functions
(def columns (comp first (partial partition-all 3)))
(defn diagonal [board] (map (comp get (partition-all 3 board)) '(1 5 9) ))

(def possibles_lines (for [ f '(rows columns diagonal)] (partial reduce (partial f) []) ))
(def marked_lines (filter (comp every? (comp not is_unmarked)) possibles_lines ))

(def is_winning_movement (comp (comp (comp not is_unmarked) (partial flip get 2)) (partial group-by mark )))
(def with_winning_movement (partial some is_winning_movement) )





;;Player
(defstruct player :name :mark )

(defn create_computer [m] (struct player "Computer" m) )
(defn create_human [n m] (struct player n m))
(defn assoc_mark [p] (p :mark))
(defn play [p cellnumber b] (mark_cell cellnumber (assoc_mark p) b) )
(def with_winning_movement (for [ f [rows columns diagonal]] (partial map (partial eval f) ) ))

;;Movement


