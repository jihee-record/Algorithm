--mysql
/**
3 >= 2 > 1 순서로 효율

1. 재귀 방식으로 구하는 데, 3세대까지 밖에 안하고 3세대만 구하는 거라서 굳이 필요하지 않음.
2. JOIN에 SUBQUERY를 써서 테이블 하나를 더 생성함 - 중간 결과를 따로 뺄 필요가 있나? 아니라서 불필요
3. 그냥 FLAT 하게 조인을 나열 함
*/
SELECT D3.ID
FROM ECOLI_DATA D1
JOIN ECOLI_DATA D2
ON D1.ID = D2.PARENT_ID
JOIN ECOLI_DATA D3
ON D2.ID = D3.PARENT_ID
WHERE D1.PARENT_ID IS NULL
ORDER BY D3.ID