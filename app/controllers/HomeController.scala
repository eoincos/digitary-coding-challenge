package controllers

import javax.inject.{Inject, Singleton}

import com.example.user._
import play.api.data.Form
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class HomeController @Inject() (userDAO: UserDAO, cc: MessagesControllerComponents)
                               (implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  import UserForm._

  private val postUrl = routes.HomeController.createUser()

  def index = Action.async { implicit request =>
    userDAO.all.map { users =>
      Ok(views.html.index(users, form, postUrl))
    }
  }

  // This will be the action that handles our form post
  def createUser = Action.async { implicit request =>
    val errorFunction = { formWithErrors: Form[Data] =>
      // This is the bad case, where the form had validation errors.
      // Let's show the user the form again, with the errors highlighted.
      // Note how we pass the form with errors to the template.
      userDAO.all.map { users =>
        BadRequest(views.html.index(users, formWithErrors, postUrl))
      }
    }

    val successFunction = { data: Data =>
      // This is the good case, where the form was successfully parsed as a Data.
      val user = User(
        id = data.id,
        name = data.name,
        email = data.email,
        addressline1 = data.addressline1,
        addressline2 = data.addressline2,
        towncity = data.towncity,
        postalcode = data.postalcode,
        country = data.country,
        telephone1 = data.telephone1,
        telephone2 = data.telephone2,
        telephone3 = data.telephone3
      )

      userDAO.create(user).map { id =>
        //Redirect(routes.HomeController.index()).flashing("info" -> ("User added!" + id))
        //Ok("User added!")
        Redirect(routes.HomeController.index())
      }
    }

    val formValidationResult = form.bindFromRequest
    formValidationResult.fold(errorFunction, successFunction)
  }
}
