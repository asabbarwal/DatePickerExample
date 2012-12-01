package com.abhisheksabbarwal.datepickerexample;

import java.util.Calendar;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

public class MainActivity extends Activity {

	private TextView actualDate;
	private DatePicker datePicker;
	private Button changeDate;

	private int year, month, date;
	static final int DATE_DIALOG_ID = 999;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setCurrentDate();

		changeDate = (Button) findViewById(R.id.btnChangeDate);
		changeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);

			}
		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month,
					date);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			date = selectedDay;

			// set selected date into textview
			actualDate.setText(new StringBuilder().append(month + 1)
					.append("-").append(date).append("-").append(year)
					.append(" "));

			// set selected date into datepicker also
			datePicker.init(year, month, date, null);

		}
	};

	// Set current date on datePicker
	public void setCurrentDate() {

		actualDate = (TextView) findViewById(R.id.actual_date);

		datePicker = (DatePicker) findViewById(R.id.date_picker);

		final Calendar c = Calendar.getInstance();

		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		date = c.get(Calendar.DATE);

		actualDate.setText(new StringBuilder().append(month + 1).append("-")
				.append(date).append("-").append(year));

		datePicker.init(year, month, date, null);

	}

}
