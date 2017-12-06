package controllers

object UserForm {
  import play.api.data.Forms._
  import play.api.data.Form

  /**
   * A form processing DTO that maps to the form below.
   *
   * Using a class specifically for form binding reduces the chances
   * of a parameter tampering attack and makes code clearer.
   */
  case class Data(
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

  /**
   * The form definition for the "create a user" form.
   * It specifies the form fields and their types,
   * as well as how to convert from a Data to form data and vice versa.
   */
  val form = Form(
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "email" -> email,
      "addressline1" -> nonEmptyText,
      "addressline2" -> optional(text),
      "towncity" -> nonEmptyText,
      "postalcode" -> optional(text),
      "country" -> nonEmptyText,
      "telephone1" -> optional(text),
      "telephone2" -> optional(text),
      "telephone3" -> optional(text)
    )(Data.apply)(Data.unapply)
  )
}
