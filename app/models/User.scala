package models

/**
 * Presentation object used for displaying data in a template.
 */
case class User(
  id: String,
  name: String,
  email: String,
  addressline1: String,
  addressline2: Option[String],
  towncity: String,
  postalcode: Option[String],
  country: String,
  telephone1: Option[String],
  telephone2: Option[String],
  telephone3: Option[String]
)
