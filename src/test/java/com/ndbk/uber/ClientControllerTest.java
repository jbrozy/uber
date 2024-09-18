package com.ndbk.uber;

import com.ndbk.uber.controller.ClientController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class ClientControllerTest {
  @Autowired
  private ClientController _clientController;

  @Test
  void contextLoads() throws Exception {
    assertThat(_clientController).isNotNull();
  }
}
