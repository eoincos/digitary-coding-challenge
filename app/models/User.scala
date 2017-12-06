package models

/**
 * Presentation object used for displaying data in a template.
 */
case class User(
  id: String,
  name: String,
  email: String,
  addressLine1: String,
  addressLine2: Option[String],
  townCity: String,
  postalCode: Option[String],
  country: String,
  telephone1: Option[String],
  telephone2: Option[String],
  telephone3: Option[String]
)
