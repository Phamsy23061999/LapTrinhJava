import { HttpService } from './../services/http.service';
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { ApiAppService } from "./api-app.service";

@Injectable({
  providedIn: "root",
})
export class ApiBorrowTicketService {
  baseURL: string;
  constructor(private http: HttpService, private apiAppService: ApiAppService) {
    this.baseURL = this.apiAppService.baseURL;
  }
  async GetBorrowTickets() {
    return await this.http.post(this.baseURL+"/admin/customer-management/get-borrow-tickets", {}).toPromise();
  }

  async UpdateBorrowTicket(req) {
    return await this.http.post(this.baseURL+"/admin/borrow-ticket-management/update-borrow-ticket",req).toPromise();
  }

  async CreateBorrowTicket(req) {
    return await this.http.post(this.baseURL+"/admin/customer-management/borrow-ticket-book",req).toPromise();
  }

  async DeleteBorrowTicket(req) {
    return await this.http.post(this.baseURL+"/admin/borrow-ticket-management/delete-borrow-ticket",req).toPromise();
  }

  async SearchBorrowTickets(req) {
    return await this.http.post(this.baseURL+"/admin/borrow-ticket-management/search-borrow-tickets",req).toPromise();
  }

  async FinishBorrowTicket(req) {
    return await this.http.post(this.baseURL+"/admin/customer-management/return-book",req).toPromise();
  }

  async SendEmailForLateBorrowTicket(req) {
    return await this.http.post(this.baseURL+"/admin/borrow-ticket-management/send-email-for-late-borrow-ticket",req).toPromise();
  }
}
