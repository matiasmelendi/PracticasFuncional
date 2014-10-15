(ns tictactoe.player_spec
  (:require [speclj.core :refer :all]
            [tictactoe.player :refer :all]
            [tictactoe.board :refer :all]))

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
