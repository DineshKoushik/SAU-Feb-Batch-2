package com.au.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean(name = "rectangleObj")
	public Rectangle getRectangle() {
		List<String> lst = new ArrayList<>();
		lst.add("Pink");
		lst.add("Red");
		lst.add("Yellow");
		return new Rectangle("Rectangle", lst, getPoint1(), getPoint2(), getPoint3(), getPoint4());
	}

	@Bean(name = "Point1")
	public Point getPoint1() {
		return new Point(0, 0);
	}

	@Bean(name = "Point2")
	public Point getPoint2() {
		return new Point(0, 20);
	}

	@Bean(name = "Point3")
	public Point getPoint3() {
		return new Point(30, 0);
	}

	@Bean(name = "Point4")
	public Point getPoint4() {
		return new Point(30, 20);
	}

}
