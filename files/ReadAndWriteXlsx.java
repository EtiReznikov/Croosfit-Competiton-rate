package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import competitors.Amrap;
import competitors.Competitor;
import competitors.Fortime;
import competitors.Weight;
import linkedlists.AmrapLL;
import linkedlists.Amrap_repsLL;
import linkedlists.ForTimeForTimeLL;
import linkedlists.ForTimeLL;
import linkedlists.WeightLL;
import nodes.Node;
import nodes.NodeAmrap_reps;
import nodes.NodeFortime_time;
import rate.Rate;


public class ReadAndWriteXlsx {
	public static String FILENAME="C:\\Users\\etire\\OneDrive\\מסמכים\\ThrowDownTeens2019.xlsx";
	private final static int TOTALSCORECELL=18;
	public static int numofcompetitors=8;
	


		
	public static void readandrate (int eventnum) throws IOException {
	//	try {
		File excelFile = new File(FILENAME);
		FileInputStream fis = new FileInputStream(excelFile);

		// we create an XSSF Workbook object for our XLSX Excel File
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// we get first sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		//	Competitor [] competitors= new Competitor[sheet.getLastRowNum()-1];
		if (eventnum==1) {
			ForTimeForTimeLL competitors=new ForTimeForTimeLL();
			for (int i=3; i<numofcompetitors+3; i++) {
				Row row=sheet.getRow(i);
				Cell id=row.getCell(0);
				Cell reps=row.getCell(4);
				Cell time=row.getCell(5);
				Cell Tiebreaker_time=row.getCell(6);
				Date date=time.getDateCellValue();
				//System.out.println(date);
				Date dateTiebreaker=Tiebreaker_time.getDateCellValue();
			//	System.out.println(dateTiebreaker);
				String stringasdate=date.toString().substring(11, 16);
				String stringasdate_tiebreaker=dateTiebreaker.toString().substring(11, 16);
				competitors.add((new NodeFortime_time(new Fortime((int)id.getNumericCellValue(), 0,stringasdate,(int)reps.getNumericCellValue(),i), stringasdate_tiebreaker)));
			}
			workbook.close();
	        fis.close();
			writescore(Rate.FortimeFortimeRate(competitors), 7);
		}
		if (eventnum==2) {
			Amrap_repsLL competitors=new Amrap_repsLL();
			for (int i=3; i<numofcompetitors+3; i++) {
				Row row=sheet.getRow(i);
				Cell id=row.getCell(0);
				Cell reps=row.getCell(8);
				Cell tieBreaker=row.getCell(9);
				Cell totalrate=row.getCell(TOTALSCORECELL);
				competitors.add((new NodeAmrap_reps(new Amrap((int)id.getNumericCellValue(), (int)totalrate.getNumericCellValue(), (int)reps.getNumericCellValue(),i), (int)tieBreaker.getNumericCellValue())));
			}
			competitors.printList();
			workbook.close();
	        fis.close();
			writescore(Rate.AmrapRepsRate(competitors), 10);
		}
		if (eventnum==4) {
			numofcompetitors=3;
			WeightLL competitors1=new WeightLL();
			for (int i=3; i<numofcompetitors+3; i++) {
				Row row=sheet.getRow(i);
				Cell id=row.getCell(0);
				Cell wieght=row.getCell(14);
				Cell totalrate=row.getCell(TOTALSCORECELL);
				competitors1.add((new Node(new Weight((int)id.getNumericCellValue(), (int)totalrate.getNumericCellValue(), wieght.getNumericCellValue(), i))));
				
			}
			workbook.close();
	        fis.close();
			writescore(Rate.WieghtRate(competitors1), 15, 20);
		}
		if (eventnum==3) {
			numofcompetitors=5;
		//	 excelFile = new File(FILENAME);
			// fis = new FileInputStream(excelFile);

			// we create an XSSF Workbook object for our XLSX Excel File
			// workbook = new XSSFWorkbook(fis);
			// we get first sheet
		//	 sheet = workbook.getSheetAt(0);

		/*	Competitor [] score =Rate.WieghtRate(competitors1);
			for (int i=0; i<score.length; i++)
				System.out.println("id: "+score[i].getId()+" total rate: "+ score[i].getTotalrate());*/
			 AmrapLL competitors=new AmrapLL();
			for (int i=3; i<numofcompetitors+3; i++) {
				Row row=sheet.getRow(i);
				//	Cell name=row.getCell(0);
				Cell id=row.getCell(0);
		//		Cell reps=row.getCell(eventnum*3);
				Cell reps=row.getCell(16);
				Cell totalrate=row.getCell(TOTALSCORECELL);
				competitors.add((new Node(new Amrap((int)id.getNumericCellValue(), (int)totalrate.getNumericCellValue(), (int)reps.getNumericCellValue(), i))));
			}
			workbook.close();
	        fis.close();
			writescore(Rate.AmrapRate(competitors), 17, 19);
		}

		workbook.close();
        fis.close();	
		//}
		/*catch (Exception fException) {
			System.out.println("close your file");
		}*/
	}
	 
	public static void writescore(Competitor[] scores, int eventrateCell) throws IOException {
		File excel = new File(FILENAME);
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i=0; i<scores.length; i++) {
			Row row= sheet.getRow(scores[i].getRownum());
			row.getCell(eventrateCell).setCellValue(scores[i].getEventrate());
			row.getCell(TOTALSCORECELL).setCellValue(scores[i].getTotalrate());
		}

		fis.close();
		FileOutputStream output_file =new FileOutputStream(FILENAME);  
		workbook.write(output_file);
		workbook.close();
		output_file.close();

	//	System.out.println(" is successfully written");
	}
	public static void writescore(Competitor[] scores, int eventrateCell, int finalscore) throws IOException {
		File excel = new File(FILENAME);
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i=0; i<scores.length; i++) {
			Row row= sheet.getRow(scores[i].getRownum());
			row.getCell(eventrateCell).setCellValue(scores[i].getEventrate());
			row.getCell(TOTALSCORECELL).setCellValue(scores[i].getTotalrate());
			row.getCell(finalscore).setCellValue(scores[i].getTotalrate());
		}

		fis.close();
		FileOutputStream output_file =new FileOutputStream(FILENAME);  
		workbook.write(output_file);
		workbook.close();
		output_file.close();

	//	System.out.println(" is successfully written");
	}

}
