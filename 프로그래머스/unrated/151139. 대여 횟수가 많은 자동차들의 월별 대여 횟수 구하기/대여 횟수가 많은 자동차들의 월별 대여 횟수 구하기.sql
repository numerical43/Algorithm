SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(START_DATE) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE (CAR_ID) 
    IN (SELECT CAR_ID 
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
        GROUP BY CAR_ID
        HAVING COUNT(CAR_ID) >= 5)
        AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY CAR_ID, MONTH(START_DATE)
HAVING COUNT(START_DATE) > 0
ORDER BY MONTH(START_DATE) ASC, CAR_ID DESC