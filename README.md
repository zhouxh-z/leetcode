# leetcode 算法
## 二分法
二分法基本思路：
  1. 将数组**有序**排列后，设置 low = 0 和 high = 数组.length ；
  2. 通过 low 和 high 算出中位值【mid = low + (high - low)/2 】，为什么不通过（high+low）/2 得出mid【这样可以有效的防止数组越界异常】
  3. 然后判断中位数mid 和 需要比较数的大小，根据比较结果移动 low 或者 high 的下标位置
### 二分法图解
![image](https://user-images.githubusercontent.com/65749313/129858514-435cc839-033c-4ea1-8473-d49200485867.png)
