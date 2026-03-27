--mysql
/**
3 >= 2 > 1 순서로 효율

1. 재귀 방식으로 구하는 데, 3세대까지 밖에 안하고 3세대만 구하는 거라서 굳이 필요하지 않음.
2. JOIN에 SUBQUERY를 써서 테이블 하나를 더 생성함 - 중간 결과를 따로 뺄 필요가 있나? 아니라서 불필요
3. 그냥 FLAT 하게 조인을 나열 함
*/
WITH RECURSIVE ECOLI_GENERATION AS (
    SELECT 
        ID,
        1 AS GENERATION
    FROM ECOLI_DATA 
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT 
        D.ID,
        G.GENERATION + 1 AS GENERATION
    FROM ECOLI_DATA D
    JOIN ECOLI_GENERATION G
    ON D.PARENT_ID = G.ID
    WHERE G.GENERATION < 3
)

SELECT ID
FROM ECOLI_GENERATION
WHERE GENERATION = 3
ORDER BY ID
