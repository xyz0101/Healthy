package Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.inject.New;

import com.Healthy.dao.impl.UserDetailDAOImpl;
import com.Healthy.model.Page;
import com.util.GetSQL;
import com.util.Utils;
public class Test extends UserDetailDAOImpl{
		public static void main(String[] args) {
			Timestamp tm = new Timestamp(2017-1900, 5+1, 23, 12, 24, 0, 0);
			System.out.println(tm);
			DateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str="['222']";
			System.out.println("-------------------------");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tm));
			System.out.println(str.substring(1,str.length()-1));
			Test test = new Test();
			String s = UUID.randomUUID().toString();
			
			System.out.println(da.format(new Date()));
			System.out.println(Utils.dateToTime(new Date()));
		System.out.println("-----------------");
		Page p = new Page("stadium_main", "2", "2", "stadium_id","project_id","Ω°…Ì");
		System.out.println(GetSQL.getSQLwithWhere(p));
		}
}
