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

(deftest high-card-test
	(testing "Given a hand of 5 cards, it returns the highest card")
	(is (= (get-high-card ["2D" "JC" "5S" "QH" "AD"]) "AD"))
	
)

