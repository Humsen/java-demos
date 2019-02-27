package pers.husen.demo;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月27日 下午8:04:32
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 6, 9, 0, 7, 6, 8, 4, 3, 2, 7, 8};
		insertSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void insertSort(int[] array) {
		// 遍历所有
		for (int i = 1; i < array.length; i++) {
			if (array[i] >= array[i - 1]) {
				continue;
			}

			int j;
			int temp = array[i];
			for (j = i - 1; j >= 0; j--) {
				if (array[j] <= temp) {
					break;
				}

				array[j + 1] = array[j];
			}
			// 插入temp
			array[j + 1] = temp;
		}
	}
}
