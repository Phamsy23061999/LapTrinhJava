import { Component, OnInit } from '@angular/core';
import {ApiEmployeeService} from "../../../../../../API/api-employee.service";
import {BorrowTicketStore} from "../../../../../../states/borrow-ticket-store/borrow-ticket.store";
import {Router} from "@angular/router";

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.scss']
})
export class TicketListComponent implements OnInit {
  tickets = [];
  constructor(
      private router: Router,
      private borrowTicketStore: BorrowTicketStore,
      private employeeApi: ApiEmployeeService
  ) { }

  async ngOnInit() {
    this.tickets = await this.employeeApi.getTickets();
  }


  onViewTicketDetail(borrowTicket) {
    this.borrowTicketStore.update({
      detail_borrow_ticket: borrowTicket
    });
    this.router.navigateByUrl(`/admin/borrow-ticket-management/borrow-ticket-detail/${borrowTicket.id}`);
  }
}
