package com.ecnu.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

//使用beanUtils操作bean的属性(第三方)
public class Demo1 {

	@Test
	public void test1() throws Exception {
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "5342523");
		System.out.println(p.getName());
	}

	@Test
	public void test2() throws Exception {
		String name = "452q34";
		String password = "5235432";
		String age = "32";

		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);

		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());

	}

	@Test
	public void test3() throws Exception {
		String name = "452q34";
		String password = "5235432";
		String age = "32";
		String birthday = "1980-09-09";

		// 注册一个日期转换器
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				// TODO Auto-generated method stub
				if (value == null) {
					return null;
				}
				if (!(value instanceof String)) {
					throw new ConversionException("只支持string类型的转换");
					// System.out.println("不转");
				}
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);// 异常链不能断
				}

			}

		}, Date.class);

		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);

		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday().toLocaleString());
	}
	
	@Test
	public void test4() throws Exception {
		String name = "452q34";
		String password = "5235432";
		String age = "32";
		String birthday = "1980-09-09";

		// apache已经帮我们写好了日期转换器可以拿来直接使用
		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);

		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday().toLocaleString());
	}
	
	@Test
	public void test5() throws IllegalAccessException, InvocationTargetException{
		Map map = new  HashMap();
		map.put("name", "rwer");
		map.put("password", "123");
		map.put("age", "23");
		map.put("birthday", "1980-09-09");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person bean = new Person();
		BeanUtils.populate(bean, map);//用map集合中的值填充bean的属性
		
		System.out.println(bean.getName());
		System.out.println(bean.getPassword());
		System.out.println(bean.getAge());
		System.out.println(bean.getBirthday().toLocaleString());
		
	}
}
