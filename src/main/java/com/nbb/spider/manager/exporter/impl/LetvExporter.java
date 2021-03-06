package com.nbb.spider.manager.exporter.impl;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.nbb.spider.entity.Item;
import com.nbb.spider.entity.impl.Letv;
import com.nbb.spider.manager.exporter.AbstractExporter;
import com.nbb.spider.manager.exporter.Exporter;

public class LetvExporter extends AbstractExporter implements Exporter{

	public void export(Workbook wb, List<? extends Item> items, String sheetName)
			throws IOException {
		exportItemsToSheet(items, sheetName, wb);
	}

	protected void createHeaderExtra(Row row, CellStyle style) {
		Cell cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("actors");
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("director");
		cell = row.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("category");
	}

	protected void exportExtra(Row row, Item item) {
		Letv rank = (Letv) item;
		Cell cell = row.createCell(2);
		cell.setCellValue(rank.getActors());
		cell = row.createCell(3);
		cell.setCellValue(rank.getDirector());
		cell = row.createCell(4);
		cell.setCellValue(rank.getCategory());
	}

}
