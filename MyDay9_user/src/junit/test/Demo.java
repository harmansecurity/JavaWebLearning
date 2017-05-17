package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String d = "1980-12-31";
		/*String d = "1980-12-32";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(d);
		System.out.println(date);*/
		//校验日期是否合法
		DateLocaleConverter dic = new DateLocaleConverter();
		dic.convert(d, "yyyy-MM-dd");
		
		
		
	}

}
