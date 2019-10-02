SELECT COUNT(*) cnt, um.unsei_name FROM result res INNER JOIN omikuji omi ON res.omikuji_id = omi.omikuji_id
INNER JOIN UnseiMaster um ON omi.unsei_id = um.unsei_id
				WHERE res.uranai_date >= /*harfYearAgo*/
						AND res.uranai_date <= /*today*/
								GROUP BY um.unsei_name