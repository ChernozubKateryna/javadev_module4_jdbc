SELECT 'YOUNGEST' as type, name, birthday
FROM worker
WHERE birthday IN(
    SELECT birthday
    FROM worker
    ORDER BY birthday DESC
    LIMIT 1
)

UNION

SELECT 'OLDEST' as type, name, birthday
FROM worker
WHERE birthday IN(
    SELECT birthday
    FROM worker
    ORDER BY birthday
    LIMIT 1
);