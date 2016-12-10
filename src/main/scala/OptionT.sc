import cats.data.OptionT
import cats.implicits._

import scala.concurrent.Future

case class User(u: String, accountId: String)
def findUser(userId: String): OptionT[Future, User] = ???

case class Account(a: String)
def findUserAccount(accountId: String): OptionT[Future, Account] = ???

def findUserAccountByUserId(userId: String): OptionT[Future, Account] =
  for {
    user <- findUser(userId)
    account <- findUserAccount(user.accountId)
  } yield account

