(ns tictactoe.movement_spec
  (:require [speclj.core :refer :all]
            [tictactoe.movement :refer :all]
            [tictactoe.cell :refer :all]
            [tictactoe.board :refer :all]))

(describe "the behaviour of differents kinds of movements"
  (it "should be false because the row not contain a winning movement"
      (should-not (is_winning_line [{1 empty_cell 2 empty_cell 3 empty_cell}]))
      )
  (it "should be false because the row not contain a winning movement"
      (should-not (is_winning_line [(mark_cell 2 :cross {1 empty_cell 2 empty_cell 3 empty_cell})]))
        )
  (it "should be true because is a winning movement"
      (should (is_winning_line [(mark_cell 2 :cross (mark_cell 1 :cross {1 empty_cell 2 empty_cell 3 empty_cell}))]))
          )
)
