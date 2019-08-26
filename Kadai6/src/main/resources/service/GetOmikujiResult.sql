SELECT um.unsei_name, omi.gakumon, omi.negaigoto, omi.akinai, omi.unsei_id
FROM UnseiMaster um
INNER JOIN Omikuji omi ON um.unsei_id = omi.unsei_id
WHERE omi.omikuji_id = /*omikuji_id*/