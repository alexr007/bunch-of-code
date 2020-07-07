package toptal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

  private Task2 task;

  @BeforeEach
  void setUp() {
    task = new Task2();
  }

  @Test
  void task() {
    assertEquals(task.task(), 2);
  }
}
