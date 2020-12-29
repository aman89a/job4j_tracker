package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int iRow = 0;
        int iCell = 0;
        for (int[] row : array) {
            for (int cell : row) {
                list.add(array[iRow][iCell]);
                iCell++;
            }
            iCell = 0;
            iRow++;
        }
        return list;
    }
}
