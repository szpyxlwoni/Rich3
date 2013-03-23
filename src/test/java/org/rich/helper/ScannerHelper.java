package org.rich.helper;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ScannerHelper {
    public static Scanner createScannerForTest(String testCase) {
        return new Scanner(new ByteArrayInputStream(testCase.getBytes()));
    }
}
