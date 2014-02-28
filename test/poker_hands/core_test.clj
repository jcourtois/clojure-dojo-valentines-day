(ns poker-hands.core-test
  (:require [clojure.test :refer :all]
            [poker-hands.core :refer :all]))

(deftest greater-card-test
  (testing "Given two numeric cards, greater-card returns the higher value"
    (is (= (greater-card "9H" "2H") "9H"))
  )

  (testing "Given one non-numeric card to a numeric one, greater-card returns the non-numeric value"
    (is (= (greater-card "AD" "2D") "AD"))
  )

  (testing "Given two non-numeric cards, greater-card returns the non-numeric value"
   (is (= (greater-card "AD" "JD") "AD"))
  )
)

(deftest convert-card-value-test
	(testing "Given a non-numeric card, it converts to numeric value")
	(is (= (convert-card-value "AD") 14))

	(testing "Given a non-numeric card, it converts to numeric value")
	(is (= (convert-card-value "KS") 13))

	(testing "Given a numeric card, it converts to numeric value")
	(is (= (convert-card-value "6C") 6))

	(testing "Given the number ten, it converts to numeric value")
	(is (= (convert-card-value "10H") 10))
)

(deftest get-winning-hand-test
  (testing "Given two hands of 5 cards, it returns the hand with the
    highest card")
  (is (= #{"2D" "JC" "5S" "QH" "AD"}
          (get-winning-hand #{"2D" "JC" "5S" "QH" "AD"}
                          #{"2D" "JC" "5S" "QH" "KD"})
         ))

  (is (= (get-winning-hand #{"2D" "JC" "5S" "QH" "KD"}
                           #{"2D" "JC" "5S" "QH" "AD"})
         #{"2D" "JC" "5S" "QH" "AD"}))
  (testing "Given two hands of 5 cards with equal high card, 
    it returns the hand with the second highest card")
  (is (= (get-winning-hand #{"2D" "5S" "QH" "4H" "3S"}
                           #{"2D" "6H" "QS" "4H" "3S"})
          #{"2D" "6H" "QH" "4H" "3S"}))
)


