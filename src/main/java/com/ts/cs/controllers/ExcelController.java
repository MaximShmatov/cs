package com.ts.cs.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Excel file controller", description = "A controller for working with Excel files")
@Validated
public class ExcelController {

    @PostMapping("/findNthMax")
    @Operation(summary = "Find the nth maximum number in the file", description = "Accepts the file path and the number N, returns the nth maximum number")
    public ResponseEntity<Integer> findNthMax(@RequestParam @NotBlank String fileName, @RequestParam @Min(1) int nMax) {
        var numberList = readSheet(fileName);
        if (numberList.size() < nMax) {
            return ResponseEntity.badRequest().body(null);
        }
        var nMaxNumbers = numberList.subList(0, nMax);
        var restNumbers = numberList.subList(nMax,  numberList.size());
        restNumbers.forEach((number) -> replaceMin(nMaxNumbers, number));
        return ResponseEntity.ok(Collections.min(nMaxNumbers));
    }

    private void replaceMin(List<Integer> maxNumbers, int number) {
        int minValue = Collections.min(maxNumbers);
        int minIndex = maxNumbers.indexOf(minValue);
        if (number > minValue) {
            maxNumbers.set(minIndex, number);
        }
    }

    private List<Integer> readSheet(String fileName) {
        var numbers = new ArrayList<Integer>();
        try (var fis = Files.newInputStream(Path.of(fileName)); var workbook = new XSSFWorkbook(fis)) {
            for (Row row : workbook.getSheetAt(0)) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        numbers.add((int) cell.getNumericCellValue());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }

}