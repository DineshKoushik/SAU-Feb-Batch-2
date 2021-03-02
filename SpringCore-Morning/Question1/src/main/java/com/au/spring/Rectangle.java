package com.au.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Rectangle {
	private String type;
	
	private List<String> lst;

	int height, width;

	@Autowired
	@Qualifier("Point1")
	private Point p1;

	@Autowired
	@Qualifier("Point2")
	private Point p2;

	@Autowired
	@Qualifier("Point3")
	private Point p3;

	@Autowired
	@Qualifier("Point4")
	private Point p4;

	public Rectangle(String s, List<String> lst, Point p1, Point p2, Point p3, Point p4) {
		this.type = s;
		this.lst = lst;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}

	public Point getPoint1() {
		return p1;
	}

	public void setPoint1(Point p1) {
		this.p1 = p1;
	}

	public Point getPoint2() {
		return p2;
	}

	public void setPoint2(Point p2) {
		this.p2 = p2;
	}

	public Point getPoint3() {
		return p3;
	}

	public void setPoint3(Point p3) {
		this.p3 = p3;
	}

	public Point getPoint4() {
		return p4;
	}

	public void setPoint4(Point p4) {
		this.p4 = p4;
	}

	public int getHeight() {
		this.height = p2.getb() - p1.geta();
		return this.height;
	}

	public int getWidth() {
		this.width = p3.geta() - p1.geta();
		return this.width;
	}

	public String getType() {
		return type;
	}

	public void print() {
		System.out.println();
		System.out.println("  "+getType() + ":");
		System.out.println("  Point1 "+"["+getPoint1().geta()+", "+getPoint1().getb()+"]");
		System.out.println("  Point2 "+"["+getPoint2().geta()+", "+getPoint2().getb()+"]");
		System.out.println("  Point3 "+"["+getPoint3().geta()+", "+getPoint3().getb()+"]");
		System.out.println("  Point4 "+"["+getPoint4().geta()+", "+getPoint4().getb()+"]");
		System.out.println();
		System.out.println("  Height "+ getHeight());
		System.out.println("  Width "+ getWidth());
		System.out.println();
		System.out.println("  Printing List :");
		for(int i=0;i<this.lst.size();i++)
		{
			System.out.println("  "+lst.get(i));
		}
	}
}
