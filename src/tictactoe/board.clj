(ns tictactoe.board
  (use tictactoe.cell)
  (use tictactoe.utilities)
 )

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
