-- mysql
SELECT ID
     , NAME
     , HOST_ID
FROM (
        SELECT ID
             , NAME
             , COUNT(*) OVER (PARTITION BY HOST_ID) AS CNT
             , HOST_ID
        FROM PLACES
    ) AS P
WHERE CNT >= 2
ORDER BY 1
