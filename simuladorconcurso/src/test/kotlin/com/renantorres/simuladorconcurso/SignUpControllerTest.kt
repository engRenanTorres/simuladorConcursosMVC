package com.renantorres.simuladorconcurso

import com.renantorres.simuladorconcurso.model.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  properties = [
    "spring.datasource.url=jdbc:h2:mem:testdb"
  ]
)

class SignUpControllerTest (@Autowired val client: TestRestTemplate) {
  @Test
  fun `should save a new user`(){
    val user1 = User(
      name = "Renan",
      lastName = "Torres",
      email = "renstorres@gmail.com",
      password = "123"
    )



    assertThat( 1 + 2 ).isEqualTo(3)
  }
}