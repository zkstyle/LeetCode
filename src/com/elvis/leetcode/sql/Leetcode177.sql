/*
编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

limit m,n 是指　从第m条数据开始　选择n条数据
offset m 是指跳过前m条数据
 */

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT N, 1),NULL)
  );
END