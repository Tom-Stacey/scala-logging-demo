/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import javax.inject.{Inject, Singleton}

import config.AppConfig
import play.api.Logger
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent}
import uk.gov.hmrc.play.frontend.controller.FrontendController

@Singleton
class LoggingController @Inject()(
                                       config: AppConfig,
                                       val messagesApi: MessagesApi
                                     ) extends FrontendController with I18nSupport{

  val controllerLogger = Logger(this.getClass)

  val traceLevel: Action[AnyContent] = Action {
    Logger.trace("trace level log")
    controllerLogger.warn("Log event specific to this controller")
    Ok("TRACE level event logged")
  }

  val debugLevel: Action[AnyContent] = Action {
    Logger.debug("debug level log")
    Ok("DEBUG level event logged")
  }

  val infoLevel: Action[AnyContent] = Action {
    Logger.info("info level log")
    Ok("INFO level event logged")
  }

  val warnLevel: Action[AnyContent] = Action {
    Logger.warn("warn level log")
    Ok("WARN level event logged")
  }

  val errorLevel: Action[AnyContent] = Action {
    Logger.error("error level log")
    Ok("ERROR level event logged")
  }

}