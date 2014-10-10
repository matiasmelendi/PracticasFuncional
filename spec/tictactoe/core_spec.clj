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
   (it "should return a list of lists containing the rows of the board"
       (should= 3 (count (rows create_empty_board)))
       )
   (it "Not implemented yet" ;;"should be true, because an empty board not contains winning movements"
       (should false) ;; (with_winning_movement create_empty_board))
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
  (it "Not implemented yet"
      (should-not true))

          )
