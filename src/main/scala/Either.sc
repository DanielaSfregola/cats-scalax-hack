def validateEmail(e: String): Either[String, String] =
  if (e.contains("@")) Right(e)
  else Left("wrong!")

def validatePhone(p: String): Either[String, String] =
  if (p.forall(_.isDigit)) Right(p)
  else Left("BOOHHHHH")

validateEmail("whatever@whatever.com")
validateEmail("yo bro")


def validateEmailAndPhone(e: String, p: String): Either[List[String], (String, String)] = ???
