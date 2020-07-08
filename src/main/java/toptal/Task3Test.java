package toptal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {

  private Task3 task;

  @BeforeEach
  void setUp() {
    task = new Task3();
  }

  @Test
  void task() {
    assertEquals(task.task(), 3);
  }
}
