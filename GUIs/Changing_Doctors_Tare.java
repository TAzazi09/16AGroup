package GUIs;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Tare
 * @fixed by Nikola (file was broken)
 */
public class Appointment {

    private int duration;
    private SimpleDateFormat form = new SimpleDateFormat("DD/MM/YY");
    private Date date;
    private Date end;
    private String name;
    private String place;

    /**
     * Constructor for objects of class Appointment.
     */
    public Appointment(String dateStr, int duration) {
        // initialise instance variables
        date = new Date();
        end = new Date();
        try {
            date = form.parse(dateStr);
        } catch (Exception e) {
            System.out.println();
        }
        this.duration = duration;
        endSlotCal(date);
        name = "";
        place = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    private void endSlotCal(Date dte) {
        long min = dte.getTime();
        end.setTime(min + (duration * 60 * 1000));
        //System.out.println(end);
    }

    public Date getDat() {
        return date;
    }

    public Date getEnd() {
        return end;
    }

    /**
     * @return it returns time and duration of slot. 
     */
    public String toString() {
        String str = "";
        str = str + form.format(date) + " - " + duration;
        return str;
    }
}
