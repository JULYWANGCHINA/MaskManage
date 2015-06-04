package me.quantumti.web.controller.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import me.quantumti.domain.mask.Brand;
import me.quantumti.domain.mask.MaskDetail;
import me.quantumti.service.mask.BrandService;
import me.quantumti.service.mask.MaskDetailService;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class MaskController {
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private MaskDetailService maskDetailService;
	

	@RequestMapping(value="importExcel")
	public void importExcel(Model model) {
		InputStream is;
		try {
			is = new FileInputStream("/Users/july/Desktop/test.xlsx");
			XSSFWorkbook xwb = new XSSFWorkbook(is);
			// 循环工作表Sheet
			
			
			for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
				XSSFSheet xSheet = xwb.getSheetAt(numSheet);
				if (xSheet == null) {
					continue;
				}
				
				int timeCellNum = 0;
				int nameCellNum = 0;
				int effectCellNum = 0;
				int barCodeCellNum = 0;
				int addressCellNum = 0;
				
				Brand brand = new Brand(xSheet.getSheetName().toUpperCase().trim());
				brandService.add(brand);
				
				if(brand.getId()==249){
					System.out.println("debug");
				}
				// 循环行Row
                for (int rowNum = 0; rowNum <= xSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xRow = xSheet.getRow(rowNum);
                    if (xRow == null) {
                        continue;
                    }
                    // 每一行的值
                    // 列数
                    int column = xRow.getLastCellNum();
                    // 循环列Cell
                    MaskDetail maskDetail = new MaskDetail();
                    maskDetail.setBrand(brand);
                    for (int cellNum = 0; cellNum < column; cellNum++) {
                        XSSFCell xCell = xRow.getCell(cellNum);
                        if (xCell != null && !"".equals(xCell)) {
                        	String value = "";
	                   		 if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
	                   			 value = String.valueOf(xCell.getNumericCellValue()).trim();
	                   		 }else if (xCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
	                   			 value = xCell.getStringCellValue().trim();
	                   		 }
                        	if(rowNum==0){
                        		if(value.indexOf("分钟")!=-1||value.indexOf("时间")!=-1){
                        			timeCellNum = cellNum;
                        		}else if(value.indexOf("名称")!=-1){
                        			nameCellNum = cellNum;
                        		}else if(value.indexOf("功效")!=-1){
                        			effectCellNum = cellNum;
                        		}else if(value.indexOf("条码")!=-1){
                        			barCodeCellNum = cellNum;
                        		}else if(value.indexOf("图片")!=-1){
                        			addressCellNum = cellNum;
                        		}
                        	}else{
                        		
                        		if(timeCellNum!=0 && timeCellNum == cellNum){ //时间属性
                        			value = value.replaceAll("分钟", "").replaceAll("约", "");
                        			if(value.indexOf("-")!=-1){
                        				String[] valueArray = value.split("-");
                        				maskDetail.setMaskMin(valueArray[0]);
                        				maskDetail.setMaskMax(valueArray[1]);
                        			}else{
                        				maskDetail.setMaskTime(value);
                        			}
                        		}else if(nameCellNum!=0 && nameCellNum == cellNum){
                        			maskDetail.setMaskName(value);
                        		}else if(effectCellNum!=0 && effectCellNum == cellNum){
                        			value = value.replaceAll("\\，",",").replaceAll(".0", "").replaceAll("\\.", ",");
                        			maskDetail.setEffect(value);
                        		}else if(barCodeCellNum!=0 && barCodeCellNum == cellNum){
                        			maskDetail.setBarCode(value);
                        		}else if(addressCellNum!=0 && addressCellNum == cellNum){
                        			maskDetail.setAddress(value);
                        		}
                        	}
                        }
                    }
                    if(StringUtils.isNotEmpty(maskDetail.getMaskName()))
                    	maskDetailService.add(maskDetail);
                }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
