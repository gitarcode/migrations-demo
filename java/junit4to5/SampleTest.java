/*
 * Copyright (c) 2024 Gitar, Inc.
 */
package co.gitar;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SampleTest extends BaseTest {
  @BeforeAll
  public static void setup() {
    // ...
  }

  @BeforeEach
  public void reset() {
    // ...
  }

  @Test
  public void test1() {
    assertThat(asList("c", "a", "b"), containsInAnyOrder("a", "b", "c"));
  }

  @Test
  @Disabled
  public void test2() {
    String[] a1 = new String[] {"c", "a", "b"};
    String[] a2 = new String[3];
    a2[0] = "a";
    a2[1] = "b";
    a2[2] = "c";
    assertThat(a1[0], equalTo("c"));
    assertArrayEquals(a1, a2);
  }
}
