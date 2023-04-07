Patient-Doctor Appointment Booking System
=========================================

This is a standalone Java application for patients to book appointments with their doctors. The application includes a JFrame user interface and interacts with a working database to store and retrieve relevant entities such as doctors, patients, bookings, and messages.

Requirements
------------

-   Authentication: The system allows a user to log in with their username and password and log out. When the user logs in, the system shows the user's messages on the welcome screen.
-   Authorisation checks: The system logs all access from a user, i.e. who accessed what functionality and when.
-   Registration: The system allows a new user to register as a patient, choose a doctor from the list of all doctors, and sends confirmation messages to the patient and the doctor.
-   Doctor change: The system allows a patient to change their doctor using the list of all doctors and sends confirmation messages to the patient and the doctor.
-   Booking: The system allows a patient to arrange a booking with their doctor by entering the date and time. If the doctor is not available for the chosen date and time, the system warns the patient. Otherwise, the system sends confirmation messages to the patient and the doctor.
-   View bookings: The system allows a patient to view their bookings by entering a month and year.
-   Reschedule booking: The system allows a patient to reschedule a booking with their doctor by entering the date and time. If the doctor is not available for the chosen date and time, the system warns the patient. Otherwise, the system sends confirmation messages to the patient and the doctor.
-   Visit details: The system allows a patient to view the visit details regarding a past booking for which the doctor provided visit details and prescriptions.
-   Doctor details: The system allows a patient to view all doctors with their summary information, e.g., name, phone number, and background, along with the doctor's availability for bookings in a given month and year.

Features
--------

-   User authentication and authorisation
-   Patient registration and doctor selection
-   Booking creation and rescheduling
-   View bookings and visit details
-   Doctor details and availability
-   Database integration

Usage
-----

To run the application, you need to import the project into a standard IDE such as Eclipse and run the GUIs.GeneralPage main class. Once the application starts, you can register as a new patient and then log in with your username and password.

To create a booking, select your doctor, enter the date and time, and click the "Book" button. If the booking is successful, you will receive a confirmation message, and the booking will appear on your bookings list.

To reschedule a booking, select the booking you want to change, enter the new date and time, and click the "Reschedule" button. If the rescheduling is successful, you will receive a confirmation message, and the booking details will update accordingly.

To view your bookings, enter the month and year you want to see and click the "View Bookings" button. Your bookings for the selected month and year will appear on the screen.

To view visit details for a past booking, select the booking from your bookings list, and the visit details will appear on the screen.

To view doctor details and availability, click the "Doctors" button, and a list of all doctors will appear on the screen. Select a doctor to see their details and availability for the selected month and year.

To change your doctor, click on the "Select a doctor" dropdown and then on your doctor of choice.

Testing
-------

We have included JUnit test classes and results, along with a brief two-page test specifications document explaining what tests are performed for each class/method.

Organisation
------------

We have included a brief one-page group organisation plan describing who does what (e.g., leads for each feature, DB design, and tests)