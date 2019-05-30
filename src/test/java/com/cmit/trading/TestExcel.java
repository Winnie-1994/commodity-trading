package com.cmit.trading;
/** 
* @author: wunt
* @date: 2019-04-27 
* @description:
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

public class TestExcel {

//	@Test
	public void test() {
		Calendar now = Calendar.getInstance();
		String head = now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1) + "月";
		System.out.println(head);
	}

	@Test
	public void test1() throws IOException {
		// 创建HSSFWorkbook对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建HSSFSheet对象
		HSSFSheet sheet = workbook.createSheet("换购登记表");
		// 创建HSSFRow对象
		HSSFRow row = sheet.createRow(0);
		// 创建HSSFCell对象
		HSSFCell cell = row.createCell(0);
		Calendar now = Calendar.getInstance();
		String head = now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1) + "月" + "换购商品登记表";
		// 设置单元格的值
		cell.setCellValue(head);

		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
		ArrayList<String> thead = new ArrayList<>();
		thead.add("序号");
		thead.add("员工工号");
		thead.add("姓名");
		thead.add("部门");
		thead.add("电话");
		thead.add("香港南园杏仁500g");
		thead.add("香港南园腰果454g");
		thead.add("香港南园碧根果500g");
		thead.add("美国综合坚果250g");
		thead.add("刀唛花生油5L");
		thead.add("金额");
		thead.add("确认签名");
		thead.add("领取签名");
		row = sheet.createRow(1);
		for (int i = 0; i < thead.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(thead.get(i));
		}
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 4, 4));

		DiningCal diningCal = new DiningCal();
		ArrayList<String> money = new ArrayList<>();
		money.add(diningCal.getValue1());
		money.add(diningCal.getValue2());
		money.add(diningCal.getValue3());
		money.add(diningCal.getValue4());
		money.add(diningCal.getValue5());
		row = sheet.createRow(2);
		for (int i = 0; i < money.size(); i++) {
			cell = row.createCell(i + 5);
			cell.setCellValue(money.get(i));
		}
		// 输出Excel文件
		FileOutputStream output;
		try {
			output = new FileOutputStream("c:\\workbook.xls");
			workbook.write(output);
			output.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
