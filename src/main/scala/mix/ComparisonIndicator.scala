package mix

sealed trait ComparisonIndicator

case object LESS extends ComparisonIndicator
case object EQUAL extends ComparisonIndicator
case object GREATER extends ComparisonIndicator
