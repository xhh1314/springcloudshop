package com.shop.homepage.manager.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;



public class ExportExcelSeedBack {

	
    /**
     * sheet的名称
     */
    private final String title;
    
    /**
     *表头名称数组，第一类默认为序号列，传入的列名数组格式应该为 {"序号","订单号","***"} ，第一列须为序号
     */
    private final String[] rowName ;

    /**
     * 要导出的数据
     */
    private final List<Object[]>  dataList ;
    
    /**
     * excel文件名称
     */
    private final String fileName;
    
    
    private final HttpServletResponse  response;

   


    
    /**
     * @param title  sheet的名称
     * @param rowName 表头名称数组，第一类默认为序号列，传入的列名数组格式应该为 {"序号","订单号","***"} ，第一列须为序号
     * @param dataList 要导出的数据
     */
    public ExportExcelSeedBack(String fileName,String title,String[] rowName,List<Object[]> dataList,HttpServletResponse  response){
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
        this.fileName=fileName;
        this.response=response;
    }
    public void export() throws Exception{
        String headStr = "attachment; filename=\"" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) +".xls"+ "\"";
        response.setContentType("octets/stream");
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", headStr);
        OutputStream out=response.getOutputStream();
        excuteExport(out);
    }
    

    /*
     * 导出数据
     * */
    private void excuteExport(OutputStream out) throws Exception{
        try{
            HSSFWorkbook workbook = new HSSFWorkbook();                     // 创建工作簿对象
            HSSFSheet sheet = workbook.createSheet(title);                  // 创建工作表

            // 产生表格标题行
    //          HSSFRow rowm = sheet.createRow(0);
    //          HSSFCell cellTiltle = rowm.createCell(0);

            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象
            HSSFCellStyle style = this.getStyle(workbook);                  //单元格样式对象

    //          sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (rowName.length-1)));//合并单元格  
    //          cellTiltle.setCellStyle(columnTopStyle);
    //          cellTiltle.setCellValue(title);

            // 定义所需列数
            int columnNum = rowName.length;
            HSSFRow rowRowName = sheet.createRow(0);                // 在索引2的位置创建行(最顶端的行开始的第二行)

            // 将列头设置到sheet的单元格中
            for(int n=0;n<columnNum;n++){
                HSSFCell  cellRowName = rowRowName.createCell(n);               //创建列头对应个数的单元格
                //--cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                cellRowName.setCellType(CellType.STRING);
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);                                 //设置列头单元格的值
                cellRowName.setCellStyle(columnTopStyle);                       //设置列头单元格样式
            }

            //将查询出的数据设置到sheet对应的单元格中
            for(int i=0;i<dataList.size();i++){

                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(i+1);//创建所需的行数（从第二行开始写数据）

                for(int j=0; j<obj.length; j++){
                    HSSFCell  cell = null;   //设置单元格的数据类型
                    if(j == 0){
                        //--cell = row.createCell(j,HSSFCell.CELL_TYPE_NUMERIC);
                        cell = row.createCell(j, CellType.NUMERIC);
                        cell.setCellValue(i+1); 
                    }else{
                        cell = row.createCell(j,CellType.STRING);
                        if(!"".equals(obj[j]) && obj[j] != null){
                            cell.setCellValue(obj[j].toString());                       //设置单元格的值
                        }
                    }
                    cell.setCellStyle(style);                                   //设置单元格样式
                }
            }
            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
     //                 if (currentRow.getCell(colNum) != null) {
     //                     HSSFCell currentCell = currentRow.getCell(colNum);
    //                      if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
    //                          int length =     currentCell.getStringCellValue().getBytes().length;
    //                          if (columnWidth < length) {
    //                              columnWidth = length;
    //                          }
    //                      }
    //                  }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            int length = 0;
                            try {
                                length = currentCell.getStringCellValue().getBytes().length;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }

                }
                if(colNum == 0){
                    sheet.setColumnWidth(colNum, (columnWidth-2) * 256);
                }else{
                    sheet.setColumnWidth(colNum, (columnWidth+4) * 256);
                }
            }
            if(workbook !=null){
                try{
                    workbook.write(out);
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            out.close();
        }

    }

    /* 
     * 列头单元格样式
     */    
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

          // 设置字体
          HSSFFont font = workbook.createFont();
          //设置字体大小
          font.setFontHeightInPoints((short)11);
          //字体加粗
          //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
          font.setBold(true);
          //设置字体名字 
          font.setFontName("Courier New");
          //设置样式; 
          HSSFCellStyle style = workbook.createCellStyle();
          //设置底边框; 
         // style.setBorderBottom(HSSFCellStyle.BORDER_THIN);          
          style.setBorderBottom(BorderStyle.THIN);;          
          //设置底边框颜色;  
          style.setBottomBorderColor(HSSFColor.BLACK.index);;
          //设置左边框;   
          style.setBorderLeft(BorderStyle.THIN);
          //设置左边框颜色; 
          style.setLeftBorderColor(HSSFColor.BLACK.index);
          //设置右边框; 
          style.setBorderRight(BorderStyle.THIN);
          //设置右边框颜色; 
          style.setRightBorderColor(HSSFColor.BLACK.index);
          //设置顶边框; 
          style.setBorderTop(BorderStyle.THIN);
          //设置顶边框颜色;  
          style.setTopBorderColor(HSSFColor.BLACK.index);
          //在样式用应用设置的字体;  
          style.setFont(font);
          //设置自动换行; 
          style.setWrapText(false);
          //设置水平对齐的样式为居中对齐;  
          //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
          style.setAlignment(HorizontalAlignment.CENTER);
          //设置垂直对齐的样式为居中对齐; 
          style.setVerticalAlignment(VerticalAlignment.CENTER);

          return style;

    }

    /*  
     * 列数据信息单元格样式
     */  
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
          // 设置字体
          HSSFFont font = workbook.createFont();
          //设置字体大小
          //font.setFontHeightInPoints((short)10);
          //字体加粗
          //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
          //设置字体名字 
          font.setFontName("Courier New");
          //设置样式; 
          HSSFCellStyle style = workbook.createCellStyle();
          //设置底边框; 
          style.setBorderBottom(BorderStyle.THIN);
          //设置底边框颜色;  
          style.setBottomBorderColor(HSSFColor.BLACK.index);
          //设置左边框;   
          style.setBorderLeft(BorderStyle.THIN);
          //设置左边框颜色; 
          style.setLeftBorderColor(HSSFColor.BLACK.index);
          //设置右边框; 
          style.setBorderRight(BorderStyle.THIN);
          //设置右边框颜色; 
          style.setRightBorderColor(HSSFColor.BLACK.index);
          //设置顶边框; 
          style.setBorderTop(BorderStyle.THIN);
          //设置顶边框颜色;  
          style.setTopBorderColor(HSSFColor.BLACK.index);
          //在样式用应用设置的字体;  
          style.setFont(font);
          //设置自动换行; 
          style.setWrapText(false);
          //设置水平对齐的样式为居中对齐;  
          style.setAlignment(HorizontalAlignment.CENTER);
          //设置垂直对齐的样式为居中对齐; 
          style.setVerticalAlignment(VerticalAlignment.CENTER);
          return style;

          }
       }

