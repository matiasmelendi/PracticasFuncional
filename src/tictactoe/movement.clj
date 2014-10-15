(ns tictactoe.movement
  (use tictactoe.board))


(defn two_cells_with_the_same_mark? [marks] (= 2 ((comp count first) (vals (dissoc marks :unmarked))) ))
(defn is_winning_line [movement] (two_cells_with_the_same_mark? (group_by_mark (vals (first movement)) )))
(defn with_winning_movement [board] (not-every? (comp not is_winning_line) (marked_lines board) ))
