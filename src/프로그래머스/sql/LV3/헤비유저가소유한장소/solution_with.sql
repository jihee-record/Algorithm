-- mysql
WITH P AS (
    SELECT ID
         , NAME
         , COUNT(*) OVER (PARTITION BY HOST_ID) AS CNT
         , HOST_ID
    FROM PLACES
) 

SELECT ID
     , NAME
     , HOST_ID
FROM P
WHERE CNT >= 2
ORDER BY 1