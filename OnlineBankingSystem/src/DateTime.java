import java.time.LocalDate;
import java.time.LocalTime;

public class DateTime {
	public static LocalDate generateDate()
	{
		LocalDate dt = LocalDate.now();
		return dt;
	}
	public static LocalTime generateTime()
	{
		LocalTime t = LocalTime.now();
		return t;
	}
}
