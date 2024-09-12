/*
 * Copyright (c) 2024 Gitar, Inc.
 */
package co.gitar;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
              
@RunWith(MockitoJUnitRunner.class)
public class SampleTest extends BaseTest {
  @BeforeClass
  public static void setup() {
    // ...
  }

  @Before
  public void reset() {
    // ...
  }

  @Test
  public void test1() {
    Assert.assertThat(asList("c", "a", "b"), containsInAnyOrder("a", "b", "c"));
  }

  @Test
  @Ignore
  public void test2() {
    String[] a1 = new String[] {"c", "a", "b"};
    String[] a2 = new String[3];
    a2[0] = "a";
    a2[1] = "b";
    a2[2] = "c";
    Assert.assertEquals(a1[0], "c");
    Assert.assertEquals(a1, a2);
  }
}
