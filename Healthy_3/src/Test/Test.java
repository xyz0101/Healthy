package Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.inject.New;

import com.Healthy.dao.impl.UserDetailDAOImpl;
import com.util.Utils;
public class Test extends UserDetailDAOImpl{
		public static void main(String[] args) {
			Test test = new Test();
			String s = UUID.randomUUID().toString();
			DateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(da.format(new Date()));
			System.out.println(Utils.dateToTime(new Date()));
		}
}
