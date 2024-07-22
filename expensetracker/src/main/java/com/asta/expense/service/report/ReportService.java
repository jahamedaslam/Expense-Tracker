package com.asta.expense.service.report;

import com.asta.expense.payload.dao.DailyReport;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

public interface ReportService {

    List<DailyReport> getReport(LocalDate fromDate, LocalDate toDate, int type);

    Map<Month, BigDecimal[]> getMonthlyData();
}
