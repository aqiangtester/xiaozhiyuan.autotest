package cn.com.digiwin.justsharecloud.commonfunctions;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import jxl.*;

public class ExcelDataProvider implements Iterator<Object[]> {
	private Workbook book = null;
	private WorkbookSettings workbookSettings = null;
	private Sheet sheet = null;
	private int rowNum = 0;// ������
	private int curRowNo = 0;// ��ǰ����
	private int columnNum = 0;// ������
	private String[] columnnName;// ����
	/*
	 * ��TestNG�У���@DataProvider��dataProvider="name"�����εķ�����ȡExcelʱ�����ô���Ĺ��췽����
	 * �˷�����õ�������ǰ���Ƶ���һ�У�ִ����� ת��TestNG�Լ��ķ�����ȥ��Ȼ�������ǵ��ô���ʵ�ֵ�hasNext()��next() ������
	 * �õ�һ����ݣ�Ȼ�󷵻ظ���@Test��dataProvider="name"�����εķ�������˷�������ݶ���Ϊֹ��
	 * 
	 * @param filename Excel�ļ���
	 * 
	 * @param casename������
	 */

	public ExcelDataProvider(String fileName, String caseName) {
		try {
			File directory = new File(".");
			String ss = "open.tianyaqiang.newexcel.";
			
			workbookSettings = new WorkbookSettings();
			workbookSettings.setEncoding("ISO-8859-1");
			
			book = Workbook.getWorkbook(new File(directory.getCanonicalPath() + "\\resources\\"
					+ ss.replaceAll("\\.", Matcher.quoteReplacement("\\")) + fileName + ".xls") , workbookSettings);
			
			
			
			this.sheet = book.getSheet(caseName);
			this.rowNum = sheet.getRows();

			Cell[] c = sheet.getRow(0);
			this.columnNum = c.length;
			columnnName = new String[c.length];
			for (int i = 0; i < c.length; i++) {
				columnnName[i] = c[i].getContents().toString();
			}
			this.curRowNo++;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (this.rowNum == 0 || this.curRowNo >= this.rowNum) {
			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else
			return true;
	}

	public Object[] next() {
		// TODO Auto-generated method stub
		Cell[] c = sheet.getRow(this.curRowNo);
		Map<String, String> s = new TreeMap<String, String>();
		for (int i = 0; i < this.columnNum; i++) {
			String temp = "";
			try {
				temp = c[i].getContents().toString();
			} catch (ArrayIndexOutOfBoundsException ex) {
				temp = "";
			}
			s.put(this.columnnName[i], temp);
		}

		Object r[] = new Object[1];
		r[0] = s;
		this.curRowNo++;
		return r;
	}

	public void remove() {
		throw new UnsupportedOperationException("remove unsupported.");
	}
}