SELECT um.unsei_name, omi.gakumon, omi.negaigoto, omi.akinai, res.uranai_date FROM UnseiMaster um
				INNER JOIN Omikuji omi ON um.unsei_id = omi.unsei_id
				INNER JOIN result res ON omi.omikuji_id =res.omikuji_id
				 WHERE res.uranai_date >= /*harfYearAgo*/
				 AND res.uranai_date <= /*today*/
				 AND res.birthday = /*birthday*/