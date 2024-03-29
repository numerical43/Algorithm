SELECT A.INGREDIENT_TYPE, SUM(B.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF B
    RIGHT JOIN ICECREAM_INFO A
    ON A.FLAVOR = B.FLAVOR
GROUP BY A.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER