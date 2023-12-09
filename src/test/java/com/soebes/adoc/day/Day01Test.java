package com.soebes.adoc.day;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

  static final Path DATA_FILE = Path.of("src/test/resources/com/soebes/adoc/day/example.txt");

  @Test
  void extractCalibrationValuesFromFile() throws IOException {
    var calibrationValues = Day01.extractCalibrationValuesFromFile(DATA_FILE);
    assertThat(calibrationValues).containsExactly(
        new Day01.CalibrationValue(12),
        new Day01.CalibrationValue(38),
        new Day01.CalibrationValue(15),
        new Day01.CalibrationValue(77)
    );
    var totalSum = calibrationValues.stream().mapToInt(Day01.CalibrationValue::value).sum();
  }

  @Test
  void calculateTheTotalSumOfCalibrationValues() throws IOException {
    var calibrationValues = Day01.extractCalibrationValuesFromFile(DATA_FILE);
    var totalSum = Day01.calculateTheTotalSumOfCalibrationValues(calibrationValues);
    assertThat(totalSum).isEqualTo(142);
  }
}