package com.neo.apitest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    private JdbcTemplate template;

    public void testKhuVuc() {
        template.query("select stationid, EXTRACT(YEAR FROM dateandtime) AS dt_year, \n" +
                "EXTRACT(MONTH FROM dateandtime) AS dt_month,SUM(rainfall_0) AS rainfall\n" +
                "FROM rainfall_timeseriesrgs WHERE stationid = ?\n" +
                "GROUP BY stationid, dt_year, dt_month ORDER BY dt_year DESC, dt_month DESC", new String[]{"752767"}, resultSet -> {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        });
    }
}
