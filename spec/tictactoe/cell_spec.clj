(ns tictactoe.cell_spec
  (:require [speclj.core :refer :all]
            [tictactoe.cell :refer :all]))

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
