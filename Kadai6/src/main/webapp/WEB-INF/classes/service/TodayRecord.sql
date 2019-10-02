SELECT  um.unsei_name, A.cnt FROM UnseiMaster um LEFT OUTER JOIN
				(SELECT omi.unsei_id, count(*) cnt
				FROM omikuji omi
				INNER JOIN Result res ON omi.omikuji_id = res.omikuji_id
				WHERE res.uranai_date = ?
				GROUP BY omi.unsei_id
				ORDER BY omi.unsei_id ASC ) A ON um.unsei_id = A.unsei_id
