package toptal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

  private Task1 task;

  @BeforeEach
  void setUp() {
    task = new Task1();
  }

  @Test
  void task() {
    assertEquals(task.task(), 1);
  }
}
