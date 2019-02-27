package pers.husen.demo;

import java.util.Arrays;

/**
 * 希尔排序,带步长的插入排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月27日 下午8:43:09
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 6, 9, 0, 7, 6, 8, 4, 3, 2, 7, 8};
		shellSort(array);

		System.out.println(Arrays.toString(array));
	}

	public static void shellSort(int[] array) {
		// 遍历所有步长
		for (int d = array.length / 2; d > 0; d /= 2) {
			// 遍历所有元素
			for (int i = d; i < array.length; i++) {
				if (array[i] >= array[i - d]) {
					continue;
				}

				int j;
				int temp = array[i];
				// 遍历本组所有元素
				for (j = i - d; j >= 0; j -= d) {
					if (array[j] <= temp) {
						break;
					}

					array[j + d] = array[j];
				}

				// 插入temp
				array[j + d] = temp;
			}
		}
	}
}
