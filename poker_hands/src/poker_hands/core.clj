(ns poker-hands.core)

(def card-values
  {"A" 14, "K" 13, "Q" 12, "J" 11}
)

(defn convert-card-value
  [card]
  (if (nil? (get card-values (apply str(drop-last card))))
  	(Integer/parseInt (apply str(drop-last card)))
  	(get card-values (apply str(drop-last card)))
  )
)

(defn greater-card
  [first-card second-card]
  (if (pos? (compare (convert-card-value first-card) (convert-card-value second-card)) )
  	first-card
  	second-card
  )
)

(defn get-high-card
	[hand]
	(reduce greater-card hand)
)

