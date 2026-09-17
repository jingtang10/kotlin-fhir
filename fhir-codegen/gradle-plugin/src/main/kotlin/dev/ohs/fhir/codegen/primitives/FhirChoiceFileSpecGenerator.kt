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

package dev.ohs.fhir.codegen.primitives

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import dev.ohs.fhir.codegen.schema.sanitizeKDoc

/**
 * Generates a [FileSpec] for `FhirChoice.kt` containing the `FhirChoice` interface.
 *
 * All generated choice-type sealed interfaces implement this interface to provide uniform access to
 * the underlying unwrapped [value].
 */
object FhirChoiceFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val fhirChoiceClassName = ClassName(packageName, "FhirChoice")
    return FileSpec.builder(fhirChoiceClassName)
      .addType(
        TypeSpec.interfaceBuilder(fhirChoiceClassName)
          .addModifiers(KModifier.PUBLIC)
          .addProperty(
            PropertySpec.builder("value", ANY)
              .addKdoc("The unwrapped value of the choice element.")
              .build()
          )
          .addKdoc(
            """
            A common interface for all polymorphic choice-type elements (`[x]`).
            """
              .trimIndent()
              .sanitizeKDoc()
          )
          .build()
      )
      .build()
  }
}
