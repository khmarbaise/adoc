package com.soebes.adoc.day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * <a href="https://adventofcode.com/2023/day/1">https://adventofcode.com/2023/day/1</a>
 */
class Day01 {

  private static final Pattern SEPARATE_INTO_CHARACTERS = Pattern.compile(".*?");

  static List<CalibrationValue> extractCalibrationValuesFromFile(Path file) throws IOException {
    try (Stream<String> lines = Files.lines(file)) {
      return lines.map(line -> {
            var listOfDigits = SEPARATE_INTO_CHARACTERS
                .splitAsStream(line)
                .filter(c -> Character.isDigit(c.codePointAt(0)))
                .toList();
            return new CalibrationValue(Integer.parseInt(listOfDigits.getFirst() + listOfDigits.getLast()));
          }
      ).toList();
    }
  }

  static int calculateTheTotalSumOfCalibrationValues(List<CalibrationValue> calibrationValues) {
    return calibrationValues.stream().mapToInt(Day01.CalibrationValue::value).sum();
  }

  record CalibrationValue(int value) {
  }
}