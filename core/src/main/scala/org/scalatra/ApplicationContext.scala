package org.scalatra

import java.net.URL
import scala.collection.mutable

trait ApplicationContext extends mutable.Map[String, AnyRef] {
  def mount(handler: Handler, urlPattern: String, name: String): Unit

  def mount(handler: Handler, urlPattern: String): Unit =
    mount(handler, urlPattern, handler.getClass.getName)

  def contextPath: String

  def initParameters: mutable.Map[String, String]

  def resource(path: String): Option[URL]
}
