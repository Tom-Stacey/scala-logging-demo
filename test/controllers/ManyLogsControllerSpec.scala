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

class ManyLogsControllerSpec extends ControllerTestSpec with ScalaFutures {


  val testController = new ManyLogsController(mockConfig, messages)
  lazy val request = FakeRequest("GET", "/")

  "Many Logs Controller" should {
    "return OK for all route" in {
      val res = await(testController.allLogs(request))
      status(res) shouldBe 200
      bodyOf(res) shouldBe "All the logs"
    }
  }
}
