package com.cmit.trading.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmit.trading.dao.DiningCal;
import com.cmit.trading.dao.DiningList;
import com.cmit.trading.dao.DiningUser;
import com.cmit.trading.domain.DiningTradeDao;


/** 
* @author: wunt
* @date: 2019-04-15 
* @description:
*/
@Service
public class DiningTradeService {

	@Autowired
	DiningTradeDao diningTradeDao;
	
	public void saveList(DiningUser diningUser, DiningList diningList) {
		diningTradeDao.saveList(diningUser, diningList);
	}
	
	public Map<Object, Object> getList(String num) {
		Map<Object, Object> list = diningTradeDao.getList(num);
		System.out.println(list.toString());
		return list;
	}
	
	public Map<String, Map<Object, Object>> getAllList() {
		Map<String, Map<Object, Object>> allList = diningTradeDao.getAllList();
		System.out.println(allList.toString());
		return allList;
	}
	
	public void downloadExcel() throws IOException {
		//创建HSSFWorkbook对象  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//创建HSSFSheet对象  
		HSSFSheet sheet = workbook.createSheet("换购登记表");  
		//创建HSSFRow对象  
		HSSFRow row = sheet.createRow(0);  
		//创建HSSFCell对象  
		HSSFCell cell=row.createCell(0);  
		
		HSSFCellStyle cellStyle1 = workbook.createCellStyle();//创建单元格样式对象
		setBorderStyle(cellStyle1, BorderStyle.THIN);
		cellStyle1.setFont(setFontStyle(workbook, "宋体", (short) 26));
		cellStyle1.setAlignment(HorizontalAlignment.CENTER);
		
		HSSFCellStyle cellStyle2 = workbook.createCellStyle();//创建单元格样式对象
		setBorderStyle(cellStyle2, BorderStyle.THIN);
		cellStyle2.setFont(setFontStyle(workbook, "宋体", (short) 12));
		cellStyle2.setAlignment(HorizontalAlignment.CENTER);
		
		HSSFCellStyle cellStyle3 = workbook.createCellStyle();//创建单元格样式对象
		setBorderStyle(cellStyle3, BorderStyle.THIN);
		cellStyle3.setFont(setFontStyle(workbook, "宋体", (short) 10));
		cellStyle3.setAlignment(HorizontalAlignment.CENTER);
		  
		
		Calendar now = Calendar.getInstance();
		String head = now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH)+1) + "月" + "换购商品登记表";
		//设置单元格的值  
		cell.setCellValue(head);
		cell.setCellStyle(cellStyle1);

		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,12)); 
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
		for(int i = 0; i < thead.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(thead.get(i));
			cell.setCellStyle(cellStyle2);
		}
		sheet.addMergedRegion(new CellRangeAddress(1,2,0,0)); 
		sheet.addMergedRegion(new CellRangeAddress(1,2,1,1));
		sheet.addMergedRegion(new CellRangeAddress(1,2,2,2));
		sheet.addMergedRegion(new CellRangeAddress(1,2,3,3));
		sheet.addMergedRegion(new CellRangeAddress(1,2,4,4));
		cell.setCellStyle(cellStyle3);
		
		ArrayList<String> money = new ArrayList<>();
		DiningCal diningCal = new DiningCal();
		money.add(diningCal.getValue1());
		money.add(diningCal.getValue2());
		money.add(diningCal.getValue3());
		money.add(diningCal.getValue4());
		money.add(diningCal.getValue5());
		row = sheet.createRow(2);
		for(int i = 0; i < money.size(); i++) {
			cell = row.createCell(i+5);
			cell.setCellValue(money.get(i));
			cell.setCellStyle(cellStyle3);
		}

		Set<Object> numList = diningTradeDao.getNumList();
		
		int i = 0;
		for(Object str : numList) {
			row = sheet.createRow(i+3);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			Map<Object, Object> list = diningTradeDao.getList((String)str);
			DiningUser user = (DiningUser) list.get("用户信息");
			DiningList alist = (DiningList) list.get("换购数量");
			String cal = (String) list.get("换购总价");
			ArrayList<String> arrayList = new ArrayList<>();
			arrayList.add(user.getNumber());
			arrayList.add(user.getName());
			arrayList.add(user.getDepartment());
			arrayList.add(user.getPhone());
			arrayList.add(alist.getGood1());
			arrayList.add(alist.getGood2());
			arrayList.add(alist.getGood3());
			arrayList.add(alist.getGood4());
			arrayList.add(alist.getGood5());
			arrayList.add(cal);
			for(int j = 0; j < arrayList.size(); j++) {
				cell = row.createCell(j+1);
				cell.setCellValue(arrayList.get(j));
				cell.setCellStyle(cellStyle3);
			}
			i++;
		}
		
		for (i = 0; i < 13; i++) {
            sheet.autoSizeColumn(i);
        }
		
		
		//输出Excel文件  
		FileOutputStream output = null;
		String path = "c:\\" + now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH)+1) + "月" + "换购商品登记表" + "-管理信息系统部" + ".xls";
		try {
			output = new FileOutputStream(path);
			workbook.write(output);
			output.flush(); 
			System.out.println("导出成功!");
		} catch (FileNotFoundException e) {
            System.out.println("导出失败!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("导出失败!");
        }
		
	}
	

    /**
     * 设置字体样式
     * @param workbook 工作簿
     * @param name 字体类型
     * @param height 字体大小
     * @return HSSFFont
     */
    private static HSSFFont setFontStyle(HSSFWorkbook workbook, String name, short height) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints(height);
        font.setFontName(name);
        return font;
    }

    /**
     * 设置单元格样式
     * @param workbook 工作簿
     * @param border border样式
     */
    private static void setBorderStyle(HSSFCellStyle cellStyle, BorderStyle border) {
        cellStyle.setBorderBottom(border); // 下边框
        cellStyle.setBorderLeft(border);// 左边框
        cellStyle.setBorderTop(border);// 上边框
        cellStyle.setBorderRight(border);// 右边框
    }
}
