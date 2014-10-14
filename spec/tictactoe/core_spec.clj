(ns tictactoe.core-spec
  (:require [speclj.core :refer :all]
            [tictactoe.core :refer :all]))
;;Cell

(describe "the behaviour of cells"
  (it "should be true,because the cell is unmarked by default"
    (should (is_unmarked empty_cell))
      )
  (it "should mark a cell"
      (should= :cross (mark (struct cell :cross)))
        )
  (it "should be false, because the cell have a cross"
      (should-not (is_unmarked (empty_cell :cross) ))
        )
 )


;;Board

(describe "the behaviour of a board"
   (it "should be true, because an empty board is empty"
       (should (board_is_empty create_empty_board))
       )
   (it "should be false, because a cell of the board have a cross"
      (should-not (board_is_empty (mark_cell 3 :cross create_empty_board)))
       )

   (it "should be true, because an empty board not contains winning movements"
       (should-not (with_winning_movement create_empty_board))
       )
   (it "should be true, because this board contains a winning movement"
       (should (with_winning_movement (mark_cell 2 :cross (mark_cell 1 :cross create_empty_board))))
       )
 )

;;Board Lines
(describe "what's happen when we try to divide the board"

  (it "should return a list of rows "
       (should= 3 (count (rows create_empty_board)))
       )
   (it "should return a list of columns"
       (should= 3 (count (columns create_empty_board)))
       )
   (it "should return a list containing the cells of diagonal"
       (should= 2 (count (diagonal create_empty_board)))
       )
  )


;;Player

(def memo (create_human "Memo" :cross))
(describe "the behaviour of players"
  (it "should equal"
    (should= :cross (assoc_mark (create_computer :cross) ))
   )
  (it "should equal"
    (should= :cross (assoc_mark memo))
  )
  (it "shouldn't throw an exception because is a valid movement"
    (should-not-throw (play (create_computer :circle) 2 create_empty_board))
  )
  (it "should throw an exception because is an invalid movement"
    (should-throw (play memo 1 (play (create_computer :circle) 1 create_empty_board)))
  )
)

;;Movement

(describe "the behaviour of differents kinds of movements"
  (it "should be false because the row not contain a winning movement"
      (should-not (is_winning_movement {1 empty_cell 2 empty_cell 3 empty_cell}))
      )
  (it "should be false because the row not contain a winning movement"
      (should-not (is_winning_movement (mark_cell 2 :cross {1 empty_cell 2 empty_cell 3 empty_cell})))
        )
  (it "should be true because is a winning movement"
      (should (is_winning_movement (mark_cell 2 :cross (mark_cell 1 :cross {1 empty_cell 2 empty_cell 3 empty_cell}))))
          )
)
