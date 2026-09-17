/*
 * Copyright 2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.FhirChoice as R4FhirChoice
import dev.ohs.fhir.model.r4.Observation as R4Observation
import dev.ohs.fhir.model.r4.Quantity as R4Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4b.FhirChoice as R4bFhirChoice
import dev.ohs.fhir.model.r4b.Observation as R4bObservation
import dev.ohs.fhir.model.r4b.Quantity as R4bQuantity
import dev.ohs.fhir.model.r5.FhirChoice as R5FhirChoice
import dev.ohs.fhir.model.r5.Observation as R5Observation
import dev.ohs.fhir.model.r5.Quantity as R5Quantity
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertIs

class FhirChoiceTest :
  FunSpec({
    test("R4 choice type implements FhirChoice and provides unwrapped value") {
      val qty = R4Quantity(id = "q1")
      val choiceValue: R4FhirChoice = R4Observation.Value.Quantity(qty)
      assertEquals(qty, choiceValue.value)
      assertIs<R4Quantity>(choiceValue.value)

      val str = R4String(value = "test-string")
      val strChoice: R4FhirChoice = R4Observation.Value.String(str)
      assertEquals(str, strChoice.value)
      assertIs<R4String>(strChoice.value)
    }

    test("R4B choice type implements FhirChoice and provides unwrapped value") {
      val qty = R4bQuantity(id = "q1")
      val choiceValue: R4bFhirChoice = R4bObservation.Value.Quantity(qty)
      assertEquals(qty, choiceValue.value)
      assertIs<R4bQuantity>(choiceValue.value)
    }

    test("R5 choice type implements FhirChoice and provides unwrapped value") {
      val qty = R5Quantity(id = "q1")
      val choiceValue: R5FhirChoice = R5Observation.Value.Quantity(qty)
      assertEquals(qty, choiceValue.value)
      assertIs<R5Quantity>(choiceValue.value)
    }
  })
