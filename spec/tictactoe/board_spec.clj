(ns tictactoe.board_spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :refer :all]
            [tictactoe.movement :refer :all]))

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
