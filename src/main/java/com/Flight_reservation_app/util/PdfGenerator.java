package com.Flight_reservation_app.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.Flight_reservation_app.entities.Reservation;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	public void generateItinerary(String filePath, Reservation reservation) {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();

			Paragraph p = new Paragraph();

			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			document.add(Chunk.NEWLINE);

			document.add(generateTable(reservation));

			document.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {

		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("flight Itinerary"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlights().getFlightNumber());
		
		table.addCell("Operating Airlines");
		table.addCell(reservation.getFlights().getOperatingAirlines());
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlights().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlights().getArrivalCity());
		
		table.addCell("Date Of Departure ");
		table.addCell(reservation.getFlights().getDateOfDeparture().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Middle Name");
		table.addCell(reservation.getPassenger().getMiddleName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}
}
