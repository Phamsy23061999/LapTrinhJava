import { Component, OnInit } from '@angular/core';
import {OrderQuery} from "../../../../../../states/order-store/order.query";
import {OrderService} from "../../../../../../states/order-store/order.service";
declare var google: any;

@Component({
  selector: 'app-sell-dashboard',
  templateUrl: './sell-dashboard.component.html',
  styleUrls: ['./sell-dashboard.component.scss']
})
export class SellDashboardComponent implements OnInit {
  dashboard: any;
  constructor(
    private orderQuery: OrderQuery,
    private orderService: OrderService
  ) { 
    google.charts.load('current', {'packages': ['corechart'], 'callback': this.drawChart()});
    google.charts.load('current', {'packages': ['corechart'], 'callback': this.drawChart2()});
    google.charts.load('current', {'packages': ['corechart'], 'callback': this.drawChart3()});
  }

  async ngOnInit() {
    this.dashboard = await this.orderService.statistic()
    await google.setOnLoadCallback(this.drawChart());
    google.load("visualization", "1", {packages:["corechart"], 'callback': this.drawChart()});

    // await google.setOnLoadCallback(this.drawChart3());
    // google.load("visualization", "1", {packages:["corechart"], 'callback': this.drawChart3()});

    google.charts.load('current', {'packages':['corechart'], 'callback': this.drawChart2()});
    google.charts.setOnLoadCallback(this.drawChart2());
  }


  convertData(revenues) {
    let revenueData = [["Tháng", "Số phiếu", {role: "style"}]]
    revenues.forEach(revenue => {
      let revenueItem = []
      revenueItem.push(revenue.month);
      revenueItem.push(revenue.count);
      revenueItem.push("stroke-width: 100");
      revenueData.push(revenueItem);
    })
    return revenueData;
  }

  convertData2(revenues) {
    let revenueData = [["Tháng", "Doanh thu"]]
    revenues.forEach(revenue => {
      let revenueItem = []
      revenueItem.push('Tháng '+ revenue.quarter);
      revenueItem.push(revenue.count);
      revenueData.push(revenueItem);
    })
    return revenueData;
  }

  convertData3(revenues) {
    let revenueData = [["Quý ", "Số phiếu", {role: "style"}]]
    revenues.forEach(revenue => {
      let revenueItem = []
      revenueItem.push(revenue.quarter);
      revenueItem.push(revenue.count);
      revenueItem.push("stroke-width: 100");
      revenueData.push(revenueItem);
    })
    return revenueData;
  }

  async drawChart2() {
    this.dashboard = await this.orderService.statistic()
    let revenueData = this.convertData2(this.dashboard.borrow_ticket_count_each_quarter_in_year.value)
    var data = google.visualization.arrayToDataTable(revenueData);
    var options = {
      title: 'Số phiếu mượn,trả mỗi quý trong năm',
      curveType: 'function',
      legend: { position: 'bottom' }
    };

    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

    chart.draw(data, options);
  }

  async drawChart() {
    this.dashboard = await this.orderService.statistic()
    let revenueData = this.convertData(this.dashboard.borrow_ticket_count_of_each_month_in_year.value)
    var data = google.visualization.arrayToDataTable(revenueData);

    var view = new google.visualization.DataView(data);
    view.setColumns([0, 1,
      { calc: "stringify",
        sourceColumn: 1,
        type: "string",
        role: "annotation",
      },
      2]);

    var options = {
      title: "Số phiếu mượn, trả mỗi tháng trong năm",
      bar: {groupWidth: "100%"},
      legend: { position: "none" },
    };
    var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
    chart.draw(view, options);
  }

  async drawChart3() {
    this.dashboard = await this.orderService.statistic()
    let revenueData3 = this.convertData3(this.dashboard.borrow_ticket_count_each_quarter_in_year.value)
    var data = google.visualization.arrayToDataTable(revenueData3);

    var view3 = new google.visualization.DataView(data);
    view3.setColumns([0, 1,
      { calc: "stringify",
        sourceColumn: 1,
        type: "string",
        role: "annotation",
      },
      2]);

    var options3 = {
      title: "Số phiếu mượn, trả mỗi Quý trong năm",
      bar: {groupWidth: "100%"},
      legend: { position: "none" },
    };
    var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values2"));
    chart.draw(view3, options3);
  }
}
