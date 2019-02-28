package pers.husen.demo;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author 何明胜
 * @version 1.0
 * @since 2019年2月28日 下午10:08:06
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 6, 9, 0, 7, 6, 8, 4, 3, 2, 7, 8};
		mergeSort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(array));
	}

	public static void mergeSort(int[] array, int low, int high) {
		// 递归结束标识
		if (low >= high) {
			return;
		}
		int middle = (low + high) / 2;

		// 分别处理左边和右边
		mergeSort(array, low, middle);
		mergeSort(array, middle + 1, high);
		// 归并
		merge(array, low, middle, high);
	}

	public static void merge(int[] array, int low, int middle, int high) {
		// 用于存储归并后的临时变量
		int[] temp = new int[high - low + 1];
		// 记录第一个和第二个数组中需要遍历的下标
		int i = low;
		int j = middle + 1;
		int index = 0;
		// 遍历两个数组取出小的数字，放入临时数组中
		while (i <= middle && j <= high) {
			if (array[i] <= array[j]) {
				temp[index++] = array[i++];
			} else {
				temp[index++] = array[j++];
			}
		}
		// 处理多余数据
		while (i <= middle) {
			temp[index++] = array[i++];
		}
		while (j <= high) {
			temp[index++] = array[j++];
		}

		for (int k = 0; k < temp.length; k++) {
			array[k + low] = temp[k];
		}
	}
}
