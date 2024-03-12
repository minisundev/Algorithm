SELECT p.PRODUCT_CODE, SUM(p.PRICE*o.SALES_AMOUNT) as SALES
FROM PRODUCT as p JOIN OFFLINE_SALE as o
ON p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY p.PRODUCT_CODE
ORDER BY 2 desc, 1 asc;