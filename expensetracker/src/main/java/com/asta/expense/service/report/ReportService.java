package com.asta.expense.service.report;

import com.asta.expense.payload.dao.DailyReport;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<DailyReport> getReport(LocalDate fromDate,LocalDate toDate,int type);
}
