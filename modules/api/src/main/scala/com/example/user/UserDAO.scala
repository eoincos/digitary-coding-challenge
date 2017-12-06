package com.example.user

import org.joda.time.DateTime

import scala.concurrent.{ExecutionContext, Future}

/**
 * An implementation dependent DAO.  This could be implemented by Slick, Cassandra, or a REST API.
 */
trait UserDAO {

  def lookup(id: String): Future[Option[User]]

  def all: Future[Seq[User]]

  def update(user: User): Future[Int]

  def delete(id: String): Future[Int]

  def create(user: User): Future[Int]

  def close(): Future[Unit]
}

/**
 * Implementation independent aggregate root.
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
