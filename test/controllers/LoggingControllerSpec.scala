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

import helpers.ControllerTestSpec
import org.scalatest.concurrent.ScalaFutures
import play.api.test.FakeRequest

class LoggingControllerSpec extends ControllerTestSpec with ScalaFutures {


  val testController = new LoggingController(mockConfig, messages)
  lazy val request = FakeRequest("GET", "/")

  "Controller" should {
    "return OK for trace route" in {
      val res = await(testController.traceLevel(request))
      status(res) shouldBe 200
      bodyOf(res) shouldBe "TRACE level event logged"
    }
    "return OK for debug route" in {
      val res = await(testController.debugLevel(request))
      status(res) shouldBe 200
      bodyOf(res) shouldBe "DEBUG level event logged"
    }
    "return OK for info route" in {
      val res = await(testController.infoLevel(request))
      status(res) shouldBe 200
      bodyOf(res) shouldBe "INFO level event logged"
    }
    "return OK for warn route" in {
      val res = await(testController.warnLevel(request))
      status(res) shouldBe 200
      bodyOf(res) shouldBe "WARN level event logged"
    }
    "return OK for error route" in {
      val res = await(testController.errorLevel(request))
      status(res) shouldBe 200
      bodyOf(res) shouldBe "ERROR level event logged"
    }
  }

}
