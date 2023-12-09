package com.soebes.adoc2023.day01;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;

/**
 * https://adventofcode.com/2023/day/1
 */
class StepTest {
  @Test
  void name() {
    Files.lines(Path.of("example.txt")).forEach(System.out::println);
  }
}
