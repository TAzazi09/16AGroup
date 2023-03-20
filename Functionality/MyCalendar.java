package Functionality;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Tare
 * @fixed by Nik (file was broken)
 */
public class MyCalendar {

    private String name;

    ArrayList<Appointment> appoint;
    int slt;

    /**
     * Constructor for objects of class MyCalendar.
     */
    public MyCalendar(String name) {
        // initialise instance variables
        this.name = name;
        slt = 0;
    }

    public boolean createAppointmentSlot(Appointment slot) {
        int flag = 0;
        if (slt == 0) {
            appoint = new ArrayList<Appointment>();
            appoint.add(slot);
            slt++;
            return true;
        } else {
            for (int cnt = 0; cnt < appoint.size(); cnt++) {
                if ((appoint.get(cnt).getEnd()).compareTo(slot.getDat()) < 0) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                appoint.add(slot);
                return true;
            }
        }
        return false;
    }

    /**
     * @param name name of the person who wants to ask appointment.
     * @param place the place where to meet.
     * @param date appointment date.
     * @param dur how much time if they needs.
     * @return true if a slot is booked to particular person
     */
    public boolean bookAppointment(String name, String date, int dur, String place) {
        int flag = 0;
        Date date1 = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy");
        try {
            date1 = form.parse(date);
        } catch (Exception e) {
            System.out.println();
        }
        int temp = 0;
        for (int cnt = 0; cnt < appoint.size(); cnt++) {
            if (date1.equals(appoint.get(cnt).getDat())) {
                //System.out.print("true");
                temp = cnt;
                flag = 1;
            }
        }
        if (flag == 1) {
            if (appoint.get(temp).getName().equals("")) {
                appoint.get(temp).setName(name);
                appoint.get(temp).setPlace(place);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     *  date takes the date to cancel appointment.
     *  true if the appointment of particular date is cancel.
     */
    public boolean cancelAppointment(String date) {
        Date date1 = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy");
        try {
            date1 = form.parse(date);
        } catch (Exception e) {
            System.out.println();
        }
        for (int cnt = 0; cnt < appoint.size(); cnt++) {
            if (date1.equals(appoint.get(cnt).getDat())) {
                appoint.get(cnt).setName("");
                appoint.get(cnt).setPlace("");
                return true;
            }
        }
        return false;
    }
}