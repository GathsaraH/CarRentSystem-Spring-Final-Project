package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.Custom;
import entity.Plane;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<Custom> getPilotID(Date date) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select pilot.pilotID from pilot\n" +
                "left join pilotHoliday on \n" +
                "pilot.pilotID = pilotHoliday.pilotID\n" +
                "left join booking on\n" +
                "pilot.pilotID = booking.pilotID\n" +
                "where day = ? or (bookingDate <= ? and arrived = 'not arrived')\n" +
                "group by pilotID;", date, date);

        ArrayList<Custom> recordList = new ArrayList<>();

        while (rst.next())
            recordList.add(new Custom(rst.getString(1)));

        return recordList;
    }

    @Override
    public ArrayList<Plane> getTailNumber(Date date, int passangers) throws SQLException, ClassNotFoundException {


        System.out.println(passangers);
        ResultSet rst = CrudUtil.executeQuery("select plane.tailNumber from plane \n" +
                "left join maintance on \n" +
                "plane.tailNumber = maintance.tailNumber \n" +
                "left join booking on plane.tailNumber = booking.tailNumber \n" +
                "where (finishedDate>=? && startDate<=?) or \n" +
                "(bookingDate <= ? and arrived = 'not arrived') or (seats<=?) \n" +
                "group by tailNumber", date,date,date,passangers);
        ArrayList<Plane> recordList = new ArrayList<>();

        while (rst.next())
            recordList.add(new Plane(rst.getString(1)));

        return recordList;
    }

    @Override
    public Custom updateFlyDetails(Date date, String tailNumber) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select booking.bookingID,pilotID,ticketPrice, advanceOrFull from payment \n" +
                "inner join booking on\n" +
                "booking.bookingID = payment.bookingID\n" +
                "where bookingDate = ? and tailNumber = ?", date, tailNumber);

        while (rst.next())
            return new Custom(rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4));

        return null;
    }

    @Override
    public ArrayList<Custom> getRouteWiseCount() throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select routePath, count(*) as trips from route inner join booking on\n" +
                "route.routeID = booking.routeID\n" +
                "group by route.routeID");

        ArrayList<Custom> recordList = new ArrayList<>();

        while (rst.next())
            recordList.add(new Custom(rst.getString(1),rst.getInt(2)));

        return recordList;
    }

    @Override
    public ArrayList<Custom> getProfitData(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select bookingDate,sum(paidPrice) as profit \n" +
                "from payment inner join booking \n" +
                "on payment.bookingID = booking.bookingID \n" +
                "where bookingDate like '"+id+"%'\n" +
                "group by bookingDate");

        ArrayList<Custom> recordList = new ArrayList<>();

        while (rst.next())
            recordList.add(new Custom(rst.getDate(1), rst.getDouble(2)));

        return recordList;
    }

    @Override
    public double getTodayProfit(Date date) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select sum(paidPrice) from payment " +
                "inner join booking on " +
                "payment.bookingID = booking.bookingID " +
                "where bookingDate = ?", date);

        while (rst.next())
            return rst.getDouble(1);

        return 0;
    }

    @Override
    public ArrayList<Custom> getDateWiseProfit() throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select bookingDate, sum(paidPrice) from payment " +
                "inner join booking on " +
                "booking.bookingID = payment.bookingID " +
                "group by bookingDate");

        ArrayList<Custom> recordList = new ArrayList<>();

        while (rst.next())
            recordList.add(new Custom(rst.getDate(1), rst.getDouble(2)));

        return recordList;
    }
}
