import { RouterModule } from '@angular/router';
import { MaterialModule } from './../../shared/material.module';
import { BookManagementComponent } from './admin-subpages/book-management/book-management.component';
import { SidebarMenuModule } from './../components/sidebar-menu/sidebar-menu.module';
import { AdminRoutingModule } from './admin-routing.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { SendEmailModalComponent } from './admin-subpages/borrow-ticket-management/components/borrow-ticket-detail/send-email-modal/send-email-modal.component';
import { TicketManagementComponent } from './admin-subpages/ticket-management/ticket-management.component';
import { TicketListComponent } from './admin-subpages/ticket-management/components/ticket-list/ticket-list.component';
import {PipeModule} from "../../pipes/pipe/pipe.module";

@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        AdminRoutingModule,
        MaterialModule,
        SidebarMenuModule,
        PipeModule
    ],
  declarations: [AdminComponent, BookManagementComponent, SendEmailModalComponent, TicketManagementComponent, TicketListComponent],
  exports: [BookManagementComponent]
})
export class AdminModule { }
