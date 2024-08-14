package org.arthur;

import io.javalin.Javalin;

public class Arthur {
  public static void main(String[] args) {
    var app = Javalin.create().get("/", ctx -> ctx.result("Hello World")).start();
  }
}
