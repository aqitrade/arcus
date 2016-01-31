package com.aqitrade.arcus.core.util;

import java.util.Random;

public final class CoreUtils {

  private CoreUtils() {}

  public static Long generateSecurityCode() {
    Random r = new Random(System.currentTimeMillis());
    return (long) ((1 + r.nextInt(8)) * 10000 + r.nextInt(10000));
  }
}
