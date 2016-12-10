import cats.data.Validated
import cats.data.Validated.{Invalid, Valid}
import cats.Apply
//import cats.implicits._


def validateEmail(e: String): Validated[List[String], String] =
  if (e.contains("@")) Valid(e)
  else Invalid(List("sorry bro!"))

def validatePhone(p: String): Validated[List[String], String] =
  if (p.forall(_.isDigit)) Valid(p)
  else Invalid(List("think again..."))

type Validation[T] = Validated[List[String], T]

case class Data(email: String, phone: String, bro: Int)
def validateEmailAndPhone(e: String, p: String): Validated[List[String], Data] = {
  val validatedEmail = validatedEmail(e)
  val validatedPhone = validatedPhone(p)
  val validation: Validated[List[String], Int] = Valid(5)

  Apply[Validation].map3(validatedEmail, validatedPhone, validation)(Data)
//  (validatedEmail |@| validatedPhone |@| validation).map(Data)
}

