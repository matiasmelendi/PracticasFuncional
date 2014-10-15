(ns tictactoe.player
  (use tictactoe.cell)
  (use tictactoe.board)
)

(defstruct player :name :mark )

(defn create_computer [m] (struct player "Computer" m) )
(defn create_human [n m] (struct player n m))
(defn assoc_mark [p] (p :mark))

(defn play [p cellnumber b] (mark_cell cellnumber (assoc_mark p) b) )
