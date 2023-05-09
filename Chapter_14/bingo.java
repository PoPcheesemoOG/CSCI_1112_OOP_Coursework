package practice;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class bingo extends Pane {

	private int hour;
	private int minute;
	private int second;
	private double w = 250, h = 250;
	private boolean secondHandVisible = true;
	private boolean minuteHandVisible = true;
	private boolean hourHandVisible = true;

	public bingo() {
		setCurrentTime();
		paintClock();
	}

	public bingo(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}

	public boolean getSecondHandVisible() {
		return this.secondHandVisible;
	}

	public boolean getMinuteHandVisible() {
		return this.minuteHandVisible;
	}

	public boolean getHourHandVisible() {
		return this.hourHandVisible;
	}

	public void setSecondHandVisible(boolean secondHandVisible) {
		this.secondHandVisible = secondHandVisible;
		paintClock();
	}

	public void setMinuteHandVisible(boolean minuteHandVisible) {
		this.minuteHandVisible = minuteHandVisible;
		paintClock();
	}

	public void setHourHandVisible(boolean hourHandVisible) {
		this.hourHandVisible = hourHandVisible;
		paintClock();
	}
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}

	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
		paintClock();
	}
	public void setH(double h) {
		this.h = h;
		paintClock();
	}

	public double getH() {
		return h;
	}

	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock(); 
	}

	protected void paintClock() {
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;

		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t12 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t9 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t6 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		Text t1 = new Text(centerX + 40, centerY - clockRadius + 25, "1");
		Text t10 = new Text(centerX - clockRadius + 18, centerY - 40, "10");
		Text t4 = new Text(centerX + clockRadius - 25, centerY + 50, "4");
		Text t7 = new Text(centerX - 43, centerY + clockRadius - 17, "7");
		Text t2 = new Text(centerX + 75, centerY - clockRadius + 55, "2");
		Text t11 = new Text(centerX - clockRadius + 50, centerY - 75, "11");
		Text t5 = new Text(centerX + clockRadius - 60, centerY + 83, "5");
		Text t8 = new Text(centerX - 80, centerY + clockRadius - 50, "8");

		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));

		
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.CRIMSON);
		
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));

		Line mLine = new Line(centerX, centerY, xMinute, minuteY); 
		mLine.setStroke(Color.BLUE);

		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));

		Line hLine = new Line(centerX, centerY, hourX, hourY); 
		hLine.setStroke(Color.GREEN);

		getChildren().clear();  
		getChildren().addAll(circle, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12); //sLine, mLine, hLine);

		if (secondHandVisible == true) {
			getChildren().add(sLine);
		}
		else {
			getChildren().remove(sLine);
		}

		if (minuteHandVisible == true) {
			getChildren().add(mLine);
		}

		if (hourHandVisible == true) {
			getChildren().add(hLine);
		}
	}
}