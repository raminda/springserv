/**
 * 
 */
package com.millenniumit.mx.utils.excelexporter;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author kalpag
 * 
 */
public class ExcelExporter {

	private WritableWorkbook workbook = null;

	public ExcelExporter(File file) throws Exception {

		if (this.workbook != null) {
			throw new Exception("Workbook already created using outputstream");
		}
		this.workbook = Workbook.createWorkbook(file);
	}

	/**
	 * 
	 * @param outputStream
	 * @throws Exception
	 */
	public ExcelExporter(OutputStream outputStream) throws Exception {
		if (this.workbook != null) {
			throw new Exception("Workbook already created using filestream");
		}

		this.workbook = Workbook.createWorkbook(outputStream);
	}

	/**
	 * 
	 * @throws WriteException
	 * @throws IOException
	 */
	public void export() throws WriteException, IOException {

		workbook.write();
		workbook.close();
	}

	/**
	 * 
	 * @param sheetName
	 * @param sheetIndex
	 * @param valuesList
	 * @throws Exception
	 */
	public void createExcelSheet(String sheetName, int sheetIndex,
			List<Map<String, Object>> valuesList) throws Exception {

		if (this.workbook == null) {

			throw new Exception("workbook is not created");
		}

		WritableSheet workSheet = null;

		if ((workSheet = workbook.getSheet(sheetName)) == null) {
			workSheet = workbook.createSheet(sheetName, sheetIndex);
		}

		SheetSettings sh = workSheet.getSettings();
		sh.setDefaultColumnWidth(35);
		// Creating Writable font to be used in the report

		WritableFont normalFont = new WritableFont(WritableFont.createFont("ARIAL"),
				WritableFont.DEFAULT_POINT_SIZE, WritableFont.NO_BOLD, false,
				UnderlineStyle.NO_UNDERLINE);

		WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
		normalFormat.setWrap(true);
		normalFormat.setAlignment(jxl.format.Alignment.CENTRE);
		normalFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		normalFormat.setWrap(true);

		WritableFont headerFont = new WritableFont(WritableFont.createFont("ARIAL"),
				WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE);

		WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
		headerFormat.setWrap(true);
		headerFormat.setAlignment(jxl.format.Alignment.CENTRE);
		headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);

		Map<String, Object> valueMap = valuesList.get(0);

		String[] colNames = valueMap.keySet().toArray(new String[valueMap.keySet().size()]);

		for (int i = 0; i < colNames.length; i++) {
			Label cLabel = new Label(i, 0, colNames[i], headerFormat);
			workSheet.addCell(cLabel);
		}

		int rowCount = 1;

		for (Map<String, Object> map : valuesList) {

			for (int i = 0; i < colNames.length; i++) {

				Object value = map.get(colNames[i]);
				Label vLabel = new Label(i, rowCount, String.valueOf(value), normalFormat);
     			workSheet.addCell(vLabel);
			}
    		rowCount++;
		}
	}
}
