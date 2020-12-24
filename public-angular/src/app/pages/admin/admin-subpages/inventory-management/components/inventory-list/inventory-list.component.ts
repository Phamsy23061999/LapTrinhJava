import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {BorrowTicketStore} from "../../../../../../states/borrow-ticket-store/borrow-ticket.store";
import {ApiEmployeeService} from "../../../../../../API/api-employee.service";

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.scss']
})
export class InventoryListComponent implements OnInit {
  inventories = [];
  constructor(
      private router: Router,
      private borrowTicketStore: BorrowTicketStore,
      private employeeApi: ApiEmployeeService
  ) { }

  async ngOnInit() {
    this.inventories = await this.employeeApi.getInventories();
  }

}
